package com.lz.fishfamily.ui.activity.main

import android.content.Context
import android.content.Intent
import android.view.View
import butterknife.OnClick

import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.CommodityApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.ui.base.BaseActivity
import com.lz.fishfamily.utils.Utils
import com.lz.library.utils.ToastUtils
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main_publish_commodity.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/16
 * desc   : 首页 -> 发布 发布商品
 * version: 1.0
</pre> *
 */
class PublishCommodityActivity : BaseActivity() {

    //商品分类ID
    var mCommodityCategoryId = ""

    //主图 URL
    var mCommodityMainImageUrl = ""

    //附图 URL
    var mCommodityImageUrl = ""

    override val contentViewResourceID: Int
        get() = R.layout.activity_main_publish_commodity


    override fun initViewsAndEvents() {
        Utils.setTitle(this, "发布商品")
        ll_category.setOnClickListener { FishCategoryActivity.toActivity(it.context) }
    }

    /**
     * 发布商品
     */
    fun publishCommodity() {
        val title = et_title.text.toString().trim()
        val content = et_content.text.toString().trim()
        val price = et_price.text.toString().trim()
        //邮费
        val freight = et_freight.text.toString().trim()
        //库存
        val inventory = et_inventory.text.toString().trim()

        val publishCommodity = Api.create(
                CommodityApi::class.java).publishCommodity(
                "",
                price,
                title,
                freight,
                mCommodityCategoryId,
                inventory,
                "",
                content,
                ""
        )

        handlerObservable(publishCommodity,bindToLifecycle(), Consumer {
            ToastUtils.showToast("商品发布成功")
        })
    }

    fun validate(): Boolean {

        if (Utils.isEmpty(arrayOf("请输入标题", "请输入内容", "请输入价格", "请输入运费", "请输入库存"), et_title, et_content, et_price, et_freight, et_inventory)) false
        else if (mCommodityCategoryId.isEmpty()) {
            ToastUtils.showToast("请选择商品类型")
            false
        }
        return true
    }

    @OnClick(R.id.tv_publish_btn)
    fun onClick(view: View) {
        when (view.id) {
            R.id.tv_publish_btn -> if (validate()) publishCommodity()
        }
    }

    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, PublishCommodityActivity::class.java)
            context.startActivity(intent)
        }
    }

}
