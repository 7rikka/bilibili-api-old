package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliFolder {
    /**
     * 收藏夹完整id(原始id + uid最后两位)
     */
    @ONodeAttr(name = "id")
    private int id;
    /**
     * 收藏夹原始id
     */
    @ONodeAttr(name = "fid")
    private int fid;
    /**
     *
     */
    @ONodeAttr(name = "mid")
    private int uid;
    /**
     * 属性(?)
     */
    @ONodeAttr(name = "attr")
    private int attr;
    /**
     * 收藏夹标题
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     * 收藏夹封面
     * 0: 没有封面
     */
    @ONodeAttr(name = "cover")
    private String cover;
    /**
     * 封面图类别
     */
    @ONodeAttr(name = "cover_type")
    private int coverType;
    /**
     * 类型(?)
     */
    @ONodeAttr(name = "type")
    private int type;
    /**
     * 收藏夹描述
     */
    @ONodeAttr(name = "intro")
    private String intro;
    /**
     *
     */
    @ONodeAttr(name = "ctime", format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 上次更新时间
     */
    @ONodeAttr(name = "mtime", format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 状态(?)
     */
    @ONodeAttr(name = "state")
    private int state;
    /**
     * 当前用户是否收藏了这个收藏夹
     */
    @ONodeAttr(name = "fav_state")
    private boolean isFavorite;
    /**
     * 当前用户是否点赞了这个收藏夹
     */
    @ONodeAttr(name = "like_state")
    private boolean isLike;
    /**
     * 已收藏视频数
     */
    @ONodeAttr(name = "media_count")
    private int videoCount;
    /**
     * 收藏数
     */
    public int favoriteCount;
    /**
     * 播放数
     */
    public int playCount;
    /**
     * 点赞数
     */
    public int likeCount;
    /**
     * 分享数
     */
    public int shareCount;
}
