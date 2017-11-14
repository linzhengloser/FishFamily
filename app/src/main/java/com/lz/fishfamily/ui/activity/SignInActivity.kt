package com.lz.fishfamily.ui.activity

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.OnClick
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.UserApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.ui.base.BaseActivity
import com.lz.fishfamily.utils.UserManager
import com.lz.library.utils.ToastUtils
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_sign_in.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/24
 * desc   : 签到
 * version: 1.0
</pre> *
 */
class SignInActivity : BaseActivity() {

    private val mSignInDrawableArray = arrayListOf(R.drawable.shape_sign_in_already, R.drawable.shape_sign_in_current, R.drawable.shape_sign_in_later)

    var mContinuousSinInNumber: Int = 0

    override val contentViewResourceID: Int
        get() = R.layout.activity_sign_in

    override fun initViewsAndEvents() {
        val userApi = Api.create(UserApi::class.java).getAlreadySignDay()
        handlerObservable(userApi,bindToLifecycle(), Consumer {
            tv_fish_money.text = UserManager.getUser().userInfo_Integer.toString()
            mContinuousSinInNumber = it.toInt()
            setSigInLayout(mContinuousSinInNumber)
            tv_sign_in_btn.text = "明日签到领${if (mContinuousSinInNumber >= 7) 10 else 5}鱼豆"
        })
    }

    private fun setSigInLayout(continuousSinInNumber: Int) {
        (0..ll_continuous_sign_in.childCount)
                .map { ll_continuous_sign_in.getChildAt(it) }
                .filter { it is LinearLayout }
                .forEachIndexed { index, view ->
                    val textView = (view as ViewGroup).getChildAt(0) as TextView
                    when {
                        index < continuousSinInNumber -> {
                            textView.setBackgroundResource(mSignInDrawableArray[0])
                            textView.setTextColor(resources.getColor(R.color.black))
                        }
                        index == continuousSinInNumber -> {
                            textView.setBackgroundResource(mSignInDrawableArray[1])
                            textView.setTextColor(resources.getColor(R.color.white))
                        }
                        else -> {
                            textView.setBackgroundResource(mSignInDrawableArray[2])
                            textView.setTextColor(resources.getColor(R.color.colorPrimary))
                        }
                    }

                }
        ll_continuous_sign_in.visibility = View.VISIBLE

    }

    @OnClick(R.id.tv_sign_in_btn)
    fun onClick(view: View) {
        val userApi = Api.create(UserApi::class.java).signToday()
        handlerObservable(userApi, bindToLifecycle(), Consumer {
            mContinuousSinInNumber++
            UserManager.setUserFishMoney(if (mContinuousSinInNumber >= 7) 10 else 5)
            setSigInLayout(mContinuousSinInNumber)
            ToastUtils.showToast(it)
        })
    }

    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, SignInActivity::class.java)
            context.startActivity(intent)
        }
    }

}
