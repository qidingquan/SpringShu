package com.ys.qdq.springshu.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.request.RequestOptions;
import com.ys.qdq.springshu.base.BaseApplication;

/**
 * Created by Administrator on 2018/4/12.
 * Glide工具操作类
 */

public class GlideUtil {

    private static final GlideUtil ourInstance = new GlideUtil();

    public static GlideUtil getInstance() {
        return ourInstance;
    }

    private GlideUtil() {
    }

    public void displayImage(final String url, final ImageView imageView) {
        imageView.post(() -> {
            RequestOptions options = new RequestOptions();
            options.override(imageView.getWidth(), imageView.getHeight());
            Glide.with(BaseApplication.instance).load(url).apply(options).thumbnail().into(imageView);
        });

    }
}
