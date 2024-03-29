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
    // 当前版本
    public static final String GET_MY_NOTITY = "https://message.bilibili.com/x/sys-msg/query_notify_list";
//    public static final String GET_MY_NOTITY = "https://message.bilibili.com/api/notify/query.sysnotify.list.do";
    /**
     * 获取最近收到的弹幕
     */
    public static final String GET_RECENT_DANMAKU_LIST = "https://api.bilibili.com/x/v2/dm/recent";
    public static final String SEARCH_RECENT_DANMAKU_LIST = "https://api.bilibili.com/x/v2/dm/search";
    /**
     * 获取视频实时弹幕
     */
    public static final String GET_VIDEO_DANMAKU_LIST = "https://api.bilibili.com/x/v2/dm/web/seg.so";
    /**
     * 获取最近收到的评论
     */
    public static final String GET_RECENT_REPLY_LIST = "https://member.bilibili.com/x/web/replies";
    /**
     * 获取视频评论
     */
    public static final String GET_VIDEO_REPLY_LIST = "https://api.bilibili.com/x/v2/reply/main";
    /**
     * 检查昵称可用性
     */
    public static final String CHECK_NAME_AVAILABLE = "http://passport.bilibili.com/web/generic/check/nickname";
    /**
     * (UP主)获取充电记录
     */
    public static final String GET_RECHARGE_RECORD = "https://pay.bilibili.com/bk/brokerage/listForCustomerRechargeRecord";
    /**
     * (UP主)获取充电留言记录
     */
    public static final String GET_RECHARGE_REMARK = "https://member.bilibili.com/x/web/elec/remark/list";
    /**
     * (旧)获取充电列表
     */
    public static final String OLD_GET_ELECTRIC_LIST = "http://member.bilibili.com/x/h5/elec/rank/recent";
    /**
     * 漫画签到
     */
    public static final String MANGA_CLOCK_IN = "https://manga.bilibili.com/twirp/activity.v1.Activity/ClockIn";
    /**
     * 获取签到信息
     */
    public static final String MANGA_CLOCK_IN_INFO = "https://manga.bilibili.com/twirp/activity.v1.Activity/GetClockInInfo";
    /**
     * 修改稿件信息(网页端)
     */
    public static final String EDIT_ARCHIVE = "https://member.bilibili.com/x/vu/web/edit";
    /**
     * 修改稿件信息(App端)
     */
    public static final String EDIT_ARCHIVE_APP = "https://member.bilibili.com/x/vu/app/edit/full";
    /**
     * 新增稿件信息(网页端)
     */
    public static final String SUBMIT_ARCHIVE = "https://member.bilibili.com/x/vu/web/add";
    /**
     * 新增稿件信息(App端)
     */
    public static final String SUBMIT_ARCHIVE_APP = "https://member.bilibili.com/x/vu/app/add";
    /**
     * 获取稿件所有分p列表, 包含已经删除的分p
     */
    public static final String GET_ARCHIVE_ALL_PARTS = "https://member.bilibili.com/x/web/archive/parts";
    /**
     * 获取稿件列表
     */
    public static final String GET_ARCHIVE_LIST = "https://member.bilibili.com/x/web/archives";
    /**
     * 获取我的积分信息
     */
    public static final String GET_POINT_INFO = "https://manga.bilibili.com/twirp/pointshop.v1.Pointshop/GetUserPoint";
    /**
     * (漫画)获取积分商城奖品列表
     */
    public static final String GET_PRODUCT_LIST = "https://manga.bilibili.com/twirp/pointshop.v1.Pointshop/ListProduct";
    /**
     * (漫画)积分商城兑换奖品
     */
    public static final String EXECHANGE_PRODUCT = "https://manga.bilibili.com/twirp/pointshop.v1.Pointshop/Exchange";
    /**
     * APP开屏图片
     */
    public static final String GET_APP_SPLASH = "http://app.bilibili.com/x/v2/splash/brand/list";
    /**
     * 漫画详情
     */
    public static final String MANGA_DETAIL = "https://manga.bilibili.com/twirp/comic.v1.Comic/ComicDetail";
    /**
     * 获取章节图片信息
     */
    public static final String GET_MANGA_IMAGE_INDEX = "https://manga.bilibili.com/twirp/comic.v1.Comic/GetImageIndex";
    /**
     * 获取图片token
     */
    public static final String GET_IMAGE_TOKEN = "https://manga.bilibili.com/twirp/comic.v1.Comic/ImageToken";
    /**
     * (漫画)获取赛季信息
     */
    public static final String GET_SEASON_INFO = "https://manga.bilibili.com/twirp/user.v1.Season/GetSeasonInfo";
    /**
     * (漫画)获取漫读券列表
     */
    public static final String GET_COUPON_LIST = "https://manga.bilibili.com/twirp/user.v1.User/GetCoupons";
    /**
     * (漫画)购买漫画章节
     */
    public static final String BUY_MANGA_EPISODE = "https://manga.bilibili.com/twirp/comic.v1.Comic/BuyEpisode";
    /**
     * 退出登录
     */
    public static final String LOGOUT_URL = "https://passport.bilibili.com/login/exit/v2";
    /**
     * 获取二维码扫描结果
     */
    public static final String GET_QR_SCAN_RESULT = "https://passport.bilibili.com/x/passport-login/web/qrcode/poll";
    /**
     * 获取登录二维码
     */
    public static final String GET_QR = "https://passport.bilibili.com/x/passport-login/web/qrcode/generate";
    /**
     * 获取视频播放流
     */
    public static final String GET_VIDEO_URL = "https://api.bilibili.com/x/player/playurl";
    /**
     * 获取用户信息
     */
    public static final String GET_USER_INFO = "http://api.bilibili.com/x/space/acc/info";
}
