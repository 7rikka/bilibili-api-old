package nya.nekoneko.bilibili.model.archive;

import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

public class BilibiliArchiveViewNew {
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
    @ONodeAttr(name = "act_reserve_create")
    private int act_reserve_create;

    private int interactive;
    private int mission_id;
    /**
     * 杜比音效
     * 0.停用
     * 1.启用
     */
    private int dolby;
    private int no_reprint;
    /**
     * 开启精选评论(关闭评论时不可用)
     */
    private boolean up_selection_reply;
    /**
     * 关闭评论(开启精选评论时不可用)
     */
    private boolean up_close_reply;
    /**
     * 关闭弹幕
     */
    private boolean up_close_danmu;
    /**
     * 充电面板
     * 0.停用
     * 1.启用
     */
    private int open_elec;
    private String csrf;
    /**
     * 商业推广信息(可选)
     */
    private BilibiliArchivePorder porder;
    /**
     * 联合投稿信息(可选)
     */
    private BilibiliArchiveStaff staffs;
}