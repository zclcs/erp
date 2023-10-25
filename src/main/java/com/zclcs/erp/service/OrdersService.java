package com.zclcs.erp.service;

import com.mybatisflex.core.service.IService;
import com.zclcs.erp.api.bean.ao.OrdersAo;
import com.zclcs.erp.api.bean.entity.Orders;
import com.zclcs.erp.api.bean.vo.OrdersVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;

import java.util.List;

/**
 * 订单 Service接口
 *
 * @author zclcs
 * @since 2023-09-14 11:36:32.023
 */
public interface OrdersService extends IService<Orders> {

    /**
     * 查询（分页）
     *
     * @param basePageAo {@link BasePageAo}
     * @param ordersVo   {@link OrdersVo}
     * @return {@link OrdersVo}
     */
    BasePage<OrdersVo> findOrdersPage(BasePageAo basePageAo, OrdersVo ordersVo);

    /**
     * 查询（所有）
     *
     * @param ordersVo {@link OrdersVo}
     * @return {@link OrdersVo}
     */
    List<OrdersVo> findOrdersList(OrdersVo ordersVo);

    /**
     * 查询（单个）
     *
     * @param ordersVo {@link OrdersVo}
     * @return {@link OrdersVo}
     */
    OrdersVo findOrders(OrdersVo ordersVo);

    /**
     * 统计
     *
     * @param ordersVo {@link OrdersVo}
     * @return 统计值
     */
    Long countOrders(OrdersVo ordersVo);

    /**
     * 新增
     *
     * @param ordersAo {@link OrdersAo}
     * @return {@link Orders}
     */
    Orders createOrders(OrdersAo ordersAo);

    /**
     * 修改
     *
     * @param ordersAo {@link OrdersAo}
     * @return {@link Orders}
     */
    Orders updateOrders(OrdersAo ordersAo);

    /**
     * 新增或修改
     *
     * @param ordersAo {@link OrdersAo}
     * @return {@link Orders}
     */
    Orders createOrUpdateOrders(OrdersAo ordersAo);

    /**
     * 批量新增
     *
     * @param ordersAos {@link OrdersAo}
     * @return {@link Orders}
     */
    List<Orders> createOrdersBatch(List<OrdersAo> ordersAos);

    /**
     * 批量修改
     *
     * @param ordersAos {@link OrdersAo}
     * @return {@link Orders}
     */
    List<Orders> updateOrdersBatch(List<OrdersAo> ordersAos);

    /**
     * 批量新增或修改
     * id为空则新增，不为空则修改
     * 可以自行重写
     *
     * @param ordersAos {@link OrdersAo}
     * @return {@link Orders}
     */
    List<Orders> createOrUpdateOrdersBatch(List<OrdersAo> ordersAos);

    /**
     * 删除
     *
     * @param ids 表id集合
     */
    void deleteOrders(List<Long> ids);

    /**
     * 生成送货单
     *
     * @param id   id
     * @param type 1 doc 2 pdf
     */
    void exportOrders(Long id, Integer type);
}
