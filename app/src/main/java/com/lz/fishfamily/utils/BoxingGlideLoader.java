package com.lz.fishfamily.utils;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bilibili.boxing.loader.IBoxingCallback;
import com.bilibili.boxing.loader.IBoxingMediaLoader;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lz.fishfamily.utils.glide.GlideApp;
import com.lz.fishfamily.utils.glide.GlideRequest;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BoxingGlideLoader implements IBoxingMediaLoader {
    @Override
    public void displayThumbnail(@NonNull ImageView img, @NonNull String absPath, int width, int height) {
        GlideApp.with(img.getContext()).load(absPath).override(width, height).into(img);
    }

    @Override
    public void displayRaw(@NonNull ImageView img, @NonNull String absPath, int width, int height, IBoxingCallback callback) {
        String path = "file://" + absPath;
        GlideRequest<Bitmap> glideRequest = GlideApp.with(img.getContext())
                .asBitmap()
                .load(path);
        if (width > 0 && height > 0) {
            glideRequest.override(width, height);
        }
        glideRequest.listener(new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                if (callback != null) {
                    callback.onFail(e);
                    return true;
                }
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                if (resource != null && callback != null) {
                    img.setImageBitmap(resource);
                    callback.onSuccess();
                    return true;
                }
                return false;
            }
        }).into(img);
    }
}
