package com.example.lrucachedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lrucachedemo.utils.MyBitmapUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_img;
    private String path = "http://dynamic-image.yesky.com/300x-/uploadImages/upload/20140822/upload/201408/1ftxyp54kozjpg.jpg";
    private MyBitmapUtils myBitmapUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_img = findViewById(R.id.iv_img);

        myBitmapUtils = new MyBitmapUtils();

    }

    public void bt_show(View view)
    {
        myBitmapUtils.disPlay(iv_img,path);
    }
}
