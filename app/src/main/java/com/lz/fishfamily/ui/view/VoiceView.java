package com.lz.fishfamily.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lz.fishfamily.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/10
 *     desc   : 麦克风音量 View
 *     version: 1.0
 * </pre>
 */
public class VoiceView extends View {

    private static final int DOT_COUNT = 14;

    private int mDotWidth;

    private int mDotHeight;

    private int mDotMargin;

    private int mDotRadius;

    private int mCurrentVoiceLevel;

    private int mSelectedColor;

    private int mUnSelectedColor;

    private Paint mPaint;

    private RectF[] mDotRectArray;

    {
        mDotHeight = AutoUtils.getPercentHeightSize(16);
        mDotWidth = AutoUtils.getPercentWidthSize(8);
        mDotMargin = AutoUtils.getPercentWidthSize(18);
        mDotRadius = AutoUtils.getPercentWidthSize(4);
        mSelectedColor = getResources().getColor(R.color.colorPrimary);
        mUnSelectedColor = Color.parseColor("#cccccc");

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        mDotRectArray = new RectF[DOT_COUNT];
        int left;
        for (int i = 0; i < DOT_COUNT; i++) {
            left = i * (mDotWidth + mDotMargin);
            RectF rectF = new RectF(left, 0, left + mDotWidth, mDotHeight);
            mDotRectArray[i] = rectF;
        }

    }

    public VoiceView(Context context) {
        super(context);
    }

    public VoiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VoiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = mDotWidth * DOT_COUNT + mDotMargin * (DOT_COUNT - 1);
        setMeasuredDimension(width, mDotHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int left;
        for (int i = 0; i < DOT_COUNT; i++) {
            mPaint.setColor(i + 1 <= mCurrentVoiceLevel ? mSelectedColor : mUnSelectedColor);
            canvas.drawRoundRect(mDotRectArray[i], mDotRadius, mDotRadius, mPaint);
        }
    }

    public void setCurrentVoiceLevel(int level) {
        this.mCurrentVoiceLevel = level;
        postInvalidate();
    }

}
