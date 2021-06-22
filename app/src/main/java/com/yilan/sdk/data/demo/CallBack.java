package com.yilan.sdk.data.demo;

/**
 * Author And Date: liurongzhi on 2021/6/19.
 * Description: com.yilan.sdk.data.demo
 */
interface CallBack<T> {
    void onSuccess(T t);

    void onError(int code,String msg);
}
