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
 *     time   : 2017/10/16
 *     desc   : 首页 -> 发布 发布商品
 *     version: 1.0
 * </pre>
 */
public class PublishCommodityActivity extends BaseActivity {
    @Override
    protected void initViewsAndEvents() {
        Utils.setTitle(this,"发布商品");

    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_publish_commodity;
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, PublishCommodityActivity.class);
        context.startActivity(intent);
    }

}
