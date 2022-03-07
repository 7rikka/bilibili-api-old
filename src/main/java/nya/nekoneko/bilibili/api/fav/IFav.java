package nya.nekoneko.bilibili.api.fav;

public interface IFav {
    /**
     * @param title 收藏夹名称
     * @param desc  收藏夹简介
     * @param hide  是否隐藏（仅对自己可见）
     * @param cover 收藏夹封面
     * @return 收藏夹id
     */
    Integer newFavFolder(String title,String desc,boolean hide,String cover);

    void getFolderInfo(int id);
}
