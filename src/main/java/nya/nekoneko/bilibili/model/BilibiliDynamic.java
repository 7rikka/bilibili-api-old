package nya.nekoneko.bilibili.model;

import java.util.List;

/**
 * 动态详情
 * https://t.bilibili.com/633381245297885184?tab=2
 */
public class BilibiliDynamic {
    private Long dynamic_id;
    private String timestamp;
    private Integer orig_type;
    private Integer uid_type;
    private Integer r_type;
    private Integer status;
    private Integer pre_dy_id_str;
    private Integer orig_dy_id_str;
    /**
     * Card中的内容=======================
     */
    private String at_control;
    private String category;
    /**
     * 动态正文
     */
    private String content;
    private Integer uid;
    private Integer type;
    private Integer rid;
    private Integer view;
    /**
     * 转发
     */
    private Integer repost;
    /**
     * 评论
     */
    private Integer comment;
    /**
     * 点赞
     */
    private Integer like;
    private Boolean is_liked;

    /**
     * 用于获取动态的回复
     */
    private Integer oid;
    private Boolean is_fav;
    private List<BilibiliDynamicPicture> pictures;
    private Integer pictures_count;
    //list
    private String role;
    //obj
    private String settings;
    //list
    private String source;
    private String title;
    private String upload_time;
    /**
     * obj -> string
     */
    private String card_user;

    public static class BilibiliDynamicCardUser{


    }
    public static class BilibiliDynamicPicture{
        /**
         * 图片高度
         */
        private Integer img_height;
        /**
         * 图片宽度
         */
        private Integer img_width;
        private String img_tags;
        private String img_src;
        private String img_size;

    }
}
