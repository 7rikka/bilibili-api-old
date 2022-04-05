package nya.nekoneko.bilibili.model.archive;

import lombok.Data;
import org.noear.snack.annotation.ONodeAttr;

@Data
public class BilibiliArchiveSubtitle {
    /**
     * 0.不允许观众投稿字幕
     * 1.允许观众投稿字幕
     */
    @ONodeAttr(name = "open")
    private int open;
    /**
     * 语言类型
     * 例: zh-CN
     */
    @ONodeAttr(name = "lan")
    private String lan;
}