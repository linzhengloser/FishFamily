package com.lz.fishfamily.ui.multitype.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.Comment
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_post_comment.view.*

import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/24
 * desc   : 首页 -> 分享 帖子评论 ItemViewBinder
 * version: 1.0
</pre> *
 */
class CommentItemViewBinder : ItemViewBinder<Comment, CommentItemViewBinder.PostCommentViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): PostCommentViewHolder {
        return PostCommentViewHolder(inflater.inflate(R.layout.item_main_post_comment, parent, false))
    }

    override fun onBindViewHolder(holder: PostCommentViewHolder, item: Comment) {
        val commentContent: String = if (item.commentParent_ID == "0") {
            "${item.userName}  :  ${item.comment_Content}"
        } else {
            "${item.userName}  :  ${item.comment_Content}"
        }
        holder.itemView.tv_comment.text = commentContent

    }

    class PostCommentViewHolder(itemView: View) : BaseViewHolder(itemView)

}
