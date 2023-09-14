package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.ChildOrderBillAo;
import com.zclcs.erp.api.bean.entity.ChildOrderBill;
import com.zclcs.erp.api.bean.vo.ChildOrderBillVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.mapper.ChildOrderBillMapper;
import com.zclcs.erp.service.ChildOrderBillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.ChildOrderBillTableDef.CHILD_ORDER_BILL;

/**
 * 对账单和子订单关联 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:41.197
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChildOrderBillServiceImpl extends ServiceImpl<ChildOrderBillMapper, ChildOrderBill> implements ChildOrderBillService {

    @Override
    public BasePage<ChildOrderBillVo> findChildOrderBillPage(BasePageAo basePageAo, ChildOrderBillVo childOrderBillVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderBillVo);
        Page<ChildOrderBillVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, ChildOrderBillVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<ChildOrderBillVo> findChildOrderBillList(ChildOrderBillVo childOrderBillVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderBillVo);
        return this.mapper.selectListByQueryAs(queryWrapper, ChildOrderBillVo.class);
    }

    @Override
    public ChildOrderBillVo findChildOrderBill(ChildOrderBillVo childOrderBillVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderBillVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, ChildOrderBillVo.class);
    }

    @Override
    public Long countChildOrderBill(ChildOrderBillVo childOrderBillVo) {
        QueryWrapper queryWrapper = getQueryWrapper(childOrderBillVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(ChildOrderBillVo childOrderBillVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                CHILD_ORDER_BILL.ID,
                CHILD_ORDER_BILL.CHILD_ORDER_ID,
                CHILD_ORDER_BILL.BILL_ID
        );
        // TODO 设置公共查询条件
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChildOrderBill createChildOrderBill(ChildOrderBillAo childOrderBillAo) {
        ChildOrderBill childOrderBill = new ChildOrderBill();
        BeanUtil.copyProperties(childOrderBillAo, childOrderBill);
        this.save(childOrderBill);
        return childOrderBill;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChildOrderBill updateChildOrderBill(ChildOrderBillAo childOrderBillAo) {
        ChildOrderBill childOrderBill = new ChildOrderBill();
        BeanUtil.copyProperties(childOrderBillAo, childOrderBill);
        this.updateById(childOrderBill);
        return childOrderBill;
    }

    @Override
    public ChildOrderBill createOrUpdateChildOrderBill(ChildOrderBillAo childOrderBillAo) {
        ChildOrderBill childOrderBill = new ChildOrderBill();
        BeanUtil.copyProperties(childOrderBillAo, childOrderBill);
        this.saveOrUpdate(childOrderBill);
        return childOrderBill;
    }

    @Override
    public List<ChildOrderBill> createChildOrderBillBatch(List<ChildOrderBillAo> childOrderBillAos) {
        List<ChildOrderBill> childOrderBillList = new ArrayList<>();
        for (ChildOrderBillAo childOrderBillAo : childOrderBillAos) {
            ChildOrderBill childOrderBill = new ChildOrderBill();
            BeanUtil.copyProperties(childOrderBillAo, childOrderBill);
            childOrderBillList.add(childOrderBill);
        }
        saveBatch(childOrderBillList);
        return childOrderBillList;
    }

    @Override
    public List<ChildOrderBill> updateChildOrderBillBatch(List<ChildOrderBillAo> childOrderBillAos) {
        List<ChildOrderBill> childOrderBillList = new ArrayList<>();
        for (ChildOrderBillAo childOrderBillAo : childOrderBillAos) {
            ChildOrderBill childOrderBill = new ChildOrderBill();
            BeanUtil.copyProperties(childOrderBillAo, childOrderBill);
            childOrderBillList.add(childOrderBill);
        }
        updateBatch(childOrderBillList);
        return childOrderBillList;
    }

    @Override
    public List<ChildOrderBill> createOrUpdateChildOrderBillBatch(List<ChildOrderBillAo> childOrderBillAos) {
        List<ChildOrderBill> childOrderBillList = new ArrayList<>();
        for (ChildOrderBillAo childOrderBillAo : childOrderBillAos) {
            ChildOrderBill childOrderBill = new ChildOrderBill();
            BeanUtil.copyProperties(childOrderBillAo, childOrderBill);
            childOrderBillList.add(childOrderBill);
        }
        saveOrUpdateBatch(childOrderBillList);
        return childOrderBillList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteChildOrderBill(List<Long> ids) {
        this.removeByIds(ids);
    }

}
