package com.lz.fishfamily.ui.activity.mine

import android.content.Context
import android.content.Intent
import android.view.View
import butterknife.OnClick
import com.lz.fishfamily.R
import com.lz.fishfamily.ui.base.BaseActivity
import com.lz.fishfamily.utils.UserManager
import com.lz.fishfamily.utils.Utils
import com.lz.fishfamily.utils.glide.GlideApp
import kotlinx.android.synthetic.main.activity_profile.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/17
 * desc   : 我的 -> 基本信息
 * version: 1.0
</pre> *
 */
class ProfileActivity : BaseActivity() {

    val user = UserManager.getUser()

    override val contentViewResourceID: Int
        get() = R.layout.activity_profile

    override fun initViewsAndEvents() {
        Utils.setTitle(this, "基本信息")
        GlideApp.with(this).load(user.userInfo_HeadImg).loadAvatar().into(iv_avatar)
        tv_nick_name.text = user.userInfo_NickName
        tv_gender.text = Utils.getGenderStr(user.userInfo_Sex)
        tv_district.text = "${user.userInfo_Provice}${user.userInfo_City}${user.userInfo_Region}${user.userInfo_DetailAddress}"
        tv_desc.text = user.userInfo_Describe
        tv_tag.text = user.userInfo_Labelling
        tv_fish_money.text = user.userInfo_Integer.toString()
        UserManager.bindUserLevel(iv_level,user.userInfo_Level)
    }

    @OnClick(R.id.ll_tag)
    fun onClick(view: View) {
        if (view.id == R.id.ll_tag) {
            SelectTagActivity.toActivity(this)
        }
    }

    companion object {


        fun toActivity(context: Context) {
            val intent = Intent(context, ProfileActivity::class.java)
            context.startActivity(intent)
        }
    }

}
