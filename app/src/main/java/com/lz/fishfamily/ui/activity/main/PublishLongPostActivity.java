package com.lz.fishfamily.ui.activity.main;

import android.content.Context;
import android.content.Intent;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.Utils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/22
 *     desc   : 首页 -> 发布 -> 长帖
 *     version: 1.0
 * </pre>
 */
public class PublishLongPostActivity extends BaseActivity {
    @Override
    protected void initViewsAndEvents() {
        Utils.INSTANCE.setMenuText(this,"发布");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_publish_long_post;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, PublishLongPostActivity.class);
        context.startActivity(intent);
    }
    
}
