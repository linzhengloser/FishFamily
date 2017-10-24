package com.lz.fishfamily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.config.BoxingConfig;
import com.bilibili.boxing.model.config.BoxingCropOption;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.bilibili.boxing.utils.BoxingFileHelper;
import com.bilibili.boxing_impl.ui.BoxingActivity;
import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.api.Api;
import com.lz.fishfamily.api.LoginApi;
import com.lz.fishfamily.module.FishCategory;
import com.lz.fishfamily.ui.MainActivity;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.ui.multitype.FishCategoryItemViewBinder;
import com.lz.fishfamily.utils.event.LoginEvent;
import com.lz.fishfamily.utils.glide.GlideApp;
import com.lz.fishfamily.utils.rxjava.HandlerApiResultCosumer;
import com.lz.fishfamily.utils.rxjava.HandlerApiResultFunction;
import com.lz.library.utils.BitmapUtils;
import com.lz.library.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   : 完善个人信息
 *     version: 1.0
 * </pre>
 */
public class CompleteProfileActivity extends BaseActivity {

    @BindView(R.id.iv_avatar)
    ImageView iv_avatar;

    @BindView(R.id.et_nick_name)
    EditText et_nick_name;


    @BindView(R.id.iv_left_triangle)
    ImageView iv_left_triangle;

    @BindView(R.id.iv_right_triangle)
    ImageView iv_right_triangle;

    @BindView(R.id.rv_fish_experience_category)
    RecyclerView rv_fish_experience_category;

    @BindView(R.id.tv_next)
    TextView tv_next;

    @BindView(R.id.tv_choose_fish_experience)
    TextView tv_choose_fish_experience;

    @BindView(R.id.tv_choose_fish_category)
    TextView tv_choose_fish_category;

    Items mExperienceItems;

    Items mCategoryItems;

    MultiTypeAdapter mAdapter;

    String mAvatarBase64;

    //当前选中的经验
    int mCurrentSelectedExperiencePosition = -1;

    //当前选中的类型
    ArrayList<Integer> mCurrentSelectedCategoryPositions = new ArrayList<>();

    String userId;

    @Override
    protected void initViewsAndEvents() {
        userId = getIntent().getStringExtra(Constant.INTENT_KEY_USER_ID);
        EventBus.getDefault().register(this);
        mExperienceItems = new Items();
        mCategoryItems = new Items();
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(FishCategory.class, new FishCategoryItemViewBinder());
        rv_fish_experience_category.setLayoutManager(new GridLayoutManager(this, 3));
        rv_fish_experience_category.setAdapter(mAdapter);
        mAdapter.setItems(mExperienceItems);
        tv_choose_fish_experience.setTextColor(getResources().getColor(R.color.colorPrimary));
        getExperienceAndCategory();
    }

    @OnClick({R.id.iv_avatar, R.id.tv_next, R.id.ll_choose_fish_experience, R.id.ll_choose_fish_category})
    public void onClick(View view) {
        if (view.getId() == R.id.iv_avatar) {
            BoxingConfig boxingConfig = new BoxingConfig(BoxingConfig.Mode.SINGLE_IMG);
            boxingConfig.needCamera(R.mipmap.ic_launcher);
            String cachePath = BoxingFileHelper.getCacheDir(this);
            Uri destUri = new Uri.Builder()
                    .scheme("file")
                    .appendPath(cachePath)
                    .appendPath(String.format(Locale.US, "%s.png", System.currentTimeMillis()))
                    .build();
            boxingConfig.withCropOption(new BoxingCropOption(destUri));
            Boxing.of(boxingConfig).withIntent(this, BoxingActivity.class).start(this, 233);
        } else if (view.getId() == R.id.tv_next) {
            if (validate())
                completeProfile();
        } else {
            changeTab(view.getId());
        }
    }

