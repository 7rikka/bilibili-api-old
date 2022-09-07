package nya.nekoneko.bilibili.api.login;

import nya.nekoneko.bilibili.model.BilibiliLoginQRInfo;
import nya.nekoneko.bilibili.model.BilibiliLoginQRScanInfo;

/**
 * @author Ho
 */
public interface ILogin {
    /**
     * 获取扫码信息, 返回扫描Url和二维码key
     *
     * @return
     */
    BilibiliLoginQRInfo getQRCode();

    /**
     * 获取二维码扫描的结果
     * Code 0: 成功, 同时返回登录信息
     * Code 86038: 二维码已失效
     * Code 86090: 二维码已扫码未确认
     * Code 86101: 未扫码
     *
     * @param key 验证码key
     */
    BilibiliLoginQRScanInfo QRLogin(String key);
}
