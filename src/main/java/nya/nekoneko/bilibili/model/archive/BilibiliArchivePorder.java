package nya.nekoneko.bilibili.model.archive;

public class BilibiliArchivePorder {
    private int flow_id;
    /**
     * 推广分类id
     * 1.手机游戏
     * 2.软件应用
     * 3.日用品化妆品
     * 4.服装鞋帽
     * 5.箱包饰品
     * 6.食品饮料
     * 7.出版传媒
     * 8.电脑硬件
     * 9.其他
     * 20.主机游戏
     * 21.网页游戏
     * 22.PC单机游戏
     * 23.PC网络游戏
     * 213.医疗类
     * 214.金融
     */
    private int industry_id;
    /**
     * 品牌id
     */
    private int brand_id;
    /**
     * 品牌名
     */
    private String brand_name;
    /**
     * 是否是哔哩哔哩合作品牌
     */
    private int official;
    /**
     * 推广形式
     * 10.其它
     * 11.口播
     * 12.贴片
     * 13.字幕推广
     * 14.TVC植入
     * 15.Logo
     * 16.二维码
     * 17.Slogan
     * 18.节目赞助
     * 19.定制软广
     */
    private int show_type;
}
