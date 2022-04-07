package nya.nekoneko.bilibili.config;

/**
 * 接口地址
 */
public class UrlConfig {
    /**
     * 动态详情信息
     */
    public static final String DYNAMIC_DETAIL = "https://api.vc.bilibili.com/dynamic_svr/v1/dynamic_svr/get_dynamic_detail";
    /**
     * 领取大会员礼包
     */
    public static final String RECIVE_PRIVILEGE = "https://api.bilibili.com/x/vip/privilege/receive";
    /**
     * 获取个人信息
     */
    public static final String USER_INFO = "https://api.bilibili.com/x/space/acc/info";
    /**
     * 发送私信
     */
    public static final String SEND_MESSAGE = "https://api.vc.bilibili.com/web_im/v1/web_im/send_msg";
    /**
     * 上传图片
     */
    public static final String UPLOAD_IMAGE = "https://api.bilibili.com/x/dynamic/feed/draw/upload_bfs";
    /**
     * 获取所有成就勋章
     */
    public static final String ALL_MEDAL_INFO = "https://api.bilibili.com/x/member/medal/all/info";
    /**
     * 获取我的成就勋章
     */
    public static final String MY_MEDAL_INFO = "https://api.bilibili.com/x/member/medal/my/info";
    /**
     * 新建收藏夹
     */
    public static final String ADD_FAV_FOLDER = "https://api.bilibili.com/x/v3/fav/folder/add";
    /**
     * 收藏夹信息
     */
    public static final String FOLDER_INFO = "https://api.bilibili.com/x/v3/fav/folder/info";
    /**
     * 编辑收藏夹信息
     */
    public static final String EDIT_FAV_FOLDER = "https://api.bilibili.com/x/v3/fav/folder/edit";
    /**
     * 删除收藏夹
     */
    public static final String DEL_FAV_FOLDER = "https://api.bilibili.com/x/v3/fav/folder/del";
    /**
     * 上传封面
     */
    public static final String UPLOAD_COVER = "https://member.bilibili.com/x/vu/web/cover/up";
    /**
     * 粉丝勋章领取状态总览
     */
    public static final String FAN_MEDAL_STAT = "https://member.bilibili.com/x/web/medal/fans";
    /**
     * 投稿前获取信息
     */
    public static final String ARCHIVE_PRE = "https://member.bilibili.com/x/vupre/web/archive/pre";
    /**
     * 获取自动生成的缩略图列表
     */
    public static final String GET_RECOVER_LIST = "https://member.bilibili.com/x/vupre/web/archive/recovers";
    /**
     * 获取稿件投稿信息
     */
    public static final String GET_ARCHIVE_VIEW = "https://member.bilibili.com/x/vupre/web/archive/view";
    /**
     * 获取用户关注数、粉丝数信息
     */
    public static final String RELATION_STAT = "https://api.bilibili.com/x/relation/stat";
    /**
     * 获取我的系统通知
     */
//    public static final String GET_MY_NOTITY = "https://message.bilibili.com/x/sys-msg/query_user_notify";
    public static final String GET_MY_NOTITY = "https://message.bilibili.com/x/sys-msg/query_notify_list";
    /**
     * 获取最近收到的弹幕
     */
    public static final String GET_RECENT_DANMAKU_LIST = "https://api.bilibili.com/x/v2/dm/recent";
    /**
     * 获取视频实时弹幕
     */
    public static final String GET_VIDEO_DANMAKU = "https://api.bilibili.com/x/v2/dm/web/seg.so";
}
