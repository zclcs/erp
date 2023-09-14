package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.BillAo;
import com.zclcs.erp.api.bean.entity.Bill;
import com.zclcs.erp.api.bean.vo.BillVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.mapper.BillMapper;
import com.zclcs.erp.service.BillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.BillTableDef.BILL;

/**
 * 对账单 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:09.432
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {

    @Override
    public BasePage<BillVo> findBillPage(BasePageAo basePageAo, BillVo billVo) {
        QueryWrapper queryWrapper = getQueryWrapper(billVo);
        Page<BillVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, BillVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<BillVo> findBillList(BillVo billVo) {
        QueryWrapper queryWrapper = getQueryWrapper(billVo);
        return this.mapper.selectListByQueryAs(queryWrapper, BillVo.class);
    }

    @Override
    public BillVo findBill(BillVo billVo) {
        QueryWrapper queryWrapper = getQueryWrapper(billVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, BillVo.class);
    }

    @Override
    public Long countBill(BillVo billVo) {
        QueryWrapper queryWrapper = getQueryWrapper(billVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(BillVo billVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                BILL.ID,
                BILL.COMPANY_ID,
                BILL.COMPANY_NAME,
                BILL.DELIVERY_DATE,
                BILL.NAME,
                BILL.TOTAL_AMOUNT
        );
        // TODO 设置公共查询条件
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Bill createBill(BillAo billAo) {
        Bill bill = new Bill();
        BeanUtil.copyProperties(billAo, bill);
        this.save(bill);
        return bill;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Bill updateBill(BillAo billAo) {
        Bill bill = new Bill();
        BeanUtil.copyProperties(billAo, bill);
        this.updateById(bill);
        return bill;
    }

    @Override
    public Bill createOrUpdateBill(BillAo billAo) {
        Bill bill = new Bill();
        BeanUtil.copyProperties(billAo, bill);
        this.saveOrUpdate(bill);
        return bill;
    }

    @Override
    public List<Bill> createBillBatch(List<BillAo> billAos) {
        List<Bill> billList = new ArrayList<>();
        for (BillAo billAo : billAos) {
            Bill bill = new Bill();
            BeanUtil.copyProperties(billAo, bill);
            billList.add(bill);
        }
        saveBatch(billList);
        return billList;
    }

    @Override
    public List<Bill> updateBillBatch(List<BillAo> billAos) {
        List<Bill> billList = new ArrayList<>();
        for (BillAo billAo : billAos) {
            Bill bill = new Bill();
            BeanUtil.copyProperties(billAo, bill);
            billList.add(bill);
        }
        updateBatch(billList);
        return billList;
    }

    @Override
    public List<Bill> createOrUpdateBillBatch(List<BillAo> billAos) {
        List<Bill> billList = new ArrayList<>();
        for (BillAo billAo : billAos) {
            Bill bill = new Bill();
            BeanUtil.copyProperties(billAo, bill);
            billList.add(bill);
        }
        saveOrUpdateBatch(billList);
        return billList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBill(List<Long> ids) {
        this.removeByIds(ids);
    }

}
