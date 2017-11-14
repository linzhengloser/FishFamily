package com.lz.fishfamily.ui.activity.mine

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import butterknife.OnClick
import com.bilibili.boxing.Boxing
import com.bilibili.boxing.model.config.BoxingConfig
import com.bilibili.boxing_impl.ui.BoxingActivity
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.ShopApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.ui.base.BaseActivity
import com.lz.fishfamily.uploadImage
import com.lz.fishfamily.utils.UserManager
import com.lz.fishfamily.utils.Utils
import com.lz.fishfamily.utils.glide.GlideApp
import com.lz.library.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_merchant_enter.*


/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/16
 * desc   : 我的 -> 商家入驻
 * version: 1.0
</pre> *
 */
class MerchantEnterActivity : BaseActivity() {

    // 淘淘 1 鱼友 2
    private var mSelectShopType: Int = 2

    //证件图片路径集合
//    mutableListOf("0","0","0","0","0","0","0","0")
    private val mSelectImage = mutableListOf(
            "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg",
            "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg",
            "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg",
            "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg",
            "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg",
            "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg",
            "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg",
            "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg"
    )

    // viewId -> requestCode
    private val mRequestCodeMap = mapOf(
            R.id.fl_img1 to 233,
            R.id.fl_img2 to 234,
            R.id.fl_img3 to 235,
            R.id.fl_img4 to 236,
            R.id.fl_img5 to 237,
            R.id.fl_img6 to 238,
            R.id.fl_img7 to 239,
            R.id.fl_img8 to 240
    )

    //requestCode -> index
    private val mIndexMap = mapOf(
            233 to 0,
            234 to 1,
            235 to 2,
            236 to 3,
            237 to 4,
            238 to 5,
            239 to 6,
            240 to 7
    )

    override val contentViewResourceID: Int
        get() = R.layout.activity_merchant_enter


    override fun initViewsAndEvents() {
        Utils.setTitle(this, "商家入驻")
        Utils.setMenuText(this, "联系客服")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val result = Boxing.getResult(data)?.get(0)
            val viewId = mRequestCodeMap.filter { it.value == requestCode }.keys.toIntArray()[0]
            val frameLayout = findViewById<FrameLayout>(viewId)
            uploadImage(bindToLifecycle(), this, result?.path) {
                mSelectImage[mIndexMap[requestCode] as Int] = it
                GlideApp.with(this).load(result?.path).into(frameLayout.getChildAt(frameLayout.childCount - 1) as ImageView)
            }

        }
    }

    /**
     * 底部 8 张图片选择
     */
    @OnClick(R.id.fl_img1, R.id.fl_img2, R.id.fl_img3, R.id.fl_img4, R.id.fl_img5, R.id.fl_img6, R.id.fl_img7, R.id.fl_img8)
    fun selectImage(v: View) {
        val boxingConfig = BoxingConfig(BoxingConfig.Mode.SINGLE_IMG)
        val requestCode: Int? = mRequestCodeMap[v.id]
        Boxing.of(boxingConfig).withIntent(this, BoxingActivity::class.java).start(this, requestCode as Int)
    }

    /**
     * 鱼友 and 淘淘 切换
     */
    @OnClick(R.id.ll_tab1, R.id.ll_tab2)
    fun tabChange(v: View) {
        mSelectShopType = if (v.id == R.id.ll_tab1) 2 else 1
    }

    /**
     * 提交
     */
    @OnClick(R.id.tv_post)
    fun post(v: View) {
        when (validate()) {
            true -> {
                //提交数据
                val userId = UserManager.getUser().userInfo_ID
                val nickName = UserManager.getUser().userInfo_NickName
                val realName = et_real_name.text.toString().trim()
                val idCard = et_id_card.text.toString().trim()
                val phoneNumber = et_phone_number.text.toString().trim()
                val qualificationMap = mapOf(
                        "Qualification1" to mSelectImage[0],
                        "Qualification2" to mSelectImage[1],
                        "Qualification3" to mSelectImage[2],
                        "Qualification4" to mSelectImage[3],
                        "Qualification5" to mSelectImage[4],
                        "Qualification6" to mSelectImage[5],
                        "Qualification7" to mSelectImage[6],
                        "Qualification8" to mSelectImage[7]
                )
                val observable = Api.create(ShopApi::class.java).applyShop(
                                userId,
                                nickName,
                                realName,
                                idCard,
                                phoneNumber,
                                mSelectShopType.toString(),
                                qualificationMap)
                handlerObservable(observable,this,bindToLifecycle()){
                    ToastUtils.showToast("入驻成功!")
                    finish()
                }
            }
        }
    }

    /**
     * 验证
     */
    private fun validate(): Boolean {
        if (!Utils.isEmpty(
                arrayOf("请填写姓名", "请填写身份证号码", "请填写电话号码"),
                et_real_name, et_id_card, et_phone_number)) {
            return false
        }
//        else if (mSelectImage.size < 8) {
//            ToastUtils.showToast("请选择证件照片")
//            return false
//        }
        return true
    }


    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, MerchantEnterActivity::class.java)
            context.startActivity(intent)
        }
    }

}
