package com.lz.fishfamily.ui.activity.mine;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.Utils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/16
 *     desc   : 我的 -> 设置 -> 收货地址 -> 新增 or 修改
 *     version: 1.0
 * </pre>
 */
public class EditShoppingAddressActivity extends BaseActivity {
    @Override
    protected void initViewsAndEvents() {
        Utils.setTitle(this, "新增收获地址");
        Utils.setMenuText(this, "完成");
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_edit_shopping_address;
    }
}
