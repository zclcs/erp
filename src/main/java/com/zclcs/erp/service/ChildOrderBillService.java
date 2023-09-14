package com.zclcs.erp.service;

import com.mybatisflex.core.service.IService;
import com.zclcs.erp.api.bean.ao.ChildOrderBillAo;
import com.zclcs.erp.api.bean.entity.ChildOrderBill;
import com.zclcs.erp.api.bean.vo.ChildOrderBillVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;

import java.util.List;

/**
 * 对账单和子订单关联 Service接口
 *
 * @author zclcs
 * @since 2023-09-14 11:36:41.197
 */
public interface ChildOrderBillService extends IService<ChildOrderBill> {

    /**
     * 查询（分页）
     *
     * @param basePageAo       {@link BasePageAo}
     * @param childOrderBillVo {@link ChildOrderBillVo}
     * @return {@link ChildOrderBillVo}
     */
    BasePage<ChildOrderBillVo> findChildOrderBillPage(BasePageAo basePageAo, ChildOrderBillVo childOrderBillVo);

    /**
     * 查询（所有）
     *
     * @param childOrderBillVo {@link ChildOrderBillVo}
     * @return {@link ChildOrderBillVo}
     */
    List<ChildOrderBillVo> findChildOrderBillList(ChildOrderBillVo childOrderBillVo);

    /**
     * 查询（单个）
     *
     * @param childOrderBillVo {@link ChildOrderBillVo}
     * @return {@link ChildOrderBillVo}
     */
    ChildOrderBillVo findChildOrderBill(ChildOrderBillVo childOrderBillVo);

    /**
     * 统计
     *
     * @param childOrderBillVo {@link ChildOrderBillVo}
     * @return 统计值
     */
    Long countChildOrderBill(ChildOrderBillVo childOrderBillVo);

    /**
     * 新增
     *
     * @param childOrderBillAo {@link ChildOrderBillAo}
     * @return {@link ChildOrderBill}
     */
    ChildOrderBill createChildOrderBill(ChildOrderBillAo childOrderBillAo);

    /**
     * 修改
     *
     * @param childOrderBillAo {@link ChildOrderBillAo}
     * @return {@link ChildOrderBill}
     */
    ChildOrderBill updateChildOrderBill(ChildOrderBillAo childOrderBillAo);

    /**
     * 新增或修改
     *
     * @param childOrderBillAo {@link ChildOrderBillAo}
     * @return {@link ChildOrderBill}
     */
    ChildOrderBill createOrUpdateChildOrderBill(ChildOrderBillAo childOrderBillAo);

    /**
     * 批量新增
     *
     * @param childOrderBillAos {@link ChildOrderBillAo}
     * @return {@link ChildOrderBill}
     */
    List<ChildOrderBill> createChildOrderBillBatch(List<ChildOrderBillAo> childOrderBillAos);

    /**
     * 批量修改
     *
     * @param childOrderBillAos {@link ChildOrderBillAo}
     * @return {@link ChildOrderBill}
     */
    List<ChildOrderBill> updateChildOrderBillBatch(List<ChildOrderBillAo> childOrderBillAos);

    /**
     * 批量新增或修改
     * id为空则新增，不为空则修改
     * 可以自行重写
     *
     * @param childOrderBillAos {@link ChildOrderBillAo}
     * @return {@link ChildOrderBill}
     */
    List<ChildOrderBill> createOrUpdateChildOrderBillBatch(List<ChildOrderBillAo> childOrderBillAos);

    /**
     * 删除
     *
     * @param ids 表id集合
     */
    void deleteChildOrderBill(List<Long> ids);

}
