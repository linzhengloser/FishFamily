package com.lz.fishfamily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.Contact;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration;
import com.lz.fishfamily.ui.multitype.ContactListItemViewBinder;
import com.lz.library.ui.view.indexbar.IndexBar;
import com.lz.library.ui.view.itemdecoration.TitleItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/04
 *     desc   : 创群
 *     version: 1.0
 * </pre>
 */
public class CreateGroupActivity extends BaseListActivity implements IndexBar.OnIndexPressedListener {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.menu_text)
    TextView menu_text;

    @BindView(R.id.rv_create_group)
    RecyclerView rv_create_group;

    @BindView(R.id.ib_create_group)
    IndexBar ib_create_group;

    List<Contact> mItems;

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Contact.class, new ContactListItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_create_group;
    }

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        title.setText("群主聊天");
        menu_text.setText("确定");

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
        ib_create_group.setSourceDatas(mItems);
        ib_create_group.setIndexPressedListener(this);

        rv_create_group.addItemDecoration(new PaddingItemDecoration().setPadding(30, 50));
        rv_create_group.addItemDecoration(new TitleItemDecoration(this, mItems));
        rv_create_group.setLayoutManager(new LinearLayoutManager(this));
        rv_create_group.setAdapter(getMAdapter());
        getMAdapter().notifyDataSetChanged();
    }

    @OnClick({R.id.back, R.id.menu_text})
    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            finish();
        } else {
            //确定创群
        }
    }

    @Override
    public void onIndexPressed(int index, String text) {
        rv_create_group.scrollToPosition(index);
    }

    @Override
    public void onMotionEventEnd() {

    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, CreateGroupActivity.class);
        context.startActivity(intent);
    }

}
