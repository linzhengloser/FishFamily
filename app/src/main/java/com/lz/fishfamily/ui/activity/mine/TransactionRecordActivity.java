package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.ui.fragment.mine.AfterSaleFragment;
import com.lz.fishfamily.ui.fragment.mine.TransactionRecordFragment;
import com.lz.fishfamily.utils.Utils;
import com.lz.library.base.BaseViewPagerAdapter;
import com.zhy.autolayout.utils.AutoUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/14
 *     desc   : 我的 -> 交易记录
 *     version: 1.0
 * </pre>
 */
public class TransactionRecordActivity extends BaseActivity {

    public static final int TYPE_BUY = 1;

    public static final int TYPE_SALE = 2;

    @BindView(R.id.mi_transaction_record)
    MagicIndicator mi_transaction_record;

    @BindView(R.id.vp_transaction_record)
    ViewPager vp_transaction_record;

    // 1 = 我买到的 2 = 我卖出的
    private int mType;

    private String [] mTitles = {"待付款","待发货","已发货","退款/售后"};

    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void initViewsAndEvents() {
        mType = getIntent().getIntExtra(Constant.INTENT_KEY_TYPE,1);
        Utils.setTitle(this, mType == TYPE_BUY ? "我买到的" : "我卖出的");
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(Color.WHITE);
                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setText(mTitles[index]);
                simplePagerTitleView.setOnClickListener(v -> vp_transaction_record.setCurrentItem(index));
                AutoUtils.auto(simplePagerTitleView);
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.WHITE);
                indicator.setLineHeight(AutoUtils.getPercentHeightSize(4));
                indicator.setMode(LinePagerIndicator.MODE_MATCH_EDGE);
                return indicator;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                return 1.0f;
            }
        });


        for (int i = 0; i < 3; i++) {
            mFragmentList.add(TransactionRecordFragment.newInstance(mType));
        }
        mFragmentList.add(AfterSaleFragment.newInstance(mType));

        mi_transaction_record.setNavigator(commonNavigator);
        vp_transaction_record.setAdapter(new BaseViewPagerAdapter(getSupportFragmentManager(),mFragmentList));
        ViewPagerHelper.bind(mi_transaction_record,vp_transaction_record);

    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_transaction_record;
    }
    
    public static void toActivity(Context context,int type) {
        Intent intent = new Intent(context, TransactionRecordActivity.class);
        intent.putExtra(Constant.INTENT_KEY_TYPE,type);
        context.startActivity(intent);
    }

    public static void toBuy(Context context){
        toActivity(context,TYPE_BUY);
    }

    public static void toSale(Context context){
        toActivity(context,TYPE_SALE);
    }

}
