package com.hit.wi.t9.Business.account;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hit.wi.t9.Business.util.GoodsHttpUtil;
import com.hit.wi.t9.Business.util.ImageUtils;
import com.hit.wi.t9.R;
import com.hit.wi.application.MyApplication;
import com.hit.wi.t9.Business.adapter.UserWordsAdapter;
import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.util.BaseActivity;
import com.hit.wi.t9.Business.util.UserWordsHttpUtil;
import com.hit.wi.t9.settings.WIT9Activity;

public class ShowUserWordsActivity extends BaseActivity {
    private static boolean canRequest=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showuserwords_layout);

        if (!Final.isLogin) {
            //   Toast.makeText(AddWords_Judge.this, "请先登录", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(ShowUserWordsActivity.this);
            builder.setTitle("警告").setMessage("请先登录")
                    .setNegativeButton("点击登录", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Final.u_email = "";
                            Final.isLogin = false;
                            //    Toast.makeText(AddWords_Judge.this, "请先登录", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ShowUserWordsActivity.this, LoginActivity.class));
                        }
                    }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(AddWords_Judge.this, "未登录无法添加个人话术", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ShowUserWordsActivity.this, WIT9Activity.class));
                }
            }).show();
        } else {
            //连接接口，获取数据
            Final.isFinishedGetWords = false;
            UserWordsHttpUtil.GetRequest(ShowUserWordsActivity.this, "http://" + MyApplication.ip + ":" + MyApplication.port + "/userwords/searchUserWords", Final.u_email, 1, "");
            while (true) {
                if (Final.isFinishedGetWords)
                    break;
            }

            //找到RecycleView控件
            RecyclerView imageRecyclerView = (RecyclerView) findViewById(R.id.words_recycler_view);
            //使用线性布局
            LinearLayoutManager layoutManager = new LinearLayoutManager(ShowUserWordsActivity.this);
            imageRecyclerView.setLayoutManager(layoutManager);

            //初始化适配器
            UserWordsAdapter adapter = new UserWordsAdapter(ShowUserWordsActivity.this, Final.Userwords);
            imageRecyclerView.setAdapter(adapter);


            //test
            Button userwords_search_btn = (Button) findViewById(R.id.userwords_search_btn);
            EditText userwords_edit = (EditText) findViewById(R.id.userwords_edit);


            userwords_search_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!canRequest) { return; }

                    String str = userwords_edit.getText().toString();

                    Final.isFinishedGetWords = false;
                    canRequest=false;
                    UserWordsHttpUtil.GetRequest(ShowUserWordsActivity.this, "http://" + MyApplication.ip +
                            ":" + MyApplication.port + "/userwords/searchUserWords", Final.u_email, 1, str);
                    while (true) {
                        if (Final.isFinishedGetWords)
                            break;
                    }
                    if(Final.Userwords.size()==0){
                        Toast.makeText(ShowUserWordsActivity.this, "没有找到相关话术", Toast.LENGTH_SHORT).show();
                    }
                    //在这里进行UI操作，将结果显示到界面上
                    imageRecyclerView.setAdapter(adapter);
                    canRequest=true;


//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try{
//                                canRequest=false;
//                                UserWordsHttpUtil.GetRequest(ShowUserWordsActivity.this, "http://" + MyApplication.ip +
//                                        ":" + MyApplication.port + "/userwords/searchUserWords", Final.u_email, 1, str);
//
//                                //安卓不允许子线程进行UI操作，所以这里用runOnUiThread方法将线程更换到主线程，再更新UI元素
//                                ShowUserWordsActivity.this.runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        if(Final.Userwords.size()==0){
//                                            Toast.makeText(ShowUserWordsActivity.this, "没有找到相关话术", Toast.LENGTH_SHORT).show();
//                                        }
//                                        //在这里进行UI操作，将结果显示到界面上
//                                        imageRecyclerView.setAdapter(adapter);
//                                        canRequest=true;
//                                    }
//                                });
//                            }catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();

                }
            });


        }
    }
}


