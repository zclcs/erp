package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.vo.MaxAmountByCompanyVo;
import com.zclcs.erp.api.bean.vo.MaxAmountByProductVo;
import com.zclcs.erp.api.bean.vo.MaxPriceByProductVo;
import com.zclcs.erp.api.bean.vo.MaxWeightByProductVo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.service.StatisticalService;
import com.zclcs.erp.utils.RspUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zclcs
 */
@Slf4j
@RestController
@RequestMapping("/statistical")
@RequiredArgsConstructor
public class StatisticalController {

    private final StatisticalService statisticalService;

    /**
     * 统计最高单价产品
     *
     * @see StatisticalService#maxPriceByProduct(Integer)
     */
    @GetMapping("/maxPriceByProduct")
    public BaseRsp<List<MaxPriceByProductVo>> maxPriceByProduct(Integer limit) {
        List<MaxPriceByProductVo> vos = this.statisticalService.maxPriceByProduct(limit);
        return RspUtil.data(vos);
    }

    /**
     * 统计最高销量产品
     *
     * @see StatisticalService#maxWeightByProduct(Integer)
     */
    @GetMapping("/maxWeightByProduct")
    public BaseRsp<List<MaxWeightByProductVo>> maxWeightByProduct(Integer limit) {
        List<MaxWeightByProductVo> vos = this.statisticalService.maxWeightByProduct(limit);
        return RspUtil.data(vos);
    }

    /**
     * 统计最高销售额产品
     *
     * @see StatisticalService#maxAmountByProduct(Integer)
     */
    @GetMapping("/maxAmountByProduct")
    public BaseRsp<List<MaxAmountByProductVo>> maxAmountByProduct(Integer limit) {
        List<MaxAmountByProductVo> vos = this.statisticalService.maxAmountByProduct(limit);
        return RspUtil.data(vos);
    }

    /**
     * 统计最高销售额公司
     *
     * @see StatisticalService#maxAmountByCompany(Integer)
     */
    @GetMapping("/maxAmountByCompany")
    public BaseRsp<List<MaxAmountByCompanyVo>> maxAmountByCompany(Integer limit) {
        List<MaxAmountByCompanyVo> vos = this.statisticalService.maxAmountByCompany(limit);
        return RspUtil.data(vos);
    }


}
