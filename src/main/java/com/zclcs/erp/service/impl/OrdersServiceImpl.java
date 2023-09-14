package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.OrdersAo;
import com.zclcs.erp.api.bean.entity.Orders;
import com.zclcs.erp.api.bean.vo.OrdersVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.mapper.OrdersMapper;
import com.zclcs.erp.service.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.OrdersTableDef.ORDERS;

/**
 * 订单 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:32.023
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Override
    public BasePage<OrdersVo> findOrdersPage(BasePageAo basePageAo, OrdersVo ordersVo) {
        QueryWrapper queryWrapper = getQueryWrapper(ordersVo);
        Page<OrdersVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, OrdersVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<OrdersVo> findOrdersList(OrdersVo ordersVo) {
        QueryWrapper queryWrapper = getQueryWrapper(ordersVo);
        return this.mapper.selectListByQueryAs(queryWrapper, OrdersVo.class);
    }

    @Override
    public OrdersVo findOrders(OrdersVo ordersVo) {
        QueryWrapper queryWrapper = getQueryWrapper(ordersVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, OrdersVo.class);
    }

    @Override
    public Long countOrders(OrdersVo ordersVo) {
        QueryWrapper queryWrapper = getQueryWrapper(ordersVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(OrdersVo ordersVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                ORDERS.ID,
                ORDERS.COMPANY_ID,
                ORDERS.COMPANY_NAME,
                ORDERS.DELIVERY_DATE,
                ORDERS.ORDERS_STATUS
        );
        // TODO 设置公共查询条件
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Orders createOrders(OrdersAo ordersAo) {
        Orders orders = new Orders();
        BeanUtil.copyProperties(ordersAo, orders);
        this.save(orders);
        return orders;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Orders updateOrders(OrdersAo ordersAo) {
        Orders orders = new Orders();
        BeanUtil.copyProperties(ordersAo, orders);
        this.updateById(orders);
        return orders;
    }

    @Override
    public Orders createOrUpdateOrders(OrdersAo ordersAo) {
        Orders orders = new Orders();
        BeanUtil.copyProperties(ordersAo, orders);
        this.saveOrUpdate(orders);
        return orders;
    }

    @Override
    public List<Orders> createOrdersBatch(List<OrdersAo> ordersAos) {
        List<Orders> ordersList = new ArrayList<>();
        for (OrdersAo ordersAo : ordersAos) {
            Orders orders = new Orders();
            BeanUtil.copyProperties(ordersAo, orders);
            ordersList.add(orders);
        }
        saveBatch(ordersList);
        return ordersList;
    }

    @Override
    public List<Orders> updateOrdersBatch(List<OrdersAo> ordersAos) {
        List<Orders> ordersList = new ArrayList<>();
        for (OrdersAo ordersAo : ordersAos) {
            Orders orders = new Orders();
            BeanUtil.copyProperties(ordersAo, orders);
            ordersList.add(orders);
        }
        updateBatch(ordersList);
        return ordersList;
    }

    @Override
    public List<Orders> createOrUpdateOrdersBatch(List<OrdersAo> ordersAos) {
        List<Orders> ordersList = new ArrayList<>();
        for (OrdersAo ordersAo : ordersAos) {
            Orders orders = new Orders();
            BeanUtil.copyProperties(ordersAo, orders);
            ordersList.add(orders);
        }
        saveOrUpdateBatch(ordersList);
        return ordersList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrders(List<Long> ids) {
        this.removeByIds(ids);
    }

}
