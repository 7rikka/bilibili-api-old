package nya.nekoneko.bilibili.api.electric;

import nya.nekoneko.bilibili.model.BilibiliRechargeRecord;

import java.util.List;

/**
 * @author Ho
 */
public interface IElectric {
    /**
     * 获取我收到的充电列表
     *
     * @param page     页数
     * @param pageSize 分页大小 范围[1,50]
     * @return 充电记录列表
     */
    List<BilibiliRechargeRecord> getRechargeRecordList(int page, int pageSize);

    /**
     * 获取我收到的充电列表
     *
     * @param page      页数
     * @param pageSize  分页大小 范围[1,50]
     * @param beginTime 开始日期
     * @param endTime   结束日期
     * @return 充电记录列表
     */
    List<BilibiliRechargeRecord> getRechargeRecordList(int page, int pageSize, String beginTime, String endTime);
}
