package com.lz.fishfamily.utils.glide;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.lz.fishfamily.R;
import com.zhy.autolayout.utils.AutoUtils;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@GlideExtension
public class MyAppExtension {

    private MyAppExtension() {
    }

    @GlideOption
    public static void loadAvatar(RequestOptions options) {
        options
                .error(R.drawable.default_avatar)
                .placeholder(R.drawable.default_avatar)
                .transforms(new CenterCrop(), new RoundedCornersTransformation(AutoUtils.getPercentWidthSize(10), 0));
    }

}
