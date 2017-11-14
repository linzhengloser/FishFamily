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
 *     time   : 2017/09/15
 *     desc   : 我的 -> 设置 -> 密码修改
 *     version: 1.0
 * </pre>
 */
public class ModificationPwdActivity extends BaseActivity {
    @Override
    protected void initViewsAndEvents() {
        Utils.INSTANCE.setTitle(this, "修改密码");
        Utils.INSTANCE.setMenuText(this, "完成");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_modification_pwd;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, ModificationPwdActivity.class);
        context.startActivity(intent);
    }
    
}
