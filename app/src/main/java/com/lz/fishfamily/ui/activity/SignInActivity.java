package com.lz.fishfamily.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/24
 *     desc   : 签到
 *     version: 1.0
 * </pre>
 */
public class SignInActivity extends BaseActivity {
    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_sign_in;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, SignInActivity.class);
        context.startActivity(intent);
    }
    
}
