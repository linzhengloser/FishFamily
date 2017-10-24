package com.lz.fishfamily.ui.fragment.chatfreely;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.activity.CreateGroupActivity;
import com.lz.library.base.LibraryBaseFragment;
import com.lz.library.base.BaseViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/23
 *     desc   : 畅聊 Fragment
 *     version: 1.0
 * </pre>
 */
public class ChatFreelyFragment extends LibraryBaseFragment implements ViewPager.OnPageChangeListener {

    @BindView(R.id.vp_chat_freely)
    ViewPager vp_chat_freely;

    @BindView(R.id.ll_chat_freely)
    LinearLayout ll_chat_freely;

    @BindView(R.id.tv_title)
    TextView tv_title;

    List<Fragment> mFragmentList = new ArrayList<>(3);

    int tabSelectedImageResIds[] = {
            R.drawable.shape_chat_freely_message_tab_selected,
            R.drawable.shape_chat_freely_contact_list_tab_selected
    };

    int tabUnSelectedImageResIds[] = {
            R.drawable.shape_chat_freely_message_tab_unselected,
            R.drawable.shape_chat_freely_contact_list_tab_unselected
    };

    String titiles[] = {"畅聊", "通讯录"};

    @Override
    protected void initViewsAndEvents() {
        mFragmentList.add(MessageFragment.newInstance());
        mFragmentList.add(ContactListFragment.newInstance());
        vp_chat_freely.setOffscreenPageLimit(mFragmentList.size());
        vp_chat_freely.setAdapter(new BaseViewPagerAdapter(getFragmentManager(), mFragmentList));
        vp_chat_freely.addOnPageChangeListener(this);

        changeTab(1);
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_chat_freely;
    }

    public static ChatFreelyFragment newInstance() {
        Bundle args = new Bundle();
        ChatFreelyFragment fragment = new ChatFreelyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.tv_chat_freely_message_tab, R.id.tv_chat_freely_contact_list_tab})
    public void onTabClick(View view) {
        for (int i = 0; i < ll_chat_freely.getChildCount(); i++) {
            if (view.getId() == ll_chat_freely.getChildAt(i).getId()) {
                changeTab(i);
                vp_chat_freely.setCurrentItem(i - 1);
                break;
            }
        }
    }

    @OnClick({R.id.right})
    public void onClick(View view){
        CreateGroupActivity.toActivity(view.getContext());
    }

    private void changeTab(int position) {
        View childView;
        int imageResId;
        int textColor;
        for (int i = 0; i < ll_chat_freely.getChildCount(); i++) {
            childView = ll_chat_freely.getChildAt(i);
            if (childView instanceof TextView) {
                if (i == position) {
                    imageResId = tabSelectedImageResIds[i - 1];
                    textColor = getResources().getColor(R.color.white);
                } else {
                    imageResId = tabUnSelectedImageResIds[i - 1];
                    textColor = getResources().getColor(R.color.chat_freely_tab_unselected_text_color);
                }
                childView.setBackgroundResource(imageResId);
                ((TextView) childView).setTextColor(textColor);
            }
        }
        tv_title.setText(titiles[position - 1]);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeTab(position + 1);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

