package cc.nekoneko.bilibili.api.message;

import cc.nekoneko.bilibili.model.BilibiliLoginInfo;
import cc.nekoneko.bilibili.model.BilibiliPictureInfo;

import java.io.File;
import java.io.IOException;

public interface IMessage {
    /**
     * 发送一条文字私信
     *
     * @param loginInfo  登录信息
     * @param receiverId 接收人UID
     * @param message    私信内容
     * @return 私信id, 可用于撤回消息
     */
    Long sendMessage(BilibiliLoginInfo loginInfo, int receiverId, String message);

    /**
     * 发送一条图片私信
     * code=21037, message=图片格式不合法，不要调戏接口啦
     *
     * @param loginInfo
     * @param receiverId
     * @param file
     * @return
     * @throws IOException
     */
    Long sendPictureMessage(BilibiliLoginInfo loginInfo, int receiverId, File file) throws IOException;

    /**
     * 撤回私信
     *
     * @param receiverId 接收人UID
     * @param messageId  私信id
     * @return
     */
    boolean recallMessage(BilibiliLoginInfo loginInfo, int receiverId, long messageId);

    /**
     * 上传图片
     *
     * @param loginInfo
     * @param file
     * @return
     * @throws IOException
     */
    BilibiliPictureInfo uploadPicture(BilibiliLoginInfo loginInfo, File file) throws IOException;
}