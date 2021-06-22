package com.yilan.sdk.data.demo;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Author And Date: liurongzhi on 2021/6/19.
 * Description: com.yilan.sdk.data.demo
 */
public class SHAUtil {
    public static String sdkDecode(String secret,String data) throws Exception {
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HMACSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            byte[] bytes = mac.doFinal(data.getBytes("UTF-8"));
            String encodedString = android.util.Base64.encodeToString(bytes, android.util.Base64.DEFAULT);
            return encodedString.trim();

        } catch (Exception gse) {
            throw new Exception("sdkDecode fail", gse);
        }

    }
}
