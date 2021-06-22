package com.yilan.sdk.data.demo;

import java.io.Serializable;

/**
 * Author And Date: liurongzhi on 2021/6/19.
 * Description: com.yilan.sdk.data.demo
 */
public class RequestEntity implements Serializable {
    String access_key = App.YL_KEY;
    String params;
    String sign;
    long timestamp;

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
