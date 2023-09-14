package com.zclcs.erp.controller;

import com.zclcs.erp.api.bean.ao.SystemConfigAo;
import com.zclcs.erp.api.bean.entity.SystemConfig;
import com.zclcs.erp.api.bean.vo.SystemConfigVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.core.base.BaseRsp;
import com.zclcs.erp.core.bean.ValidatedList;
import com.zclcs.erp.core.constant.Strings;
import com.zclcs.erp.core.strategy.ValidGroups;
import com.zclcs.erp.service.SystemConfigService;
import com.zclcs.erp.utils.RspUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统配置
 *
 * @author zclcs
 * @since 2023-09-14 11:36:13.675
 */
@Slf4j
@RestController
@RequestMapping("/systemConfig")
@RequiredArgsConstructor
public class SystemConfigController {

    private final SystemConfigService systemConfigService;

    /**
     * 系统配置查询（分页）
     * 权限: systemConfig:page
     *
     * @see SystemConfigService#findSystemConfigPage(BasePageAo, SystemConfigVo)
     */
    @GetMapping
    public BaseRsp<BasePage<SystemConfigVo>> findSystemConfigPage(@Validated BasePageAo basePageAo, @Validated SystemConfigVo systemConfigVo) {
        BasePage<SystemConfigVo> page = this.systemConfigService.findSystemConfigPage(basePageAo, systemConfigVo);
        return RspUtil.data(page);
    }

    /**
     * 系统配置查询（集合）
     * 权限: systemConfig:list
     *
     * @see SystemConfigService#findSystemConfigList(SystemConfigVo)
     */
    @GetMapping("/list")
    public BaseRsp<List<SystemConfigVo>> findSystemConfigList(@Validated SystemConfigVo systemConfigVo) {
        List<SystemConfigVo> list = this.systemConfigService.findSystemConfigList(systemConfigVo);
        return RspUtil.data(list);
    }

    /**
     * 系统配置查询（单个）
     * 权限: systemConfig:one
     *
     * @see SystemConfigService#findSystemConfig(SystemConfigVo)
     */
    @GetMapping("/one")
    public BaseRsp<SystemConfigVo> findSystemConfig(@Validated SystemConfigVo systemConfigVo) {
        SystemConfigVo systemConfig = this.systemConfigService.findSystemConfig(systemConfigVo);
        return RspUtil.data(systemConfig);
    }

    /**
     * 新增系统配置
     * 权限: systemConfig:add
     *
     * @see SystemConfigService#createSystemConfig(SystemConfigAo)
     */
    @PostMapping
    public BaseRsp<SystemConfig> addSystemConfig(@Validated @RequestBody SystemConfigAo systemConfigAo) {
        return RspUtil.data(this.systemConfigService.createSystemConfig(systemConfigAo));
    }

    /**
     * 修改系统配置
     * 权限: systemConfig:update
     *
     * @see SystemConfigService#updateSystemConfig(SystemConfigAo)
     */
    @PutMapping
    public BaseRsp<SystemConfig> updateSystemConfig(@Validated({ValidGroups.Crud.Update.class}) @RequestBody SystemConfigAo systemConfigAo) {
        return RspUtil.data(this.systemConfigService.updateSystemConfig(systemConfigAo));
    }

    /**
     * 新增或修改系统配置
     * 权限: systemConfig:createOrUpdate
     *
     * @see SystemConfigService#createOrUpdateSystemConfig(SystemConfigAo)
     */
    @PostMapping("/createOrUpdate")
    public BaseRsp<SystemConfig> createOrUpdateSystemConfig(@RequestBody @Validated SystemConfigAo systemConfigAo) {
        return RspUtil.data(this.systemConfigService.createOrUpdateSystemConfig(systemConfigAo));
    }

    /**
     * 删除系统配置
     * 权限: systemConfig:delete
     *
     * @param systemConfigIds 系统配置id集合(,分隔)
     * @see SystemConfigService#deleteSystemConfig(List)
     */
    @DeleteMapping("/{systemConfigIds}")
    public BaseRsp<String> deleteSystemConfig(@NotBlank(message = "{required}") @PathVariable String systemConfigIds) {
        List<Long> ids = Arrays.stream(systemConfigIds.split(Strings.COMMA)).map(Long::valueOf).collect(Collectors.toList());
        this.systemConfigService.deleteSystemConfig(ids);
        return RspUtil.message("删除成功");
    }

    /**
     * 批量新增系统配置
     * 权限: systemConfig:add:batch
     *
     * @see SystemConfigService#createSystemConfigBatch(List)
     */
    @PostMapping("/batch")
    public BaseRsp<List<SystemConfig>> createSystemConfigBatch(@RequestBody @Validated ValidatedList<SystemConfigAo> systemConfigAos) {
        return RspUtil.data(this.systemConfigService.createSystemConfigBatch(systemConfigAos));
    }

    /**
     * 批量修改系统配置
     * 权限: systemConfig:update:batch
     *
     * @see SystemConfigService#createOrUpdateSystemConfigBatch(List)
     */
    @PutMapping("/batch")
    public BaseRsp<List<SystemConfig>> updateSystemConfigBatch(@RequestBody @Validated({ValidGroups.Crud.Update.class}) ValidatedList<SystemConfigAo> systemConfigAos) {
        return RspUtil.data(this.systemConfigService.updateSystemConfigBatch(systemConfigAos));
    }

    /**
     * 批量新增或修改系统配置
     * id为空则新增，不为空则修改
     * 权限: systemConfig:createOrUpdate:batch
     *
     * @see SystemConfigService#createOrUpdateSystemConfigBatch(List)
     */
    @PostMapping("/createOrUpdate/batch")
    public BaseRsp<List<SystemConfig>> createOrUpdateSystemConfigBatch(@RequestBody @Validated ValidatedList<SystemConfigAo> systemConfigAos) {
        return RspUtil.data(this.systemConfigService.createOrUpdateSystemConfigBatch(systemConfigAos));
    }

}