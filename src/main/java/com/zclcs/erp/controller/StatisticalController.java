package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.vo.MaxCountVo;
import com.zclcs.erp.api.bean.vo.ProfitCountVo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.service.StatisticalService;
import com.zclcs.erp.utils.RspUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 统计最大值
     *
     * @param type      1 统计最高单价产品 2 统计最高销量产品 3 统计最高销售额产品 4 统计最高销售额公司
     * @param startDate 开始日期 默认当月一号
     * @param endDate   结束日期 默认当天
     * @param limit     条数 默认10
     * @return {@link MaxCountVo}
     */
    @GetMapping("/maxCount")
    public BaseRsp<List<MaxCountVo>> maxCount(@NotBlank(message = "{required}") @RequestParam String type,
                                              @RequestParam(required = false) Long companyId,
                                              @RequestParam(required = false) String startDate,
                                              @RequestParam(required = false) String endDate,
                                              @RequestParam(required = false) Integer limit) {
        List<MaxCountVo> vos = this.statisticalService.maxCount(type, companyId, startDate, endDate, limit);
        return RspUtil.data(vos);
    }

    /**
     * @param type      1 年份 2 月份
     * @param startDate 开始日期 默认今年一号
     * @param endDate   结束日期 默认当天
     * @return {@link ProfitCountVo}
     */
    @GetMapping("/profitCount")
    public BaseRsp<List<ProfitCountVo>> profitCount(@NotBlank(message = "{required}") @RequestParam String type,
                                                    @RequestParam(required = false) String startDate,
                                                    @RequestParam(required = false) String endDate) {
        List<ProfitCountVo> profitCountVos = this.statisticalService.profitCount(type, startDate, endDate);
        return RspUtil.data(profitCountVos);
    }


}
