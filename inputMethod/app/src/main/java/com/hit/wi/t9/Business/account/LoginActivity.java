package com.hit.wi.t9.Business.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


import com.hit.wi.application.MyApplication;
import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.entity.LoginUser;
import com.hit.wi.t9.Business.util.BaseActivity;
import com.hit.wi.t9.Business.util.LoginHttpUtil;
import com.hit.wi.t9.R;

public class LoginActivity extends BaseActivity {


    private SharedPreferences pref;//构建对象

    private SharedPreferences.Editor editor;

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button login;

    private Button register;

    public LoginUser myuser;
    //   private  DatabaseHelper dbhelper;

    private CheckBox rememberPass;//复选框；
    //private accountlist<Map<String,String>;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context ctx = LoginActivity.this;
        pref = ctx.getSharedPreferences("pref", MODE_PRIVATE);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);


        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button) findViewById(R.id.login);
        //布尔代数
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            // 将账号和密码都设置到文本框中
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                final LoginUser User=new LoginUser();
//                User.setUserName(account.toString());                 //这里不用填充数据，后面再填充全局变量（u_email）的数据
                User.setUserPassword(password.toString());
                editor = pref.edit();
                if (rememberPass.isChecked()) { // 检查复选框是否被选中
                    editor.putBoolean("remember_password", true);
                    editor.putString("account", account);
                    editor.putString("password", password);
                } else {
                    editor.clear();
                }
                editor.apply();

                //获取文本框的账号，设为全局变量
                Final.u_email=account;              //新增
                User.setUserName(Final.u_email);    //新增

                LoginHttpUtil.GetRequest(LoginActivity.this, "http://"+ MyApplication.ip +":"+ MyApplication.port +"/user/login", User);

            }
        });
    }




}