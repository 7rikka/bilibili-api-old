package nya.nekoneko.bilibili.api.login;

import nya.nekoneko.bilibili.model.BilibiliLoginQRInfo;

/**
 * @author Ho
 */
public interface ILogin {
    /**
     * 获取扫码信息
     *
     * @return
     */
    BilibiliLoginQRInfo getQRCode();
}
