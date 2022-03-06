package cc.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 直播间信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliLiveRoom {
    /**
     * 直播间状态
     * 0: 没开通直播间
     * 1: 开通了直播间
     */
    @ONodeAttr(name = "roomStatus")
    private Integer roomStatus;
    /**
     * 直播状态
     * 0: 没在直播
     * 1: 正在直播
     */
    @ONodeAttr(name = "liveStatus")
    private Integer liveStatus;
    /**
     * 直播间地址
     */
    @ONodeAttr(name = "url")
    private String url;
    /**
     * 直播间标题
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     * 直播间封面
     */
    @ONodeAttr(name = "cover")
    private String cover;
    /**
     * 人气值
     */
    @ONodeAttr(name = "online")
    private Integer online;
    /**
     * 直播间id
     */
    @ONodeAttr(name = "roomid")
    private Integer roomId;
    /**
     * 轮播状态
     */
    @ONodeAttr(name = "roundStatus")
    private Integer roundStatus;
    /**
     *
     */
    @ONodeAttr(name = "broadcast_type")
    private Integer broadcast_type;
}
