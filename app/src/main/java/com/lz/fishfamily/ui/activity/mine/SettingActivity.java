package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.Utils;

import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/15
 *     desc   : 我的 -> 设置
 *     version: 1.0
 * </pre>
 */
public class SettingActivity extends BaseActivity {

    @Override
    protected void initViewsAndEvents() {
        Utils.INSTANCE.setTitle(this, "设置");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_setting;
    }

    @OnClick({R.id.ll_modification_pwd, R.id.ll_shopping_address,R.id.ll_black_list,R.id.tv_logout})
    public void onClick(View view) {
        if (view.getId() == R.id.ll_modification_pwd) {
            ModificationPwdActivity.toActivity(this);
        } else if (view.getId() == R.id.ll_shopping_address) {
            ShoppingAddressActivity.Companion.toActivity(this);
        }else if(view.getId() == R.id.ll_black_list){
            BlackListActivity.Companion.toActivity(this);
        }else if(view.getId() == R.id.tv_logout){
            //退出登录
        }
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

}
