package nya.nekoneko.bilibili.api.fav;

import nya.nekoneko.bilibili.model.BilibiliFolder;

public interface IFav {
    /**
     * 创建收藏夹
     *
     * @param title 收藏夹名称
     * @param desc  收藏夹简介
     * @param hide  是否隐藏（仅对自己可见）1: 是 0: 否
     * @param cover 收藏夹封面
     * @return 收藏夹id
     */
    Integer addFavFolder(String title, String desc, boolean hide, String cover);

    /**
     * 获取收藏夹信息
     *
     * @param id 收藏夹id
     * @return 收藏夹信息
     */
    BilibiliFolder getFavFolderInfo(int id);

    /**
     * 编辑收藏夹信息
     *
     * @param folder 收藏夹信息
     * @return 修改是否成功
     */
    boolean editFavFolder(BilibiliFolder folder);

    /**
     * 编辑收藏夹信息
     *
     * @param folder 收藏夹信息
     * @param isHide 是否隐藏（仅对自己可见）
     * @return 修改是否成功
     */
    boolean editFavFolder(BilibiliFolder folder, Boolean isHide);

    /**
     * 删除收藏夹
     *
     * @param id
     * @return
     */
    boolean delFavFolder(int id);

    boolean delFavFolder(int[] ids);
}
