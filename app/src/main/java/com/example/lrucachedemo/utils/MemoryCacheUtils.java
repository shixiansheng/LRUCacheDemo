package com.example.lrucachedemo.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

public class MemoryCacheUtils {

    private LruCache<String, Bitmap> mMemoryCache;

    public MemoryCacheUtils() {
        //获取系统分配给每个应用程序的最大内存
        int maxsize = (int) Runtime.getRuntime().maxMemory();
        System.out.println("===可用内存=="+maxsize/1024);
        // 使用最大可用内存值的1/8作为缓存的大小
        int size = maxsize/8;
        System.out.println("===缓存内存最大值，单位是KB=="+size/ 1024);
        //实例LruCache，通过有参构造把缓存的最大内存值传过去
        mMemoryCache = new LruCache<String, Bitmap>((int) size) {
            @Override
            protected int sizeOf(String key, Bitmap value)
            {
                //重写此方法来衡量每张图片的大小，默认返回1(可理解为数量)
                int bitmap = value.getByteCount() / 1024;
                System.out.println("===图片大小(所用内存)=="+bitmap);
                return bitmap;
            }
        };
    }

    /**
     * 从内存读
     * @param url
     */
    public Bitmap getBitmapFromMemory(String url)
    {
        Bitmap bitmap = mMemoryCache.get(url);
        return bitmap;
    }
    /**
     * 写内存
     * @param url
     * @param bitmap
     */
    public void setBitmapToMemory(String url, Bitmap bitmap)
    {
        mMemoryCache.put(url, bitmap);
    }
}
