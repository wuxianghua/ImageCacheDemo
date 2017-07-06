package com.example.stone.imagecachedemo.utils;

import android.graphics.Bitmap;

/**
 * Created by stone on 2017/7/6.
 */

public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url,Bitmap bitmap);
}
