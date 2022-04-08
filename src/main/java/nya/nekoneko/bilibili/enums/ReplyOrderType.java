package nya.nekoneko.bilibili.enums;

/**
 * 查询评论所用排序方式
 *
 * @author Ho
 */

public enum ReplyOrderType {
    /**
     * 最近发布
     */
    CTIME {
        @Override
        public String toString() {
            return "ctime";
        }
    },
    /**
     * 点赞最多
     */
    LIKE {
        @Override
        public String toString() {
            return "like";
        }
    },
    /**
     * 回复最多
     */
    COUNT {
        @Override
        public String toString() {
            return "count";
        }
    }
}
