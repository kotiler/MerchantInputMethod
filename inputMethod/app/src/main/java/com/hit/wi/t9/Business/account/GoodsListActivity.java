package com.hit.wi.t9.Business.account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hit.wi.application.MyApplication;
import com.hit.wi.t9.Business.adapter.GoodsAdapter;
import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.util.BaseActivity;
import com.hit.wi.t9.Business.util.GoodsHttpUtil;
import com.hit.wi.t9.Business.util.ImageUtils;
import com.hit.wi.t9.Business.util.UserWordsHttpUtil;
import com.hit.wi.t9.Business.util.Utils;
import com.hit.wi.t9.R;
import com.hit.wi.t9.settings.WIT9Activity;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

public class GoodsListActivity extends BaseActivity {
    private boolean canRequest = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_layout);
        if (!Final.isLogin) {
            //   Toast.makeText(AddWords_Judge.this, "请先登录", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(GoodsListActivity.this);
            builder.setTitle("警告").setMessage("请先登录")
                    .setNegativeButton("点击登录", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Final.u_email = "";
                            Final.isLogin = false;
                            //    Toast.makeText(AddWords_Judge.this, "请先登录", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(GoodsListActivity.this, LoginActivity.class));
                        }
                    }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(AddWords_Judge.this, "未登录无法添加个人话术", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(GoodsListActivity.this, WIT9Activity.class));
                }
            }).show();
        } else {
            //连接接口，获取数据
            ImageUtils.isFinishedGetGoods = false;
            GoodsHttpUtil.GetRequest(GoodsListActivity.this, "http://" + MyApplication.ip + ":" +
                    MyApplication.port + "/goods/searchGoods", Final.u_email,"");
            while (true) {
                if (ImageUtils.isFinishedGetGoods)
                    break;
            }
//            ImageUtils.isFinishedGetGoods = false;
            //找到RecycleView控件
            RecyclerView imageRecyclerView = (RecyclerView) findViewById(R.id.image_recycler_view);
            //使用线性布局
            LinearLayoutManager layoutManager = new LinearLayoutManager(GoodsListActivity.this);
            imageRecyclerView.setLayoutManager(layoutManager);

            //初始化适配器
            GoodsAdapter adapter = new GoodsAdapter(GoodsListActivity.this, ImageUtils.goods);
            imageRecyclerView.setAdapter(adapter);


            //test
            Button goods_search_btn=(Button) findViewById(R.id.goods_search_btn);
            EditText goods_name=(EditText) findViewById(R.id.goods_name);

            goods_search_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        if (!canRequest) { return; }

                        String g_name=goods_name.getText().toString();


                    ImageUtils.isFinishedGetGoods = false;
                    canRequest=false;
                    GoodsHttpUtil.GetRequest(GoodsListActivity.this, "http://" + MyApplication.ip + ":" +
                            MyApplication.port + "/goods/searchGoods", Final.u_email,g_name);
                    while (true) {
                        if (ImageUtils.isFinishedGetGoods)
                            break;
                    }

                    if(ImageUtils.goods.size()==0){
                        Toast.makeText(GoodsListActivity.this, "没有找到此类商品", Toast.LENGTH_SHORT).show();
                    }
                    //在这里进行UI操作，将结果显示到界面上
                    imageRecyclerView.setAdapter(adapter);
                    canRequest=true;

//                    ImageUtils.isFinishedGetGoods = false;




//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                try{
////                                    canRequest=false;
//                                    GoodsHttpUtil.GetRequest(GoodsListActivity.this, "http://" + MyApplication.ip + ":" +
//                                            MyApplication.port + "/goods/searchGoods", Final.u_email,g_name);
//                                    //安卓不允许子线程进行UI操作，所以这里用runOnUiThread方法将线程更换到主线程，再更新UI元素
//                                    GoodsListActivity.this.runOnUiThread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            if(ImageUtils.goods.size()==0){
//                                                Toast.makeText(GoodsListActivity.this, "没有找到此类商品", Toast.LENGTH_SHORT).show();
//                                            }
//                                            //在这里进行UI操作，将结果显示到界面上
//                                            imageRecyclerView.setAdapter(adapter);
//                                            canRequest=true;
//                                        }
//                                    });
//                                }catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }).start();

                }
            });
        }

    }
}
