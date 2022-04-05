package nya.nekoneko.bilibili.model.archive;

import lombok.Data;

@Data
public class BilibiliArchiveStaff {
    /**
     * 关联UP主职能
     * 文案
     * 配音
     * 视频制作
     * 参演
     * 后期
     * 填词
     * 调音
     * 剪辑
     * 字幕
     * 渲染
     * 模型
     * 动作
     */
    private String title;
    /**
     * 用户mid
     */
    private int mid;
}
