package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.ChildOrderAo;
import com.zclcs.erp.api.bean.entity.ChildOrder;
import com.zclcs.erp.api.bean.vo.ChildOrderVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.mapper.ChildOrderMapper;
import com.zclcs.erp.service.ChildOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.ChildOrderTableDef.CHILD_ORDER;

/**
 * 子订单 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:04.813
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChildOrderServiceImpl extends ServiceImpl<ChildOrderMapper, ChildOrder> implements ChildOrderService {

    @Override
    public BasePage<ChildOrderVo> findChildOrderPage(BasePageAo basePageAo, ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderVo);
        Page<ChildOrderVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, ChildOrderVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<ChildOrderVo> findChildOrderList(ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderVo);
        return this.mapper.selectListByQueryAs(queryWrapper, ChildOrderVo.class);
    }

    @Override
    public ChildOrderVo findChildOrder(ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, ChildOrderVo.class);
    }

    @Override
    public Long countChildOrder(ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(ChildOrderVo childOrderVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                CHILD_ORDER.ID,
                CHILD_ORDER.ORDERS_ID,
                CHILD_ORDER.PRODUCT_ID,
                CHILD_ORDER.PRODUCT_NAME,
                CHILD_ORDER.SPECIFICATION,
                CHILD_ORDER.NUMBER,
                CHILD_ORDER.WEIGHT,
                CHILD_ORDER.PRICE,
                CHILD_ORDER.AMOUNT,
                CHILD_ORDER.REMARK,
                CHILD_ORDER.CHILD_ORDER_STATUS
        ).where(CHILD_ORDER.ORDERS_ID.eq(childOrderVo.getOrdersId()))
        ;
        // TODO 设置公共查询条件
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChildOrder createChildOrder(ChildOrderAo childOrderAo) {
        ChildOrder childOrder = new ChildOrder();
        BeanUtil.copyProperties(childOrderAo, childOrder);
        this.save(childOrder);
        return childOrder;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChildOrder updateChildOrder(ChildOrderAo childOrderAo) {
        ChildOrder childOrder = new ChildOrder();
        BeanUtil.copyProperties(childOrderAo, childOrder);
        this.updateById(childOrder);
        return childOrder;
    }

    @Override
    public ChildOrder createOrUpdateChildOrder(ChildOrderAo childOrderAo) {
        ChildOrder childOrder = new ChildOrder();
        BeanUtil.copyProperties(childOrderAo, childOrder);
        this.saveOrUpdate(childOrder);
        return childOrder;
    }

    @Override
    public List<ChildOrder> createChildOrderBatch(List<ChildOrderAo> childOrderAos) {
        List<ChildOrder> childOrderList = new ArrayList<>();
        for (ChildOrderAo childOrderAo : childOrderAos) {
            ChildOrder childOrder = new ChildOrder();
            BeanUtil.copyProperties(childOrderAo, childOrder);
            childOrderList.add(childOrder);
        }
        saveBatch(childOrderList);
        return childOrderList;
    }

    @Override
    public List<ChildOrder> updateChildOrderBatch(List<ChildOrderAo> childOrderAos) {
        List<ChildOrder> childOrderList = new ArrayList<>();
        for (ChildOrderAo childOrderAo : childOrderAos) {
            ChildOrder childOrder = new ChildOrder();
            BeanUtil.copyProperties(childOrderAo, childOrder);
            childOrderList.add(childOrder);
        }
        updateBatch(childOrderList);
        return childOrderList;
    }

    @Override
    public List<ChildOrder> createOrUpdateChildOrderBatch(List<ChildOrderAo> childOrderAos) {
        List<ChildOrder> childOrderList = new ArrayList<>();
        for (ChildOrderAo childOrderAo : childOrderAos) {
            ChildOrder childOrder = new ChildOrder();
            BeanUtil.copyProperties(childOrderAo, childOrder);
            childOrderList.add(childOrder);
        }
        saveOrUpdateBatch(childOrderList);
        return childOrderList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteChildOrder(List<Long> ids) {
        this.removeByIds(ids);
    }

}
