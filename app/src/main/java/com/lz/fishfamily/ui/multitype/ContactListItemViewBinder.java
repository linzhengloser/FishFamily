package com.lz.fishfamily.ui.multitype;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.Contact;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/26
 *     desc   : 通讯录 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ContactListItemViewBinder extends ItemViewBinder<Contact, ContactListItemViewBinder.ContactListViewHolder> {

    @NonNull
    @Override
    protected ContactListViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ContactListViewHolder(inflater.inflate(R.layout.item_contact_list, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ContactListViewHolder holder, @NonNull Contact item) {
        holder.tv_item_contact_list_user_name.setText(item.getName());
    }

    static class ContactListViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_item_contact_list_user_name)
        TextView tv_item_contact_list_user_name;

        public ContactListViewHolder(View itemView) {
            super(itemView);
        }
    }

}
