package com.example.stone.imagecachedemo.utils;

import android.graphics.Bitmap;

/**
 * Created by stone on 2017/7/6.
 */

public class DoubleCache implements ImageCache {

    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDiskCache = new DiskCache();

    //先从内存缓存中获取图片，如果没有，再从sd卡中获取
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mDiskCache.put(url,bitmap);
        mMemoryCache.put(url,bitmap);
    }
}
