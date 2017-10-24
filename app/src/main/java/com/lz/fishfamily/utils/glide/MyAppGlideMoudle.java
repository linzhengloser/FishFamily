package com.lz.fishfamily.utils.glide;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.lz.fishfamily.R;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/18
 *     desc   : MyAppGlideMoudle
 *     version: 1.0
 * </pre>
 */
@GlideModule
public final class MyAppGlideMoudle extends AppGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDefaultRequestOptions(new RequestOptions().error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).centerCrop());
    }



}
