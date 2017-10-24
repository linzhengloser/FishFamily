package com.lz.fishfamily.module.mine;

import android.util.SparseArray;

import com.lz.fishfamily.R;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/13
 *     desc   : 我的 simple item
 *     version: 1.0
 * </pre>
 */
public class MineSimpleItem {

    public static final int TYPE_MY_WALLET = 1;

    public static final int TYPE_TRANSACTION_RECORD = 2;

    public static final int TYPE_MY_SHOPPINT_CAR = 3;

    public static final int TYPE_TASK_CENTER = 4;

    public static final int TYPE_DRAFT_BOX = 5;

    public static final int TYPE_SHARE = 6;

    public static final int TYPE_FEEDBACK = 7;

    public static final int TYPE_SETTING = 8;

    public static final int TYPE_MERCHANT_ENTER = 9;

    private static SparseArray<Integer> sTypeMap = new SparseArray<>(9);

    static {
        sTypeMap.put(R.drawable.mine_simple_item_wallet, TYPE_MY_WALLET);
        sTypeMap.put(R.drawable.mine_simple_item_transaction_record, TYPE_TRANSACTION_RECORD);
        sTypeMap.put(R.drawable.mine_simple_item_shopping_cart, TYPE_MY_SHOPPINT_CAR);
        sTypeMap.put(R.drawable.mine_simple_item_task_center, TYPE_TASK_CENTER);
        sTypeMap.put(R.drawable.mine_simple_item_draft_box, TYPE_DRAFT_BOX);
        sTypeMap.put(R.drawable.mine_simple_item_share, TYPE_SHARE);
        sTypeMap.put(R.drawable.mine_simple_item_feedback, TYPE_FEEDBACK);
        sTypeMap.put(R.drawable.mine_simple_item_setting, TYPE_SETTING);
        sTypeMap.put(R.drawable.mine_simple_item_merchant_enter, TYPE_MERCHANT_ENTER);
    }

    private int type;

    private int icon;

    private String desc;

    private boolean isNeedArrows = true;

    private boolean isNeedNotificationNumber = false;

    private boolean isNeedLine = true;

    public MineSimpleItem(int icon, String desc) {
        this.icon = icon;
        this.desc = desc;
        type = sTypeMap.get(icon);
    }

    public int getType() {
        return type;
    }

    public MineSimpleItem setType(int type) {
        this.type = type;
        return this;
    }

    public int getIcon() {
        return icon;
    }

    public MineSimpleItem setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public MineSimpleItem setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public boolean isNeedArrows() {
        return isNeedArrows;
    }

    public MineSimpleItem setNeedArrows(boolean needArrows) {
        isNeedArrows = needArrows;
        return this;
    }

    public boolean isNeedLine() {
        return isNeedLine;
    }

    public MineSimpleItem setNeedLine(boolean needLine) {
        isNeedLine = needLine;
        return this;
    }

    public boolean isNeedNotificationNumber() {
        return isNeedNotificationNumber;
    }

    public MineSimpleItem setNeedNotificationNumber(boolean needNotificationNumber) {
        isNeedNotificationNumber = needNotificationNumber;
        return this;
    }
}
