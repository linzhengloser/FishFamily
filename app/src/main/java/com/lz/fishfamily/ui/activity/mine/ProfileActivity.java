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
 *     time   : 2017/09/17
 *     desc   : 我的 -> 基本信息
 *     version: 1.0
 * </pre>
 */
public class ProfileActivity extends BaseActivity {
    @Override
    protected void initViewsAndEvents() {
        Utils.setTitle(this, "基本信息");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_profile;
    }

    @OnClick({R.id.ll_tag})
    public void onClick(View view) {
        if (view.getId() == R.id.ll_tag) {
            SelectTagActivity.toActivity(this);
        }
    }


    public static void toActivity(Context context) {
        Intent intent = new Intent(context, ProfileActivity.class);
        context.startActivity(intent);
    }

}
