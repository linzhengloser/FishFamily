package com.lz.fishfamily.ui.activity.main

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import butterknife.OnClick
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.CommonApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.module.main.Comment
import com.lz.fishfamily.module.main.commodity.Commodity
import com.lz.fishfamily.setLike
import com.lz.fishfamily.ui.base.BaseListActivity
import com.lz.fishfamily.ui.multitype.main.taotao.CommodityDetailCommentItemViewBinder
import com.lz.fishfamily.ui.multitype.main.taotao.CommodityDetailItemViewBinder
import com.lz.fishfamily.utils.Utils
import com.lz.library.utils.ToastUtils
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main_commodity_detail.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/25
 * desc   : 首页 -> 商品详情
 * version: 1.0
</pre> *
 */
class CommodityDetailActivity : BaseListActivity() {

    private lateinit var mCommodity: Commodity

    override val contentViewResourceID: Int
        get() = R.layout.activity_main_commodity_detail


    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        mCommodity = intent.getParcelableExtra("commodity")
        Utils.setTitle(this, "商品详情 ")
        rv_commodity_detail.layoutManager = LinearLayoutManager(this)
        mItems.add(mCommodity)
        mCommodity.comment.map { mItems.add(it) }
        rv_commodity_detail.adapter = mAdapter

        //设置是否点赞
        iv_like.setLike(mCommodity.isLike)
    }

    override fun registerItemViewBinder() {
        mAdapter.register(Commodity::class.java, CommodityDetailItemViewBinder())
        mAdapter.register(Comment::class.java, CommodityDetailCommentItemViewBinder())
    }

    @OnClick(R.id.fl_like)
    fun onClick(view: View){
        if(view.id == R.id.fl_like){
            like()
        }
    }


    private fun like(){
        if(mCommodity.isLike){
            ToastUtils.showToast("您已经点过赞了")
            return
        }
        val like = Api.create(CommonApi::class.java).postLike(mCommodity.commodity_ID)
        handlerObservable(like,bindToLifecycle(), Consumer {
            ToastUtils.showToast("点赞成功")
            mCommodity.setIsLike(true)
            iv_like.setLike(mCommodity.isLike)
        })
    }

    companion object {

        fun toActivity(context: Context, commodity: Commodity) {
            val intent = Intent(context, CommodityDetailActivity::class.java)
            intent.putExtra("commodity", commodity)
            context.startActivity(intent)
        }
    }
}
