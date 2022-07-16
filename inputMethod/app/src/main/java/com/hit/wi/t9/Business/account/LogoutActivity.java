package com.hit.wi.t9.Business.account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.util.BaseActivity;
import com.hit.wi.t9.R;
import com.hit.wi.t9.settings.WIT9Activity;
import com.umeng.analytics.MobclickAgent;

public class LogoutActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);

        AlertDialog.Builder builder = new AlertDialog.Builder(LogoutActivity.this);
        builder.setTitle("退出登录").setMessage("确认退出")
                .setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Final.u_email="";
                        Final.isLogin = false;
                        Toast.makeText(LogoutActivity.this, "退出登录成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogoutActivity.this, WIT9Activity.class));
                    }
        }).setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LogoutActivity.this, "取消退出登录", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LogoutActivity.this, WIT9Activity.class));

            }
        }).show();
    }

    @Override
    protected void onResume() {

        super.onResume();
        MobclickAgent.onResume(this);
    }

        @Override
        protected void onPause() {
            MobclickAgent.onPause(this);
            super.onPause();
        }
}
