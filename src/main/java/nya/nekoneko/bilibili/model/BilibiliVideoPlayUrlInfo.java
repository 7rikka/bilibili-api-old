package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliVideoPlayUrlInfo {
    private Integer quality;
    private String format;
    private Integer timelength;
    @ONodeAttr(name = "support_formats")
    private List<Format> supportFormats;
    @ONodeAttr(name = "vidio_list")
    private List<BilibiliVideoPlayUrlInfo.VideoUrlInfo> videoList;
    @ONodeAttr(name = "audio_list")
    private List<BilibiliVideoPlayUrlInfo.AudioUrlInfo> audioList;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Format {
        private Integer quality;
        private String format;
        @ONodeAttr(name = "new_description")
        private String newDescription;
        @ONodeAttr(name = "display_desc")
        private String displayDesc;
        private String superscript;
        private List<String> codecs;
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VideoUrlInfo {
        /**
         * 清晰度代码
         */
        private Integer id;
        @ONodeAttr(name = "base_url")
        private String url;
        @ONodeAttr(name = "backup_url")
        private List<String> backupUrl;
        private String codecs;
        private Integer width;
        private Integer height;
        @ONodeAttr(name = "frame_rate")
        private Double frameRate;
        private Integer codecid;
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AudioUrlInfo {
        /**
         * 清晰度代码
         */
        private Integer id;
        @ONodeAttr(name = "base_url")
        private String url;
        @ONodeAttr(name = "backup_url")
        private List<String> backupUrl;
        private String codecs;
    }
}
