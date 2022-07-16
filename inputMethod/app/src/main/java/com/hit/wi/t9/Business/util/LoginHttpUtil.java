package com.hit.wi.t9.Business.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.entity.LoginUser;
import com.hit.wi.t9.settings.GuideActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginHttpUtil {
    private static Activity AppActivity;

    public static void GetRequest(Activity activity, final String url, final LoginUser user) {
        AppActivity = activity;
        Thread thread = new Thread() {//生成线程
            @Override
            public void run() {
                login(url, user);
                super.run();
            }
        };
        thread.start();
    }

    private static void login(String url, LoginUser user) {
        MediaType json = MediaType.parse("application/json;charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        OkHttpClient httpClient = new OkHttpClient();
        try {
            jsonObject.put("u_email", user.getUserName());
            jsonObject.put("u_password", user.getUserPassword());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(json, String.valueOf(jsonObject));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = httpClient.newCall(request);
        Log.d("TAG", call.toString());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Looper.prepare();
                Toast.makeText(AppActivity, "登录失败", Toast.LENGTH_LONG).show();
                Looper.loop();

            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException{
                try {
                    JSONObject myResult = new JSONObject(response.body().string());
                    if(myResult.get("code").toString().equals("2004")){
                        Looper.prepare();
                        Toast.makeText(AppActivity, "登录成功", Toast.LENGTH_LONG).show();
                        Final.isLogin = true;
                        AppActivity.startActivity(new Intent(AppActivity, GuideActivity.class));
                        AppActivity.finish();
                        Looper.loop();
                    }
                    else if(myResult.get("code").toString().equals("2001")){
                        Looper.prepare();
                        Toast.makeText(AppActivity, "登录失败，邮箱不存在", Toast.LENGTH_LONG).show();
                        Looper.loop();
                    }
                    else if(myResult.get("code").toString().equals("2002")){
                        Looper.prepare();
                        Toast.makeText(AppActivity, "登录失败，密码错误", Toast.LENGTH_LONG).show();
                        Looper.loop();
                    }
                } catch (JSONException e) {e.printStackTrace();}
            }
        });
    }
}