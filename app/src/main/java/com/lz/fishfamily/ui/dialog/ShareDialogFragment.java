package com.lz.fishfamily.ui.dialog;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseDialogFragment;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/27
 *     desc   : 分享 DialogFragment
 *     version: 1.0
 * </pre>
 */
public class ShareDialogFragment extends BaseDialogFragment {

    @Override
    protected void setParams() {
        setHeight(AutoUtils.getPercentHeightSize(350));
        setShowBottom(true);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.dialog_share;
    }

    @Override
    protected void initViewsAndEvents() {

    }

}
