package nya.nekoneko.bilibili.api.message;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliPictureInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MessageApi implements IMessage {
    private final BilibiliLoginInfo loginInfo;
    public static final Map<String, String> pictureType;

    static {
        pictureType = new HashMap<>();
        pictureType.put("jpg", "jpeg");
        pictureType.put("png", "png");
        pictureType.put("gif", "gif");
    }

    public MessageApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 发送一条文字私信
     *
     * @param receiverId 接收人UID
     * @param message    私信内容
     * @return 私信id, 可用于撤回消息
     */
    @Override
    public Long sendMessage(int receiverId, String message) {
        Map<String, String> map = getMessageData(loginInfo.getCsrf(), loginInfo.getUid(), receiverId, 1, message);
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.SEND_MESSAGE)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            long msgKey = result.getData().get("msg_key").getLong();
            log.info("发送文字私信[{}]成功, 信息id: {}.", message, msgKey);
            return msgKey;
        } else {
            log.error("发送文字私信[{}]失败, 返回: {}.", message, result);
            return null;
        }
    }

    /**
     * 发送一条图片私信
     * code=21037, message=图片格式不合法，不要调戏接口啦
     *
     * @param receiverId
     * @param pictureInfo
     * @return
     */
    @Override
    public Long sendPictureMessage(int receiverId, BilibiliPictureInfo pictureInfo) {
        ONode node = ONode.newObject()
                .set("height", pictureInfo.getHeight())
                .set("width", pictureInfo.getWidth())
                .set("imageType", pictureType.get(pictureInfo.getSuffix()))
                .set("original", 1)
                .set("size", pictureInfo.getSize() / 1024)
                .set("url", pictureInfo.getUrl());
        Map<String, String> messageData = getMessageData(loginInfo.getCsrf(), loginInfo.getUid(), receiverId, 2, node.toString());
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.SEND_MESSAGE)
                .postForm(messageData)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            long msgKey = result.getData().get("msg_key").getLong();
            log.info("发送图片私信[{}]成功, 信息id: {}.", pictureInfo.getFilename(), msgKey);
            return msgKey;
        } else {
            log.error("发送图片私信[{}]失败, 返回: {}.", pictureInfo.getFilename(), result);
            return null;
        }
    }

    /**
     * 撤回私信
     * code=21041, message=消息已超期，不能撤回了哦
     * code=21042, message=消息已经撤回了哦
     *
     * @param receiverId 接收人UID
     * @param messageId  私信id
     * @return
     */
    @Override
    public boolean recallMessage(int receiverId, long messageId) {
        Map<String, String> map = getMessageData(loginInfo.getCsrf(), loginInfo.getUid(), receiverId, 5, String.valueOf(messageId));
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.SEND_MESSAGE)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0 || result.getCode() == 21042) {
            log.info("已撤回私信: {}.", messageId);
            return true;
        } else if (result.getCode() == 21041) {
            log.error("撤回私信: {} 失败, 已超期, 无法撤回.", messageId);
            return false;
        } else {
            log.error("撤回私信: {} 失败, 返回: {}.", messageId, result);
            return false;
        }
    }
    /**
     * 生成私信参数
     *
     * @param csrf        csrf
     * @param senderId    发送者UID
     * @param receiverId  接收者UID
     * @param messageType 私信类型 1.文字 2.图片 5.撤回私信
     * @param content     私信内容
     * @return 参数
     */
    private Map<String, String> getMessageData(String csrf, int senderId, int receiverId, int messageType, String content) {
        Map<String, String> map = new HashMap<>();
        map.put("csrf", csrf);
        map.put("msg[sender_uid]", String.valueOf(senderId));
        map.put("msg[receiver_id]", String.valueOf(receiverId));
        map.put("msg[receiver_type]", "1");
        map.put("msg[msg_type]", String.valueOf(messageType));
        map.put("msg[msg_status]", "0");
        map.put("msg[dev_id]", getDevId());
        map.put("msg[timestamp]", String.valueOf(System.currentTimeMillis() / 1000));
        if (1 == messageType) {
            //发送文字私信
            map.put("msg[content]", "{\"content\":\"" + content + "\"}");
        } else if (2 == messageType || 5 == messageType) {
            //撤回私信
            map.put("msg[content]", content);
        }
        //非必要参数
        //是否使用新版表情
        //旧版: 小电视doge 新版: 狗头doge
        map.put("msg[new_face_version]", "0");
        map.put("from_firework", "0");
        map.put("build", "0");
        map.put("mobi_app", "0");
        map.put("csrf_token", "0");
        return map;
    }

    /**
     * 获取dev_id
     * https://github.com/andywang425/BLTH/blob/45fe93e31754ca8bf07059d46266398e787dbf45/B%E7%AB%99%E7%9B%B4%E6%92%AD%E9%97%B4%E6%8C%82%E6%9C%BA%E5%8A%A9%E6%89%8B.js#L6618
     *
     * @return
     */
    private String getDevId() {
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] s = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".toCharArray();
        for (int i = 0; i < s.length; i++) {
            int randomInt = (int) (16 * Math.random());
            if ('-' == s[i] || '4' == s[i]) continue;
            if ('x' == s[i]) {
                s[i] = b[randomInt];
            } else {
                s[i] = b[3 & randomInt | 8];
            }
        }
        return new String(s);
    }
}
