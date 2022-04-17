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
     * @param page 页数
     * @return 充电记录列表
     */
    List<BilibiliRechargeRecord> getRechargeRecordList(int page);

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

    /**
     * 获取充电留言列表
     *
     * @param page      页数
     * @param pageSize  分页大小[1,12]
     * @param startDate 起始日期
     * @param endDate   结束日期(2050-01-01)
     */
    void getRechargeRemarkList(int page, int pageSize, String startDate, String endDate);

    /**
     * (旧版)获取收到的电池列表
     *
     * @param page
     * @return
     */
    List<BilibiliRechargeRecord> getElectricList(int page);

    /**
     * (旧版)获取收到的电池列表
     *
     * @param page
     * @return
     */
    List<BilibiliRechargeRecord> getElectricList(int page, int pageSize);
}
