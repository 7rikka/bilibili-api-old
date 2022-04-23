package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliRelationStat {
    /**
     * 用户uid
     */
    @ONodeAttr(name = "mid")
    private int uid;
    /**
     * 关注数
     */
    @ONodeAttr(name = "following")
    private int following;
    /**
     * 粉丝数
     */
    @ONodeAttr(name = "follower")
    private int follower;
    /**
     * 悄悄关注数(仅查自己时可用)
     */
    @ONodeAttr(name = "whisper")
    private int whisper;
    /**
     * 拉黑数(仅查自己时可用)
     */
    @ONodeAttr(name = "black")
    private int black;

}
