package com.lz.fishfamily.ui.multitype.main;

import android.content.Context;
import android.content.Intent;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.Utils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 直播 -> 直播权限申请
 *     version: 1.0
 * </pre>
 */
public class LivePermissionApplyActivity extends BaseActivity {


    @Override
    protected void initViewsAndEvents() {
        Utils.setTitle(this,"直播权限申请");
        Utils.setMenuText(this,"提交");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_live_permission_apply;
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, LivePermissionApplyActivity.class);
        context.startActivity(intent);
    }


}
