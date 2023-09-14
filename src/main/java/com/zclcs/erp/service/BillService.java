package com.zclcs.erp.service;

import com.mybatisflex.core.service.IService;
import com.zclcs.erp.api.bean.ao.BillAo;
import com.zclcs.erp.api.bean.entity.Bill;
import com.zclcs.erp.api.bean.vo.BillVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;

import java.util.List;

/**
 * 对账单 Service接口
 *
 * @author zclcs
 * @since 2023-09-14 11:36:09.432
 */
public interface BillService extends IService<Bill> {

    /**
     * 查询（分页）
     *
     * @param basePageAo {@link BasePageAo}
     * @param billVo     {@link BillVo}
     * @return {@link BillVo}
     */
    BasePage<BillVo> findBillPage(BasePageAo basePageAo, BillVo billVo);

    /**
     * 查询（所有）
     *
     * @param billVo {@link BillVo}
     * @return {@link BillVo}
     */
    List<BillVo> findBillList(BillVo billVo);

    /**
     * 查询（单个）
     *
     * @param billVo {@link BillVo}
     * @return {@link BillVo}
     */
    BillVo findBill(BillVo billVo);

    /**
     * 统计
     *
     * @param billVo {@link BillVo}
     * @return 统计值
     */
    Long countBill(BillVo billVo);

    /**
     * 新增
     *
     * @param billAo {@link BillAo}
     * @return {@link Bill}
     */
    Bill createBill(BillAo billAo);

    /**
     * 修改
     *
     * @param billAo {@link BillAo}
     * @return {@link Bill}
     */
    Bill updateBill(BillAo billAo);

    /**
     * 新增或修改
     *
     * @param billAo {@link BillAo}
     * @return {@link Bill}
     */
    Bill createOrUpdateBill(BillAo billAo);

    /**
     * 批量新增
     *
     * @param billAos {@link BillAo}
     * @return {@link Bill}
     */
    List<Bill> createBillBatch(List<BillAo> billAos);

    /**
     * 批量修改
     *
     * @param billAos {@link BillAo}
     * @return {@link Bill}
     */
    List<Bill> updateBillBatch(List<BillAo> billAos);

    /**
     * 批量新增或修改
     * id为空则新增，不为空则修改
     * 可以自行重写
     *
     * @param billAos {@link BillAo}
     * @return {@link Bill}
     */
    List<Bill> createOrUpdateBillBatch(List<BillAo> billAos);

    /**
     * 删除
     *
     * @param ids 表id集合
     */
    void deleteBill(List<Long> ids);

}
