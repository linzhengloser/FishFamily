package com.lz.fishfamily.ui.fragment.main;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lz.fishfamily.R;
import com.lz.library.base.BaseViewPagerAdapter;
import com.lz.library.base.LibraryBaseFragment;
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
 *     time   : 2017/08/23
 *     desc   : 首页 Fragment
 *     version: 1.0
 * </pre>
 */
public class MainFragment extends LibraryBaseFragment {

    @BindView(R.id.mi_main)
    MagicIndicator mi_main;

    @BindView(R.id.vp_main)
    ViewPager vp_main;

    String[] mTitles = {"分享", "抽奖", "淘淘", "直播", "发布"};

    List<Fragment> mFragmentList = new ArrayList<>(mTitles.length);

    @Override
    protected void initViewsAndEvents() {
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
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
                simplePagerTitleView.setOnClickListener(v -> vp_main.setCurrentItem(index));
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
        mi_main.setNavigator(commonNavigator);
        mFragmentList.add(ShareFragment.newInstance());
        mFragmentList.add(LuckyFragment.newInstance());
        mFragmentList.add(TaotaoFragment.Companion.newInstance());
        mFragmentList.add(LiveFragment.newInstance());
        mFragmentList.add(PublishFragment.Companion.newInstance());
        vp_main.setOffscreenPageLimit(mTitles.length);
        vp_main.setAdapter(new BaseViewPagerAdapter(getChildFragmentManager(), mFragmentList));
        ViewPagerHelper.bind(mi_main, vp_main);
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_main;
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
