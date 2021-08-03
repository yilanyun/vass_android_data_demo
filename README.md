# DEMO说明

### 一.核心类

1.Net : 负责具体的网络请求 各接口参数说明详见api文档，包括接口：

```java
 //获取分类
public void getChannel(CallBack<String> callBack);
//分类视频，
public void getVideoFeed(CallBack<String> callBack)
//相关视频，
public void getRelation(CallBack<String> callBack)
//视频详情，
public void getVideoDetail(CallBack<String> callBack)
//作者详情，
public void getCpInfo(CallBack<String> callBack)
//作者视频，
public void getCpVideos(CallBack<String> callBack)
//播放地址
public void getPlayUrl(CallBack<String> callBack)
```

```
//常量含义：
baseUrl = "https://api.yilanvaas.cn/mallen"; 接口的域名

basePlayUrl = "http://play.yilanvaas.cn";获取播放地址专用域名
```



2.AESUtil ：负责加密请求参数,通过key 和token创建，生成SecretKeySpec和IvParameterSpec，进而进行加解密

3.SHAUtil ：负责通过密文生成签名信息 sign

```
//使用方式详见 Net中 getSign(long timestamp, String data)方法
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
```



4.MainActivity：测试的页面

5.App: 继承自Application，体验demo前，请先给YL_KEY 和YL_TOKEN 赋值



### 二.效果测试：

MainActivity 中列举了Net中的所有接口,点击即可获取接口返回的json数据

