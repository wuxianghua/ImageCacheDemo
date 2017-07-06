package com.example.stone.imagecachedemo.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by stone on 2017/7/6.
 */

public class CloseUtils {

    private CloseUtils() {}

    /**
     * 关闭Closeable对象
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
