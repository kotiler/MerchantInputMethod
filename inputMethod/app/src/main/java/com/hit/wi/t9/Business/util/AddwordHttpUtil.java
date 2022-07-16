package com.hit.wi.t9.Business.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.entity.Words;
import com.hit.wi.t9.settings.GuideActivity;
import com.hit.wi.t9.settings.WIT9Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddwordHttpUtil {//获取话术
  //  private static Context context;
    private static Activity AppActivity;
    public static void GetRequest(Activity activity, final String url, Words word , final String email) {
        AppActivity=activity;

        Thread thread = new Thread() {//生成线程
            @Override
            public void run() {
                addWords(url, email, word);
                super.run();
            }
        };
        thread.start();
    }

    private static void addWords(String url, String email,Words word) {
        MediaType json = MediaType.parse("application/json;charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        OkHttpClient httpClient = new OkHttpClient();
        try
        {
            if(email ==null)
            {
                Toast.makeText(AppActivity, "请先登录账号！", Toast.LENGTH_LONG).show();
            }
            else{

                jsonObject.put("u_email", email);
              jsonObject.put("w_content",word.getWords());
              jsonObject.put("w_createDate",word.getDate());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(json, String.valueOf(jsonObject));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = httpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Looper.prepare();
                Toast.makeText(AppActivity, "连接失败", Toast.LENGTH_LONG).show();
                Final.isFinishedGetWords = true;
                Looper.loop();
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException{
                try {
                    Log.d("LoginHttpUtil","chinese");
                    JSONObject myResult = new JSONObject(response.body().string());
                    if(myResult.get("code").toString().equals("7000")){
                        Looper.prepare();
                        Toast.makeText(AppActivity, "成功添加个人话术", Toast.LENGTH_LONG).show();
                        AppActivity.startActivity(new Intent(AppActivity, WIT9Activity.class));
                        AppActivity.finish();
                        Looper.loop();
                    }
                    else if(myResult.get("code").toString().equals("7001")){
                        Looper.prepare();
                        Toast.makeText(AppActivity, "添加失败，话术已存在", Toast.LENGTH_LONG).show();
                        Looper.loop();
                    }

                } catch (JSONException e) {e.printStackTrace();}
            }
        });

    }
}
