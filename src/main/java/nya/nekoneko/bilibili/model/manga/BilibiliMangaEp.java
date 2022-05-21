package nya.nekoneko.bilibili.model.manga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMangaEp {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private Integer id;
    /**
     *
     */
    @ONodeAttr(name = "ord")
    private Integer ord;
    /**
     *
     */
    @ONodeAttr(name = "read")
    private Integer read;
    /**
     *
     */
    @ONodeAttr(name = "pay_mode")
    private Integer payMode;
    /**
     *
     */
    @ONodeAttr(name = "is_locked")
    private Boolean isLocked;
    /**
     *
     */
    @ONodeAttr(name = "pay_gold")
    private Integer payGold;
    /**
     *
     */
    @ONodeAttr(name = "size")
    private Long size;
    /**
     *
     */
    @ONodeAttr(name = "short_title")
    private String shortTitle;
    /**
     *
     */
    @ONodeAttr(name = "is_in_free")
    private Boolean isInFree;
    /**
     *
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     *
     */
    @ONodeAttr(name = "cover")
    private String cover;
    /**
     *
     */
    @ONodeAttr(name = "pub_time")
    private LocalDateTime pubTime;
    /**
     *
     */
    @ONodeAttr(name = "comments")
    private Integer comments;
    /**
     *
     */
    @ONodeAttr(name = "unlock_expire_at")
    private String unlockExpireAt;
    /**
     *
     */
    @ONodeAttr(name = "unlock_type")
    private Integer unlockType;
    /**
     *
     */
    @ONodeAttr(name = "allow_wait_free")
    private Boolean allowWaitFree;
    /**
     *
     */
    @ONodeAttr(name = "progress")
    private String progress;
    /**
     *
     */
    @ONodeAttr(name = "like_count")
    private Integer likeCount;
    /**
     *
     */
    @ONodeAttr(name = "chapter_id")
    private Integer chapterId;
    /**
     *
     */
    @ONodeAttr(name = "type")
    private Integer type;
    /**
     *
     */
    @ONodeAttr(name = "extra")
    private Integer extra;
}