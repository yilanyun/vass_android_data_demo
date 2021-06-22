package com.yilan.sdk.data.demo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Author And Date: liurongzhi on 2021/6/19.
 * Description: com.yilan.sdk.data.demo
 */
public class Net {
    public static final Net REQUEST = new Net();
    private final String baseUrl = "http://testapi.yladm.com/mallen";
    private final String basePlayUrl = "http://play.yilanvaas.cn";
    private final OkHttpClient client;
    private final AESUtil aesUtil = new AESUtil(App.YL_TOKEN, App.YL_TOKEN);

    private Net() {
        client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public void getChannel(CallBack<String> callBack) {
        HttpUrl httpUrl = HttpUrl.parse(baseUrl + "/video/channels");
        HttpUrl.Builder httpBuilder = httpUrl.newBuilder();

        JSONObject body = new JSONObject();
        JSONObject params = new JSONObject();
        try {
            params.put("udid", getDeviceID(App.app));
            params.put("pkg_name", App.app.getPackageName());
            params.put("platform", 1);
            //加密 params
            String paramsJson = aesUtil.base64Encode(aesUtil.encrypt(params.toString().getBytes()));
            body.put("params", paramsJson);
            body.put("access_key", App.YL_KEY);
            long time = System.currentTimeMillis();
            body.put("timestamp", time);
            body.put("sign", getSign(time, paramsJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        request(callBack, httpBuilder, body);
    }

    public void getVideoFeed(CallBack<String> callBack) {
        HttpUrl httpUrl = HttpUrl.parse(baseUrl + "/video/feed");
        HttpUrl.Builder httpBuilder = httpUrl.newBuilder();

        JSONObject body = new JSONObject();
        JSONObject params = new JSONObject();
        try {
            params.put("udid", getDeviceID(App.app));
            params.put("pkg_name", App.app.getPackageName());
            params.put("platform", 1);
            params.put("video_type", 1);//视频类型，1-横屏，2-竖屏
            params.put("channel_id", 10169);//频道ID
            params.put("load_type", 2);//0-上拉，1-下拉，2-首次刷新
            params.put("size", 8);//页大小，范围 1～8
            //加密 params
            String paramsJson = aesUtil.base64Encode(aesUtil.encrypt(params.toString().getBytes()));
            body.put("params", paramsJson);
            body.put("access_key", App.YL_KEY);
            long time = System.currentTimeMillis();
            body.put("timestamp", time);
            body.put("sign", getSign(time, paramsJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        request(callBack, httpBuilder, body);
    }

    public void getRelation(CallBack<String> callBack) {
        HttpUrl httpUrl = HttpUrl.parse(baseUrl + "/video/relation");
        HttpUrl.Builder httpBuilder = httpUrl.newBuilder();

        JSONObject body = new JSONObject();
        JSONObject params = new JSONObject();
        try {
            params.put("udid", getDeviceID(App.app));
            params.put("pkg_name", App.app.getPackageName());
            params.put("platform", 1);

            params.put("id", "Lnj3pevlX5J6");//视频id
            params.put("size", 8);//页大小，范围 1～8
            //加密 params
            String paramsJson = aesUtil.base64Encode(aesUtil.encrypt(params.toString().getBytes()));
            body.put("params", paramsJson);
            body.put("access_key", App.YL_KEY);
            long time = System.currentTimeMillis();
            body.put("timestamp", time);
            body.put("sign", getSign(time, paramsJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        request(callBack, httpBuilder, body);
    }

    public void getVideoDetail(CallBack<String> callBack) {
        HttpUrl httpUrl = HttpUrl.parse(baseUrl + "/video/getvideos");
        HttpUrl.Builder httpBuilder = httpUrl.newBuilder();

        JSONObject body = new JSONObject();
        JSONObject params = new JSONObject();
        try {
            params.put("udid", getDeviceID(App.app));
            params.put("pkg_name", App.app.getPackageName());
            params.put("platform", 1);

            params.put("ids", "Lnj3pevlX5J6");//视频id,可传多个，用"," 隔开
            params.put("video_type", 1);//页大小，范围 1～8
            //加密 params
            String paramsJson = aesUtil.base64Encode(aesUtil.encrypt(params.toString().getBytes()));
            body.put("params", paramsJson);
            body.put("access_key", App.YL_KEY);
            long time = System.currentTimeMillis();
            body.put("timestamp", time);
            body.put("sign", getSign(time, paramsJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        request(callBack, httpBuilder, body);
    }

    public void getCpInfo(CallBack<String> callBack) {
        HttpUrl httpUrl = HttpUrl.parse(baseUrl + "/video/cpinfo");
        HttpUrl.Builder httpBuilder = httpUrl.newBuilder();

        JSONObject body = new JSONObject();
        JSONObject params = new JSONObject();
        try {
            params.put("udid", getDeviceID(App.app));
            params.put("pkg_name", App.app.getPackageName());
            params.put("platform", 1);

            params.put("id", "qJy8nVw1ojRY");//视频id
            params.put("video_type", 1);//页大小，范围 1～8
            //加密 params
            String paramsJson = aesUtil.base64Encode(aesUtil.encrypt(params.toString().getBytes()));
            body.put("params", paramsJson);
            body.put("access_key", App.YL_KEY);
            long time = System.currentTimeMillis();
            body.put("timestamp", time);
            body.put("sign", getSign(time, paramsJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        request(callBack, httpBuilder, body);
    }

    public void getCpVideos(CallBack<String> callBack) {
        HttpUrl httpUrl = HttpUrl.parse(baseUrl + "/video/cpvideos");
        HttpUrl.Builder httpBuilder = httpUrl.newBuilder();

        JSONObject body = new JSONObject();
        JSONObject params = new JSONObject();
        try {
            params.put("udid", getDeviceID(App.app));
            params.put("pkg_name", App.app.getPackageName());
            params.put("platform", 1);

            params.put("id", "qJy8nVw1ojRY");//视频id
            params.put("video_type", 1);//页大小，范围 1～8
            params.put("page", 1);//页数，从1开始
            params.put("size", 8);//每一页个数
            //加密 params
            String paramsJson = aesUtil.base64Encode(aesUtil.encrypt(params.toString().getBytes()));
            body.put("params", paramsJson);
            body.put("access_key", App.YL_KEY);
            long time = System.currentTimeMillis();
            body.put("timestamp", time);
            body.put("sign", getSign(time, paramsJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        request(callBack, httpBuilder, body);
    }

    public void getPlayUrl(CallBack<String> callBack) {
        HttpUrl httpUrl = HttpUrl.parse(basePlayUrl + "/vaas/video/play");
        HttpUrl.Builder httpBuilder = httpUrl.newBuilder();

        JSONObject body = new JSONObject();
        JSONObject params = new JSONObject();
        try {
            params.put("udid", getDeviceID(App.app));
            params.put("pkg_name", App.app.getPackageName());
            params.put("platform", 1);

            params.put("id", "Lnj3pevlX5J6");//视频id

            //加密 params
            String paramsJson = aesUtil.base64Encode(aesUtil.encrypt(params.toString().getBytes()));
            body.put("params", paramsJson);
            body.put("access_key", App.YL_KEY);
            long time = System.currentTimeMillis();
            body.put("timestamp", time);
            body.put("sign", getSign(time, paramsJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        request(callBack, httpBuilder, body);
    }

    private void request(CallBack<String> callBack, HttpUrl.Builder httpBuilder, JSONObject body) {

        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), body.toString());
        okhttp3.Request request = new okhttp3.Request.Builder().post(requestBody).url(httpBuilder.build()).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onError(500, e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    callBack.onSuccess(processData(response.body().string()));
                } else {
                    callBack.onError(response.code(), response.body().string());
                }
            }
        });
    }

    private String processData(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            String data = jsonObject.getString("data");
            String realData = new String(aesUtil.decrypt(data.getBytes()));
            jsonObject.remove("data");
            if (realData.startsWith("{")) {
                jsonObject.put("data", new JSONObject(realData));
            } else if (realData.startsWith("[")) {
                jsonObject.put("data", new JSONArray(realData));
            }
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    private String deviceID;

    private String getDeviceID(Context context) {
        if (deviceID != null) return deviceID;
        if (context == null) {
            return "";
        }
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try {
            if (PackageManager.PERMISSION_GRANTED == context.getPackageManager().checkPermission(Manifest.permission.READ_PHONE_STATE, context.getPackageName())) {
                deviceID = tm.getDeviceId();
            }
            return deviceID;
        } catch (Exception e) {
        }
        return "";
    }

    private String getSign(long timestamp, String data) {

        String sign = "";
        try {
            sign = SHAUtil.sdkDecode(App.YL_TOKEN + timestamp, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }
}
