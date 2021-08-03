package com.yilan.sdk.data.demo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/**
 * Author And Date: liurongzhi on 2021/6/19.
 * Description: com.yilan.sdk.data.demo
 */
public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, 1024);
            }
        }
        findViewById(R.id.video_feed).setOnClickListener(this);

        findViewById(R.id.get_channel).setOnClickListener(this);

        findViewById(R.id.relation).setOnClickListener(this);

        findViewById(R.id.video_detail).setOnClickListener(this);

        findViewById(R.id.cp_info).setOnClickListener(this);

        findViewById(R.id.cp_video).setOnClickListener(this);

        findViewById(R.id.video_url).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.video_feed:
                Net.REQUEST.getVideoFeed(new CallBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("----video/feed success :" + s);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String msg) {
                        System.out.println("----video/feed error :" + code + "," + msg);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
            case R.id.get_channel:
                Net.REQUEST.getChannel(new CallBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("----video/channels success :" + s);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String msg) {
                        System.out.println("----video/channels error :" + code + "," + msg);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;

            case R.id.relation:
                Net.REQUEST.getRelation(new CallBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("----video/relation success :" + s);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String msg) {
                        System.out.println("----video/relation error :" + code + "," + msg);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
            case R.id.video_detail:
                Net.REQUEST.getVideoDetail(new CallBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("----video/getvideos success :" + s);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String msg) {
                        System.out.println("----video/getvideos error :" + code + "," + msg);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
            case R.id.video_url:
                Net.REQUEST.getPlayUrl(new CallBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("----video/play success :" + s);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String msg) {
                        System.out.println("----video/play error :" + code + "," + msg);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;

            case R.id.cp_info:
                Net.REQUEST.getCpInfo(new CallBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("----video/cpinfo success :" + s);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String msg) {
                        System.out.println("----video/cpinfo error :" + code + "," + msg);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;

            case R.id.cp_video:
                Net.REQUEST.getCpVideos(new CallBack<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("----video/cpvideos success :" + s);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onError(int code, String msg) {
                        System.out.println("----video/cpvideos error :" + code + "," + msg);
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                break;
        }
    }

    public void showToast(String s) {

    }
}
