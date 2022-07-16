package com.hit.wi.t9.Business.util;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import android.support.annotation.NonNull;

import com.hit.wi.t9.Business.entity.Final;
import com.hit.wi.t9.Business.entity.UserWords;

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

public class CompanyWordsHttpUtil {//获取话术
    private static Context context;

    public static void GetRequest(Context context_, final String url, final String email, int checkState,String w_content) {
        context = context_;
        Thread thread = new Thread() {//生成线程
            @Override
            public void run() {
                getWords(url, email, checkState,w_content);
                super.run();
            }
        };
        thread.start();
    }

    private static void getWords(String url, String email, int checkState,String w_content) {
        MediaType json = MediaType.parse("application/json;charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        OkHttpClient httpClient = new OkHttpClient();
        try {
            jsonObject.put("u_email", email);
            if(checkState == 1){//如果是公司话术
                jsonObject.put("w_checkState", checkState);//获取已审核的商品
            }
            if(!w_content.equals(""))
                jsonObject.put("w_content", w_content);
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
                Toast.makeText(context, "获取话术失败", Toast.LENGTH_LONG).show();
                Final.isFinishedGetWords = true;
                Looper.loop();
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException{
                try {
                    if (response.body().contentLength() != 0) {
                        JSONArray myResult = new JSONArray(response.body().string());

                        Final.Companywords.clear();

                        for (int i = 0; i < myResult.length(); i++) {

                            String words_content=myResult.getJSONObject(i).get("w_content").toString();


                            UserWords Companywords =new UserWords(words_content);

                            Final.Companywords.add(Companywords);
                        }
                    }
                    Final.isFinishedGetWords = true;
                } catch (JSONException e) {e.printStackTrace();}
            }
        });
    }
}
