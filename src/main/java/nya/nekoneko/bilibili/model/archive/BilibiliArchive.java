package nya.nekoneko.bilibili.model.archive;

import lombok.Data;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

/**
 * https://member.bilibili.com/x/vupre/web/archive/view
 * 稿件
 *
 * @author Ho
 */
@Data
public class BilibiliArchive {
    /**
     * 稿件aid
     */
    @ONodeAttr(name = "aid")
    private Integer aid;
    /**
     * 稿件aid
     */
    @ONodeAttr(name = "bvid")
    private String bvid;
    /**
     * 稿件标题
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     * 稿件类型
     * 1.自制
     * 2.转载
     */
    @ONodeAttr(name = "copyright")
    private Integer copyright;
    /**
     * 分p列表
     */
    @ONodeAttr(name = "videos")
    private List<BilibiliArchiveVideo> videos;
    /**
     * 转载来源
     */
    @ONodeAttr(name = "source")
    private String source;
    /**
     * 分区id
     */
    @ONodeAttr(name = "tid")
    private Integer tid;
    /**
     * 封面
     */
    @ONodeAttr(name = "cover")
    private String cover;
    /**
     * tag
     */
    @ONodeAttr(name = "tag")
    private String tag;
    /**
     *
     */
    @ONodeAttr(name = "desc_format_id")
    private int desc_format_id;
    /**
     * 简介
     */
    @ONodeAttr(name = "desc")
    private String desc;
    /**
     * 粉丝动态
     */
    @ONodeAttr(name = "dynamic")
    private String dynamic;
//    /**
//     * 字幕设置
//     */
//    @ONodeAttr(name = "subtitle")
//    private BilibiliArchiveSubtitle subtitle;
//    /**
//     *
//     */
//    @ONodeAttr(name = "handle_staff")
//    private boolean handleStaff;
    /**
     * 是否为全景视频
     * -1: 否
     * 1: 是
     */
    @ONodeAttr(name = "is_360")
    private int is360;
    //    /**
//     *
//     */
//    @ONodeAttr(name = "act_reserve_create")
//    private int act_reserve_create;
//    /**
//     *
//     */
//    @ONodeAttr(name = "origin_state")
//    private int origin_state;
//    /**
//     *
//     */
//    @ONodeAttr(name = "topic_grey")
//    private int topic_grey;
//
    private String author;
    private String reject_reason;
    private String reject_reason_url;
    private Integer duration;
    private Integer no_reprint;
    private Integer ugcpay;
    private Integer order_id;
    private String order_name;
    private Integer adorder_id;
    private String adorder_name;
    private String adorder_no;
    private Integer online_time;
    private String new_adorder_info;
    private Integer mission_id;
    private String mission_name;
    private Integer attribute;
    private Integer state;
    private String state_desc;
    private Integer state_panel;
    private String porder;
    private String poi_object;
    private String dtime;
    private String ptime;
    private String ctime;
    private String ugcpay_info;
    private String vote;
    private String activity;
    private String interactive;
    private String hl;
    private String no_background;
    private String dynamic_video;
    private String no_public;
    private String bs_editor;
    private String up_from;
    private String desc_v2;
    private String dynamic_v2;
    private String topic_id;
    private String topic_name;
    private String topic_stat;
    private String premiere;
    private String tp_info;
    private String attrs;
    private String staffs;
    /**
     * 是否发起稿件预约
     * 1: 发起
     * 0: 不发起
     */
    private Integer act_reserve_create;
}