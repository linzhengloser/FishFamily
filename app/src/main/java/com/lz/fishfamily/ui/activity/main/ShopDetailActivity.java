package com.lz.fishfamily.ui.activity.main;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.Utils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/18
 *     desc   : 首页 -> 淘淘 -> 商家店铺详情 -> 店铺详情
 *     version: 1.0
 * </pre>
 */
public class ShopDetailActivity extends BaseActivity {
    @Override
    protected void initViewsAndEvents() {
        Utils.INSTANCE.setTitle(this,"店铺详情");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_shop_detail;
    }
}
