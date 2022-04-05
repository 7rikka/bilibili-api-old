package nya.nekoneko.bilibili.model.archive;

import lombok.Data;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

@Data
public class BilibiliArchiveView {
    /**
     * 稿件aid
     */
    @ONodeAttr(name = "aid")
    private int aid;
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
    private int copyright;
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
    private int tid;
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
    /**
     * 字幕设置
     */
    @ONodeAttr(name = "subtitle")
    private BilibiliArchiveSubtitle subtitle;
    /**
     *
     */
    @ONodeAttr(name = "handle_staff")
    private boolean handleStaff;
    /**
     * 是否为全景视频
     * -1: 否
     * 1: 是
     */
    @ONodeAttr(name = "is_360")
    private int is_360;
    /**
     *
     */
    @ONodeAttr(name = "act_reserve_create")
    private int act_reserve_create;
    /**
     *
     */
    @ONodeAttr(name = "origin_state")
    private int origin_state;
    /**
     *
     */
    @ONodeAttr(name = "topic_grey")
    private int topic_grey;
}