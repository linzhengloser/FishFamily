package com.lz.fishfamily.utils.glide;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.zhy.autolayout.utils.AutoUtils;

import java.security.MessageDigest;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/21
 *     desc   : 头像 Glide Transformation
 *     version: 1.0
 * </pre>
 */
public class AvatarTransformation extends BitmapTransformation {


    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Bitmap bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        drawRoundRect(canvas, paint, width, height);
        return bitmap;
    }

    private void drawRoundRect(Canvas canvas, Paint paint, int width, int height) {
        canvas.drawRoundRect(new RectF(0, 0, width, height), AutoUtils.getPercentWidthSize(10), AutoUtils.getPercentWidthSize(10), paint);
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
