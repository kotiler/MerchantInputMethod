package com.hit.wi.t9.Business.account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.util.BaseActivity;
import com.hit.wi.t9.R;
import com.hit.wi.t9.settings.WIT9Activity;

public class JudgeAddWords extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addword_judge);

        if (!Final.isLogin) {
            //   Toast.makeText(AddWords_Judge.this, "请先登录", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(JudgeAddWords.this);
            builder.setTitle("警告").setMessage("请先登录")
                    .setNegativeButton("点击登录", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Final.u_email = "";
                            Final.isLogin = false;
                            //    Toast.makeText(AddWords_Judge.this, "请先登录", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(JudgeAddWords.this, LoginActivity.class));
                        }
                    }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(AddWords_Judge.this, "未登录无法添加个人话术", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(JudgeAddWords.this, WIT9Activity.class));
                }
            }).show();
        }else{
            startActivity(new Intent(JudgeAddWords.this, AddWordsActivity.class));
        }
    }

}
