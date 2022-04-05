package nya.nekoneko.bilibili.model.archive;

public class BilibiliArchiveVideo {

    private String filename;
    private String title;
    private String desc;
    /**
     * 上传时的biz_id
     */
    private long cid;
    private BilibiliArchiveEditor editor;
    /**
     * 是否包含动态卡片（投稿时用）
     */
    private Boolean pre_command;
}