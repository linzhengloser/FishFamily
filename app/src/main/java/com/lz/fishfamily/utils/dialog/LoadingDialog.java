package com.lz.fishfamily.utils.dialog;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseDialogFragment;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   : LoadingDialog
 *     version: 1.0
 * </pre>
 */
public class LoadingDialog extends BaseDialogFragment {
    @Override
    protected void setParams() {
        setWidth(AutoUtils.getPercentWidthSize(200));
        setHeight(AutoUtils.getPercentHeightSize(200));
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.dialog_loading;
    }

    @Override
    protected void initViewsAndEvents() {

    }
}
