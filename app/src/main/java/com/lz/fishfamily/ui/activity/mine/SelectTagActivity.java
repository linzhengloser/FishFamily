package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Tag;
import com.lz.fishfamily.module.mine.TagType;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.mine.TagItemViewBinder;
import com.lz.fishfamily.ui.multitype.mine.TagTypeItemViewBinder;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   : 我的 -> 基本信息 -> 选择标签
 *     version: 1.0
 * </pre>
 */
public class SelectTagActivity extends BaseListActivity {

    @BindView(R.id.rv_select_tag)
    RecyclerView rv_select_tag;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.INSTANCE.setTitle(this, "选择标签");
        Utils.INSTANCE.setMenuText(this, "保存");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return getMItems().get(position) instanceof TagType ? 3 : 1;
            }
        });
        rv_select_tag.setLayoutManager(gridLayoutManager);

        getMItems().add(new TagType("我的标签"));
        for (int i = 0; i < 6; i++) {
            getMItems().add(new Tag("准备养鱼").setShouldDelete(true));
        }
        getMItems().add(new TagType("养鱼阶段"));
        for (int i = 0; i < 6; i++) {
            getMItems().add(new Tag("准备养鱼"));
        }
        getMItems().add(new TagType("养鱼阶段"));
        for (int i = 0; i < 12; i++) {
            getMItems().add(new Tag("准备养鱼"));
        }

        rv_select_tag.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Tag.class, new TagItemViewBinder());
        getMAdapter().register(TagType.class, new TagTypeItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_select_tag;
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, SelectTagActivity.class);
        context.startActivity(intent);
    }

}
