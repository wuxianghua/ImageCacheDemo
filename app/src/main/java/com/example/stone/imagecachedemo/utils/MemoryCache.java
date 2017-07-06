package com.example.stone.imagecachedemo.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by stone on 2017/7/6.
 */

public class MemoryCache implements ImageCache {

    private LruCache<String,Bitmap> mMemoryCache;

    public MemoryCache() {
        initMemoryCache();
    }

    private void initMemoryCache() {
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        return mMemoryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url,bitmap);
    }
}
