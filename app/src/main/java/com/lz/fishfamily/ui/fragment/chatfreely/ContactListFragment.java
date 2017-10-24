package com.lz.fishfamily.ui.fragment.chatfreely;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.Contact;
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration;
import com.lz.fishfamily.ui.multitype.ContactListItemViewBinder;
import com.lz.library.base.LibraryBaseListFragment;
import com.lz.library.ui.view.indexbar.IndexBar;
import com.lz.library.ui.view.itemdecoration.TitleItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/24
 *     desc   : 畅聊 -> 通讯录
 *     version: 1.0
 * </pre>
 */
public class ContactListFragment extends LibraryBaseListFragment implements IndexBar.OnIndexPressedListener {


    @BindView(R.id.rv_contact_list)
    RecyclerView rv_contact_list;

    @BindView(R.id.ib_contact_list)
    IndexBar ib_contact_list;

    List<Contact> mItems;

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Contact.class, new ContactListItemViewBinder());
    }

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        mItems = new ArrayList<>();
        mItems.add(new Contact("张三"));
        mItems.add(new Contact("李四"));
        mItems.add(new Contact("王五"));
        mItems.add(new Contact("赵六"));

        mItems.add(new Contact("张三"));
        mItems.add(new Contact("李四"));
        mItems.add(new Contact("王五"));
        mItems.add(new Contact("赵六"));

        mItems.add(new Contact("张三"));
        mItems.add(new Contact("李四"));
        mItems.add(new Contact("王五"));
        mItems.add(new Contact("赵六"));

        mItems.add(new Contact("张三"));
        mItems.add(new Contact("李四"));
        mItems.add(new Contact("王五"));
        mItems.add(new Contact("赵六"));
        getMAdapter().setItems(mItems);

        ib_contact_list.setSourceDatas(mItems);
        ib_contact_list.setIndexPressedListener(this);

        rv_contact_list.addItemDecoration(new PaddingItemDecoration().setPadding(30, 50));
        rv_contact_list.addItemDecoration(new TitleItemDecoration(getContext(), mItems));
        rv_contact_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_contact_list.setAdapter(getMAdapter());
        getMAdapter().notifyDataSetChanged();
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_contact_list;
    }

    public static ContactListFragment newInstance() {
        Bundle args = new Bundle();
        ContactListFragment fragment = new ContactListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onIndexPressed(int index, String text) {
        rv_contact_list.scrollToPosition(index);
    }

    @Override
    public void onMotionEventEnd() {

    }
}
