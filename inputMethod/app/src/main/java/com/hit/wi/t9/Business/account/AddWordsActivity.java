package com.hit.wi.t9.Business.account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hit.wi.application.MyApplication;
import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.entity.Words;
import com.hit.wi.t9.Business.util.AddwordHttpUtil;
import com.hit.wi.t9.Business.util.BaseActivity;
import com.hit.wi.t9.R;
import com.hit.wi.t9.settings.WIT9Activity;

import java.text.SimpleDateFormat;
import java.util.Date;

//添加话术；
public class AddWordsActivity extends BaseActivity {
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        if (!Final.isLogin) {
//            //   Toast.makeText(AddWords_Judge.this, "请先登录", Toast.LENGTH_SHORT).show();
//            AlertDialog.Builder builder = new AlertDialog.Builder(AddWordsActivity.this);
//            builder.setTitle("警告").setMessage("请先登录")
//                    .setNegativeButton("点击登录", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Final.u_email = "";
//                            Final.isLogin = false;
//                            //    Toast.makeText(AddWords_Judge.this, "请先登录", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(AddWordsActivity.this, LoginActivity.class));
//                        }
//                    }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    //Toast.makeText(AddWords_Judge.this, "未登录无法添加个人话术", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(AddWordsActivity.this, WIT9Activity.class));
//                }
//            }).show();
//        } else {
            setContentView(R.layout.addword_layout);
            content = (EditText) findViewById(R.id.add_content);
            Button sure = (Button) findViewById(R.id.ok);
            Button cancel = (Button) findViewById(R.id.no);
            sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Final.isLogin) {
                        String Content = content.getText().toString();
                        if(Content.equals("")) {
                            Toast.makeText(AddWordsActivity.this, "内容不可为空！", Toast.LENGTH_SHORT).show();
                        }else {
                            final Words word = new Words();

                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = new Date(System.currentTimeMillis());
                            String date1 = simpleDateFormat.format(date);
                            word.setWords(Content);
                            word.setDate(date1);
                            Log.e("date", "" + date.toString());
                            AddwordHttpUtil.GetRequest(AddWordsActivity.this, "http://" + MyApplication.ip + ":" + MyApplication.port + "/userwords/addUserWords", word, Final.u_email);
                        }
                    }else {
                        Toast.makeText(AddWordsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(AddWordsActivity.this, WIT9Activity.class);
                    startActivity(intent);
                }
            });
        }
    //}

}
