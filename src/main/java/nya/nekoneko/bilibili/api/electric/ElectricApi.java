package nya.nekoneko.bilibili.api.electric;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.convert.ConvertFactory;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliRechargeRecord;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.List;

/**
 * 充电相关
 *
 * @author Ho
 */
public class ElectricApi implements IElectric {
    private final BilibiliLoginInfo loginInfo;

    public ElectricApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取我收到的充电列表
     *
     * @param page     页数
     * @param pageSize 分页大小 范围[1,50]
     * @return 充电记录列表
     */
    @Override
    public List<BilibiliRechargeRecord> getRechargeRecordList(int page, int pageSize) {
        return getRechargeRecordList(page, pageSize, null, null);
    }

    /**
     * 获取我收到的充电列表
     *
     * @param page      页数
     * @param pageSize  分页大小 范围[1,50]
     * @param beginTime 开始日期
     * @param endTime   结束日期
     * @return 充电记录列表
     */
    @Override
    public List<BilibiliRechargeRecord> getRechargeRecordList(int page, int pageSize, String beginTime, String endTime) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_RECHARGE_RECORD)
                .addParam("currentPage", page)
                .addParam("pageSize", pageSize)
                .addParam("customerId", 10026)
                .addParam("beginTime", beginTime)
                .addParam("endTime", endTime)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (0 == result.getCode()) {
            ONode node = result.getData().get("result");
            return ConvertFactory.convertList(node, BilibiliRechargeRecord.class);
        }
        return null;
    }

    /**
     * @param page      页数
     * @param pageSize  分页大小[1,12]
     * @param startDate 起始日期
     * @param endDate   结束日期(2050-01-01)
     */
    public void getRechargeRemarkList(int page, int pageSize, String startDate, String endDate) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_RECHARGE_REMARK)
                .addParam("pn", page)
                .addParam("ps", pageSize)
                .addParam("begin", startDate)
                .addParam("end", endDate)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result);
    }
}
