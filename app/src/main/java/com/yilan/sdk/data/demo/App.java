package com.yilan.sdk.data.demo;

import android.app.Application;

/**
 * Author And Date: liurongzhi on 2021/6/19.
 * Description: com.yilan.sdk.data.demo
 */
public class App extends Application {
    public static App app;
    public static final String YL_KEY = "";
    public static final String YL_TOKEN = "";

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
