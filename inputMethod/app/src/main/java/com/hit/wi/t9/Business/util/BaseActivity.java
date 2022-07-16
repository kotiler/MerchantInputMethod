package com.hit.wi.t9.Business.util;

import android.app.Activity;
import android.os.Bundle;

import com.hit.wi.t9.Business.util.ActivityCollector;


public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);//添加到活动集合里面去；
    }

    //销毁之后，移除；
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
