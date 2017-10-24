package com.lz.fishfamily.utils.im;

import android.util.Pair;

import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.lz.fishfamily.Constant;
import com.lz.fishfamily.MyApplication;
import com.lz.fishfamily.R;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/02
 *     desc   : 环信消息相关 Utils
 *     下列方法中的 UserId 参数 都是指的 环信ID
 *     version: 1.0
 * </pre>
 */
public class MessageUtils {

    public static EMMessage createTextMessage(String text, String userId) {
        return setUserInfoExt(EMMessage.createTxtSendMessage(text, userId));
    }

    public static EMMessage createImageMessage(String imagePath, String userId) {
        return setUserInfoExt(EMMessage.createImageSendMessage(imagePath, false, userId));
    }

    public static EMMessage createLocationMessage(Pair<Double, Double> location, String address, String userId) {
        return setUserInfoExt(EMMessage.createLocationSendMessage(location.first, location.second, address, userId));
    }

    public static EMMessage createVoiceMessage(String filePath,int length,String userId){
        return setUserInfoExt(EMMessage.createVoiceSendMessage(filePath,length,userId));
    }

    /**
     * 创建名片消息
     * @param userId
     * @return
     */
    public static EMMessage createBusinessCardMessage(String userId){
        return setUserInfoExt(EMMessage.createTxtSendMessage("", userId));
    }

    /**
     * 创建商品信息消息
     * @param userId
     * @return
     */
    public static EMMessage createCommodityInfoMessage(String userId){
        return setUserInfoExt(EMMessage.createTxtSendMessage("", userId));
    }

    public static EMMessage setUserInfoExt(EMMessage message) {
        message.setAttribute("userId", "linzheng");
        message.setAttribute("userAvatar", "http://ofdvg4c5w.bkt.clouddn.com/qm.jpg");
        message.setAttribute("userNickName", "大佬");
        return message;
    }

    public static String getMessageDigest(EMMessage message) {
        StringBuffer digest = new StringBuffer();
        switch (message.getType()) {
            case TXT:
                EMTextMessageBody txtBody = (EMTextMessageBody) message.getBody();
                if (message.getBooleanAttribute("is_voice_call", false)) {
                    digest.append(getString(R.string.im_message_type_voice_call));
                    digest.append(txtBody.getMessage());
                } else if (message.getBooleanAttribute("is_video_call", false)) {
                    digest.append(getString(R.string.im_message_type_video_call));
                    digest.append(txtBody.getMessage());
                } else {
                    digest.append(txtBody.getMessage());
                }
                break;
            case IMAGE:
                digest.append(getString(R.string.im_message_type_image));
                break;
            case LOCATION:
                if (message.direct() == EMMessage.Direct.RECEIVE) {
                    digest.append(String.format(getString(R.string.im_message_type_location_recv), message.getFrom()));
                } else {
                    digest.append(getString(R.string.im_message_type_location_sent));
                }
                break;
            case VOICE:
                digest.append(getString(R.string.im_message_type_voice));
                break;
            case VIDEO:
                digest.append(getString(R.string.im_message_type_video));
                break;
            default:
                digest.append("未知消息类型");
                break;
        }
        return digest.toString();
    }


    public static EMConversation.EMConversationType chatType2ConverstationType(int chatType) {
        if (chatType == Constant.Chat.CHAT_TYPE_SINGLE) {
            return EMConversation.EMConversationType.Chat;
        } else if (chatType == Constant.Chat.CHAT_TYPE_GROUP) {
            return EMConversation.EMConversationType.GroupChat;
        } else {
            return EMConversation.EMConversationType.ChatRoom;
        }
    }

    public static int converstationType2ChatType(EMConversation.EMConversationType chatType) {
        if (chatType == EMConversation.EMConversationType.Chat) {
            return Constant.Chat.CHAT_TYPE_SINGLE;
        } else if (chatType == EMConversation.EMConversationType.GroupChat) {
            return Constant.Chat.CHAT_TYPE_GROUP;
        } else {
            return Constant.Chat.CHAT_TYPE_CHAT_ROOM;
        }
    }

    private static String getString(int resId) {
        return MyApplication.getInstance().getString(resId);
    }

}
