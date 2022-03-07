package nya.nekoneko.bilibili.model;

import lombok.Data;
import org.noear.snack.ONode;

@Data
public class BiliResult {
    /**
     * 响应码
     * <p>0     成功 </p>
     * <p>-400  请求失败</p>
     * <p>-101  未登录</p>
     */
    private Integer code;
    /**
     * 请求消息
     */
    private String message;
    /**
     * 实际数据
     */
    private ONode data;
    /**
     * 消息
     */
    private String msg;

    /**
     * 获取数据 对象
     *
     * @param tClass 类型
     * @param <T>    对象
     * @return t
     */
    public <T> T toData(Class<T> tClass) {
        return ONode.deserialize(data.toString(), tClass);
    }
}