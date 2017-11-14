package com.lz.fishfamily;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/18
 *     desc   : 常量声明类
 *     version: 1.0
 * </pre>
 */
public class Constant {

    public static final int PAGE_SIZE = 10;

    public static final String PAGE_SIZE_KEY ="rows";

    public static final String PAGE_INDEX_KEY ="page";

    // -------------------- 公共字段 Key 和 Value --------------------

    //排序字段 Key
    public static final String SORT_FIELD_KEY = "sidx";

    //筛选条件 Key
    public static final String SCREEN_CONDITION_KEY = "conditionJson";

    //默认筛选条件
    public static final String DEFAULT_SCREEN_CONDITION = "{}";

    //排序方式 Key
    public static final String SORT_KEY = "sord";

    //默认排序方式
    public static final String DEFAULT_SORT = "desc";

    public static final String TEST_IMAGE_URL = "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg";

    public static final String INTENT_KEY_USER_ID = "user_id";

    public static final String INTENT_KEY_TYPE = "type";


    public static class Chat {

        public static final String INTENT_KEY_CHAT_TYPE = "chat_type";

        public static final String INTENT_KEY_CHAT_USER_ID = "chat_user_id";

        public static final String INTENT_KEY_IS_CALL = "is_call";

        public static final int CHAT_TYPE_SINGLE = 1;

        public static final int CHAT_TYPE_GROUP = 2;

        public static final int CHAT_TYPE_CHAT_ROOM = 3;

        public static final int CHAT_LOAD_PAGE_SIZE = 20;

    }


}
