package com.lz.fishfamily.ui.activity.main

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.CommodityApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.module.main.commodity.CommodityCategory
import com.lz.fishfamily.ui.base.BaseListActivity
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration
import com.lz.fishfamily.utils.Utils
import com.lz.library.base.BaseViewHolder
import com.zhy.autolayout.utils.AutoUtils
import kotlinx.android.synthetic.main.activity_main_fish_category.*
import kotlinx.android.synthetic.main.item_main_fish_category.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/01
 * desc   : 发布商品 -> 分类 -> 鱼分类列表
 * version: 1.0
</pre> *
 */
class FishCategoryActivity : BaseListActivity() {

    override val contentViewResourceID: Int
        get() = R.layout.activity_main_fish_category


    override fun registerItemViewBinder() {
        mAdapter.register(CommodityCategory::class.java, object : ItemViewBinder<CommodityCategory, BaseViewHolder>() {
            override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BaseViewHolder {
                return BaseViewHolder(inflater.inflate(R.layout.item_main_fish_category, parent, false))
            }

            override fun onBindViewHolder(holder: BaseViewHolder, item: CommodityCategory) {
                holder.itemView.tv_fish_category_name.text = item.name
            }
        })
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        Utils.setTitle(this, "类目")
        rv_fish_category.layoutManager = LinearLayoutManager(this)
        rv_fish_category.addItemDecoration(PaddingItemDecoration().setPadding(AutoUtils.getPercentWidthSize(30), 0))
        rv_fish_category.adapter = mAdapter
        val fishCategoryObservable = Api.create(CommodityApi::class.java).getCommodityCategory(pageSize = 100, screenCondition = "{\"Authentication_ID\": \"1\"}")
        handlerObservable(fishCategoryObservable, this, bindToLifecycle()) {
            mItems.addAll(it)
            mAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        fun toActivity(context: Context) {
            context.startActivity(Intent(context, FishCategoryActivity::class.java))
        }
    }

}
