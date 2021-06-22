package com.yilan.sdk.data.demo;

/**
 * Created by lihu on 2018/1/27.
 */


import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AESUtil {

    private IvParameterSpec ivSpec;
    private SecretKeySpec keySpec;


    public AESUtil(String key, String iv) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(key);
            if (builder.length()>32){
                builder.setLength(32);
            }
            if (builder.length()<32){
                while (builder.length()<32){
                    builder.append(" ");
                }
            }
            this.keySpec = new SecretKeySpec(builder.toString().getBytes(), "AES");
            StringBuilder builder2 = new StringBuilder();
            builder2.append(iv);
            if (builder2.length()>16){
                builder2.setLength(16);
            }
            if (builder2.length()<16){
                while (builder2.length()<16){
                    builder2.append("0");
                }
            }
            this.ivSpec = new IvParameterSpec(builder2.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public byte[] encrypt(byte[] origData) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, this.keySpec, this.ivSpec);
            return cipher.doFinal(origData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] encrypt(byte[] origData, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, this.keySpec, this.ivSpec);
            return cipher.doFinal(origData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decrypt(byte[] crypted) {
        try {
            byte[] result = base64Decode(crypted);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, this.keySpec, this.ivSpec);
            return cipher.doFinal(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String base64Encode(byte[] data) {
        String encodedString = Base64.encodeToString(data, Base64.NO_WRAP);
        return encodedString.trim();
    }

    public static byte[] base64Decode(byte[] data) {
        return Base64.decode(data, Base64.DEFAULT);
    }

}
