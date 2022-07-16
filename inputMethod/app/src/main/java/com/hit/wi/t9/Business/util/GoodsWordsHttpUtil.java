package com.hit.wi.t9.Business.util;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.hit.wi.t9.Business.entity.Final;

import org.json.JSONArray;
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

public class GoodsWordsHttpUtil {
    private static Context context;

    public static void GetRequest(Context context_, final String url, final String email, final String goodsName) {
        context = context_;
        Thread thread = new Thread() {//生成线程
            @Override
            public void run() {
                getWords(url, email, goodsName);
                super.run();
            }
        };
        thread.start();
    }

    private static void getWords(String url, String email, String goodsName) {
        MediaType json = MediaType.parse("application/json;charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        OkHttpClient httpClient = new OkHttpClient();
        try {
            jsonObject.put("u_email", email);
            jsonObject.put("g_name", goodsName);//获取已审核的商品
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
                Toast.makeText(context, "获取商品话术失败", Toast.LENGTH_LONG).show();
                Final.isFinishedGetWords = true;
                Looper.loop();
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException{
                try {
                    if (response.body().contentLength() != 0) {
                        JSONArray myResult = new JSONArray(response.body().string());

                        Final.goodsWords.clear();
                        for (int i = 0; i < myResult.length(); i++) {
                            Final.goodsWords.add(myResult.getJSONObject(i).get("w_content").toString());
                        }
                    }
                    Final.isFinishedGetWords = true;
                } catch (JSONException e) {e.printStackTrace();}
            }
        });
    }
}
