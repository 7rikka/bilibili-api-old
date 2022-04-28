package nya.nekoneko.bilibili.api.app;

import nya.nekoneko.bilibili.model.app.BilibiliAppSplash;

import java.util.List;

/**
 * @author Ho
 */
public interface IApp {
    /**
     * 获取App开屏图片列表
     *
     * @return list
     */
    List<BilibiliAppSplash> getAppSplashList();
}
