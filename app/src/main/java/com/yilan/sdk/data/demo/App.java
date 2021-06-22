package com.yilan.sdk.data.demo;

import android.app.Application;

/**
 * Author And Date: liurongzhi on 2021/6/19.
 * Description: com.yilan.sdk.data.demo
 */
public class App extends Application {
    public static App app;
    public static final String YL_KEY = "ylel2vek386q";
    public static final String YL_TOKEN = "talb5el4cbw3e8ad3jofbknkexi1z8r4";

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
