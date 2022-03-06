package cc.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 粉丝牌子
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMedal {
    private Integer uid;
    private Integer target_id;
    private Integer medal_id;
    private Integer level;
    private String medal_name;
    private Integer medal_color;
    private Integer intimacy;
    private Integer next_intimacy;
    private Integer day_limit;
    private Integer medal_color_start;
    private Integer medal_color_end;
    private Integer medal_color_border;
    private Boolean is_lighted;
    private Boolean light_status;
    private Boolean wearing_status;
    private Boolean score;

}
