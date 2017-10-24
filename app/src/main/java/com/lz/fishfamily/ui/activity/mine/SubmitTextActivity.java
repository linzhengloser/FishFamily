package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/15
 *     desc   : 修改文本界面 简介修改 建议反馈
 *     version: 1.0
 * </pre>
 */
public class SubmitTextActivity extends BaseActivity {

    private static int TYPE_FEED_BACK = 1;

    private static int TYPE_INTRODUCTION_MODIFY = 2;

    int mType;

    String mTitles[] = {"建议反馈", "简介修改"};

    String mMenuTexts[] = {"提交", "完成"};

    String mHints[] = {"请输入反馈，我们将为您不断改进", "请输入您的简介"};

    @BindView(R.id.et_submit_text)
    EditText et_submit_text;

    @BindView(R.id.tv_submit_text)
    TextView tv_submit_text;

    @Override
    protected void initViewsAndEvents() {
        mType = getIntent().getIntExtra(Constant.INTENT_KEY_TYPE, 1);
        Utils.setTitle(this, mTitles[mType - 1]);
        Utils.setMenuText(this, mMenuTexts[mType - 1]);
        et_submit_text.setHint(mHints[mType - 1]);
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_submit_text;
    }

    public static void toActivity(Context context, int type) {
        Intent intent = new Intent(context, SubmitTextActivity.class);
        intent.putExtra(Constant.INTENT_KEY_TYPE, type);
        context.startActivity(intent);
    }

    public static void toFeedBackActivity(Context context) {
        toActivity(context, TYPE_FEED_BACK);
    }

    public static void toIntroductionModifyActivity(Context context) {
        toActivity(context, TYPE_INTRODUCTION_MODIFY);
    }

}
