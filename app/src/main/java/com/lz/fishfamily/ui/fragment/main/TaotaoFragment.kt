package com.lz.fishfamily.ui.fragment.main

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.CommodityApi
import com.lz.fishfamily.api.ShopApi
import com.lz.fishfamily.module.main.Comment
import com.lz.fishfamily.module.main.LikeList
import com.lz.fishfamily.module.main.MainDivider
import com.lz.fishfamily.module.main.commodity.Commodity
import com.lz.fishfamily.module.main.shop.Shop
import com.lz.fishfamily.ui.base.BaseListFragment
import com.lz.fishfamily.ui.multitype.main.CommentItemViewBinder
import com.lz.fishfamily.ui.multitype.main.LikeAvatarItemViewBinder
import com.lz.fishfamily.ui.multitype.main.MainDividerItemViewBinder
import com.lz.fishfamily.ui.multitype.main.taotao.CommodityItemViewBinder
import com.lz.fishfamily.ui.multitype.main.taotao.SearchItemViewBinder
import com.lz.fishfamily.ui.multitype.main.taotao.ShopItemViewBinder
import com.lz.fishfamily.utils.UserManager
import com.lz.fishfamily.utils.rxjava.HandlerApiResultConsumer
import com.lz.fishfamily.utils.rxjava.HandlerApiResultFunction
import com.zhy.autolayout.utils.AutoUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_main_taotao.*
import me.drakeet.multitype.Items
import org.json.JSONObject

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/24
 * desc   : 首页 -> 淘淘
 * version: 1.0
</pre> *
 */
class TaotaoFragment : BaseListFragment() {

    override val contentViewLayoutID: Int
        get() = R.layout.fragment_main_taotao

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        val gridLayoutManager = GridLayoutManager(context, 10)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = when {
                mItems[position] is Shop -> 2
                else -> 10
            }
        }
        rv_taotao.addItemDecoration(object : RecyclerView.ItemDecoration() {

            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
                val position = parent.getChildLayoutPosition(view)
                val spanSize = gridLayoutManager.spanSizeLookup.getSpanSize(position)
                if (spanSize != 5) return
                if (position % 2 == 0) {
                    outRect.set(0, 0, 0, AutoUtils.getPercentWidthSize(10))
                } else {
                    outRect.set(0, 0, AutoUtils.getPercentWidthSize(10), AutoUtils.getPercentWidthSize(10))
                }
            }
        })
        rv_taotao.layoutManager = gridLayoutManager
        rv_taotao.adapter = mAdapter
    }

    override fun loadPageData(page: Int) {
        showLoading()
        val shopParams = JSONObject().apply {
            put("Authentication_ID", "1")
        }.toString()
        val commodityParams = JSONObject().apply {
            put("UserInfo_ID", UserManager.getUser().userInfo_ID)
        }.toString()
        val shopObservable: Observable<List<Shop>> = Api.create(ShopApi::class.java).getShop(pageSize = 9, screenCondition = shopParams).map(HandlerApiResultFunction(this))
        val commodityObservable: Observable<List<Commodity>> = Api.create(CommodityApi::class.java).getCommodity(screenCondition = commodityParams).map(HandlerApiResultFunction(this))
        val zipObservable = Observable.zip(
                shopObservable,
                commodityObservable,
                BiFunction<List<Shop>, List<Commodity>, Items> { t1, t2 ->
                    val items = Items()
                    items.addAll(t1)
                    if (t1.size == 9) items.add(Shop().apply {
                        business_ID = "-1"
                        name = "更多"
                    })
                    t2.map {
                        items.add(it)
                        if (it.like.isNotEmpty()) items.add(LikeList(it.like))
                        it.comment.forEachIndexed { index, comment ->
                            items.add(comment)
                            if (index == it.comment.size - 1) items.add(MainDivider().apply { if (it.comment.size >= 5) isShowMoreComment = true })
                        }
                        items.add(MainDivider())
                    }
                    items
                })
        zipObservable
                .compose(bindToLifecycle())
                .doFinally { showSuccess() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    mItems.add("商家活体搜索")
                    mItems.addAll(it)
                    mAdapter.notifyDataSetChanged()
                }, HandlerApiResultConsumer())
    }

    override fun loadData() {
        loadPageData()
    }

    override fun registerItemViewBinder() {
        mAdapter.register(String::class.java, SearchItemViewBinder())
        mAdapter.register(Shop::class.java, ShopItemViewBinder())
        mAdapter.register(Commodity::class.java, CommodityItemViewBinder())
        mAdapter.register(LikeList::class.java, LikeAvatarItemViewBinder())
        mAdapter.register(Comment::class.java, CommentItemViewBinder())
        mAdapter.register(MainDivider::class.java, MainDividerItemViewBinder())
    }

    companion object {

        fun newInstance(): TaotaoFragment {
            val args = Bundle()
            val fragment = TaotaoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
