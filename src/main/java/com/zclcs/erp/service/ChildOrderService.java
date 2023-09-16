package com.zclcs.erp.service;

import com.mybatisflex.core.service.IService;
import com.zclcs.erp.api.bean.ao.ChildOrderAo;
import com.zclcs.erp.api.bean.entity.ChildOrder;
import com.zclcs.erp.api.bean.vo.ChildOrderVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;

import java.util.List;

/**
 * 子订单 Service接口
 *
 * @author zclcs
 * @since 2023-09-14 11:36:04.813
 */
public interface ChildOrderService extends IService<ChildOrder> {

    /**
     * 查询（分页）
     *
     * @param basePageAo   {@link BasePageAo}
     * @param childOrderVo {@link ChildOrderVo}
     * @return {@link ChildOrderVo}
     */
    BasePage<ChildOrderVo> findChildOrderPage(BasePageAo basePageAo, ChildOrderVo childOrderVo);

    /**
     * 查询（所有）
     *
     * @param childOrderVo {@link ChildOrderVo}
     * @return {@link ChildOrderVo}
     */
    List<ChildOrderVo> findChildOrderList(ChildOrderVo childOrderVo);

    /**
     * 查询（单个）
     *
     * @param childOrderVo {@link ChildOrderVo}
     * @return {@link ChildOrderVo}
     */
    ChildOrderVo findChildOrder(ChildOrderVo childOrderVo);

    /**
     * 根据对账单id查询子订单
     *
     * @param billId 对账单id
     * @return 子订单
     */
    BasePage<ChildOrderVo> findChildOrderListByBillIdPage(BasePageAo basePageAo, Long billId);

    /**
     * 根据对账单id查询子订单
     *
     * @param billId 对账单id
     * @return 子订单
     */
    List<ChildOrderVo> findChildOrderListByBillIdList(Long billId);

    /**
     * 统计
     *
     * @param childOrderVo {@link ChildOrderVo}
     * @return 统计值
     */
    Long countChildOrder(ChildOrderVo childOrderVo);

    /**
     * 新增
     *
     * @param childOrderAo {@link ChildOrderAo}
     * @return {@link ChildOrder}
     */
    ChildOrder createChildOrder(ChildOrderAo childOrderAo);

    /**
     * 修改
     *
     * @param childOrderAo {@link ChildOrderAo}
     * @return {@link ChildOrder}
     */
    ChildOrder updateChildOrder(ChildOrderAo childOrderAo);

    /**
     * 新增或修改
     *
     * @param childOrderAo {@link ChildOrderAo}
     * @return {@link ChildOrder}
     */
    ChildOrder createOrUpdateChildOrder(ChildOrderAo childOrderAo);

    /**
     * 批量新增
     *
     * @param childOrderAos {@link ChildOrderAo}
     * @return {@link ChildOrder}
     */
    List<ChildOrder> createChildOrderBatch(List<ChildOrderAo> childOrderAos);

    /**
     * 批量修改
     *
     * @param childOrderAos {@link ChildOrderAo}
     * @return {@link ChildOrder}
     */
    List<ChildOrder> updateChildOrderBatch(List<ChildOrderAo> childOrderAos);

    /**
     * 批量新增或修改
     * id为空则新增，不为空则修改
     * 可以自行重写
     *
     * @param childOrderAos {@link ChildOrderAo}
     * @return {@link ChildOrder}
     */
    List<ChildOrder> createOrUpdateChildOrderBatch(List<ChildOrderAo> childOrderAos);

    /**
     * 删除
     *
     * @param ids 表id集合
     */
    void deleteChildOrder(List<Long> ids);

}
