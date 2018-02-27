package com.example.lrucachedemo.utils;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.example.lrucachedemo.R;

public class MyBitmapUtils {
    private NetCacheUtils mNetCacheUtils;//网络缓存
    private LocalCacheUtils mLocalCacheUtils;//本地缓存
    private MemoryCacheUtils mMemoryCacheUtils;//内存缓存

    public MyBitmapUtils(){
        mMemoryCacheUtils=new MemoryCacheUtils();
        mLocalCacheUtils=new LocalCacheUtils();
        mNetCacheUtils=new NetCacheUtils(mLocalCacheUtils,mMemoryCacheUtils);
    }

    public void disPlay(ImageView iv_img, String url)
    {
        iv_img.setImageResource(R.mipmap.ic_launcher);
        Bitmap bitmap;

        //内存缓存
        bitmap=mMemoryCacheUtils.getBitmapFromMemory(url);
        if (bitmap!=null){
            iv_img.setImageBitmap(bitmap);
            System.out.println("从内存缓存读取图片啦...");
            return;
        }





        //本地缓存
        bitmap = mLocalCacheUtils.getBitmapFromLocal(url);
       if(bitmap !=null){
           iv_img.setImageBitmap(bitmap);
            //System.out.println("从本地获取图片啦.....");
            //从本地获取图片后,保存至内存中
            mMemoryCacheUtils.setBitmapToMemory(url,bitmap);
           System.out.println("从本地缓存读取图片啦...");
            return;
        }

        //网络缓存
        mNetCacheUtils.getBitmapFromNet(iv_img,url);
    }
}