    /**
     * 完善个人信息
     */
    private void completeProfile() {
        showLoadingDialog();
        String userNickname = et_nick_name.getText().toString().trim();
        StringBuffer category = new StringBuffer(((FishCategory) mExperienceItems.get(mCurrentSelectedExperiencePosition)).getFishCategory_ID());
        if (!mCurrentSelectedCategoryPositions.isEmpty()) category.append(",");
        for (int i = 0; i < mCurrentSelectedCategoryPositions.size(); i++) {
            category.append(((FishCategory) mCategoryItems.get(mCurrentSelectedCategoryPositions.get(i))).getFishCategory_ID());
            if (i != mCurrentSelectedCategoryPositions.size() - 1) category.append(",");
        }
        Api.create(LoginApi.class).perfectUserInfo(userId, userNickname, category.toString(), mAvatarBase64)
                .compose(bindToLifecycle())
                .map(new HandlerApiResultFunction<>())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> hidLoadingDialog())
                .subscribe(s -> {
                    ToastUtils.showToast("完善个人资料成功.");
                    MainActivity.toActivity(CompleteProfileActivity.this);
                }, new HandlerApiResultCosumer());
    }

    /**
     * 获取养鱼经验和养鱼类型
     */
    private void getExperienceAndCategory() {
        showLoadingDialog();
        Observable.zip(Api.create(LoginApi.class).getFishCategoryList(0).map(new HandlerApiResultFunction<>()), Api.create(LoginApi.class).getFishCategoryList(1).map(new HandlerApiResultFunction<>()),
                (categories, categories2) -> {
                    List<FishCategory> list = new ArrayList<>();
                    list.addAll(categories);
                    list.addAll(categories2);
                    return list;
                })
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> hidLoadingDialog())
                .subscribe(categories -> {
                    for (FishCategory category : categories) {
                        if (category.getFishCategory_Type() == 0) {
                            mExperienceItems.add(category);
                        } else {
                            mCategoryItems.add(category);
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                }, new HandlerApiResultCosumer());
    }

    public boolean validate() {
        if (TextUtils.isEmpty(mAvatarBase64)) {
            ToastUtils.showToast("请选择头像");
            return false;
        } else if (TextUtils.isEmpty(et_nick_name.getText().toString().trim())) {
            ToastUtils.showToast("请输入昵称");
            return false;
        } else if (mCurrentSelectedCategoryPositions.isEmpty()) {
            ToastUtils.showToast("请选择养鱼种类");
            return false;
        } else if (mCurrentSelectedExperiencePosition == -1) {
            ToastUtils.showToast("请选择养鱼经验");
            return false;
        }
        return true;
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_complete_profile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 233) {
            ArrayList<BaseMedia> result = Boxing.getResult(data);
            GlideApp.with(this).load(result.get(0).getPath()).into(iv_avatar);
            mAvatarBase64 = BitmapUtils.bitmapToBase64(BitmapFactory.decodeFile(result.get(0).getPath()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public static void toActivity(Context context, String userId) {
        Intent intent = new Intent(context, CompleteProfileActivity.class);
        intent.putExtra(Constant.INTENT_KEY_USER_ID, userId);
        context.startActivity(intent);
    }

    private void changeTab(int viewId) {
        if (viewId == R.id.ll_choose_fish_category) {
            tv_choose_fish_category.setTextColor(getResources().getColor(R.color.colorPrimary));
            tv_choose_fish_experience.setTextColor(Color.parseColor("#999999"));
            iv_left_triangle.setVisibility(View.VISIBLE);
            mAdapter.setItems(mCategoryItems);
        } else if (viewId == R.id.ll_choose_fish_experience) {
            iv_right_triangle.setVisibility(View.VISIBLE);
            tv_choose_fish_experience.setTextColor(getResources().getColor(R.color.colorPrimary));
            tv_choose_fish_category.setTextColor(Color.parseColor("#999999"));
            mAdapter.setItems(mExperienceItems);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onSelectedEvent(LoginEvent<Integer> event) {
        if (event.getEventType() == LoginEvent.EVENT_TYPE_FISH_EXPERIENCE_SELECTED) {
            //养鱼经验被
            if (mCurrentSelectedExperiencePosition != -1)
                ((FishCategory) mExperienceItems.get(mCurrentSelectedExperiencePosition)).setSelected(false);
            mCurrentSelectedExperiencePosition = event.getData();
            ((FishCategory) mExperienceItems.get(mCurrentSelectedExperiencePosition)).setSelected(true);
        } else if (event.getEventType() == LoginEvent.EVENT_TYPE_FISH_CATEGORY_SELECTED) {
            FishCategory category = (FishCategory) mCategoryItems.get(event.getData());
            if (!mCurrentSelectedCategoryPositions.contains(event.getData())) {
                if(mCurrentSelectedCategoryPositions.size() == 6) {
                    ToastUtils.showToast("最多只能选着6种养鱼类型");
                    return;
                }
                mCurrentSelectedCategoryPositions.add(event.getData());
            }
            category.setSelected(!category.isSelected());
        }
        mAdapter.notifyDataSetChanged();
    }

}
