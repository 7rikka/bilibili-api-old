package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliRechargerRemark {
    private Integer aid;
    private String bvid;
    private Long id;
    private Integer mid;
    private Integer reply_mid;
    private Integer elec_num;
    /**
     * 0: 未回复
     * 1: 已回复
     */
    private Integer state;
    private String msg;
    private String aname;
    private String uname;
    private String avator;
    private String reply_name;
    private String reply_avator;
    private String reply_msg;
    private long ctime;
    private int reply_time;
}