package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.Utils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/16
 *     desc   : 我的 -> 商家入驻
 *     version: 1.0
 * </pre>
 */
public class MerchantEnterActivity extends BaseActivity {


    @Override
    protected void initViewsAndEvents() {
        Utils.setTitle(this,"商家入驻");
        Utils.setMenuText(this,"联系客服");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_merchant_enter;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, MerchantEnterActivity.class);
        context.startActivity(intent);
    }
    
}
