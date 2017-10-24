package com.lz.fishfamily.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.config.BoxingConfig;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.bilibili.boxing_impl.ui.BoxingActivity;
import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.adapter.SelectImageRecyclerViewAdapter;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.utils.Utils;
import com.lz.fishfamily.utils.event.MainEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/18
 *     version: 1.0
 * </pre>
 */
public class PublishPostActivity extends BaseActivity {

    @BindView(R.id.rv_publish_post)
    RecyclerView rv_publish_post;

    SelectImageRecyclerViewAdapter mAdapter;

    @Override
    protected void initViewsAndEvents() {
        Utils.setMenuText(this, "发布");
        mAdapter = new SelectImageRecyclerViewAdapter();
        rv_publish_post.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_publish_post.setAdapter(mAdapter);
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_publish_post;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe
    public void onSelecteImageEvent(MainEvent event) {
        if (event.getEventType() == MainEvent.EVENT_TYPE_SELECT_IMAGE) {
            BoxingConfig boxingConfig = new BoxingConfig(BoxingConfig.Mode.MULTI_IMG);
            boxingConfig.needCamera(R.mipmap.ic_launcher);
            boxingConfig.withMaxCount(9);
            Boxing.of(boxingConfig).withIntent(this, BoxingActivity.class).start(this, 2333);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2333 && resultCode == RESULT_OK) {
            ArrayList<BaseMedia> result = Boxing.getResult(data);
            if (result.size() > 1)
                mAdapter.addImageList(result);
            else
                mAdapter.addImage(result.get(0).getPath());
        }
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, PublishPostActivity.class);
        context.startActivity(intent);
    }
    
}
