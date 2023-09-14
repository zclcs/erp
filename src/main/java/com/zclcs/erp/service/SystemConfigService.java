package com.zclcs.erp.service;

import com.mybatisflex.core.service.IService;
import com.zclcs.erp.api.bean.ao.SystemConfigAo;
import com.zclcs.erp.api.bean.entity.SystemConfig;
import com.zclcs.erp.api.bean.vo.SystemConfigVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;

import java.util.List;

/**
 * 系统配置 Service接口
 *
 * @author zclcs
 * @since 2023-09-14 11:36:13.675
 */
public interface SystemConfigService extends IService<SystemConfig> {

    /**
     * 查询（分页）
     *
     * @param basePageAo     {@link BasePageAo}
     * @param systemConfigVo {@link SystemConfigVo}
     * @return {@link SystemConfigVo}
     */
    BasePage<SystemConfigVo> findSystemConfigPage(BasePageAo basePageAo, SystemConfigVo systemConfigVo);

    /**
     * 查询（所有）
     *
     * @param systemConfigVo {@link SystemConfigVo}
     * @return {@link SystemConfigVo}
     */
    List<SystemConfigVo> findSystemConfigList(SystemConfigVo systemConfigVo);

    /**
     * 查询（单个）
     *
     * @param systemConfigVo {@link SystemConfigVo}
     * @return {@link SystemConfigVo}
     */
    SystemConfigVo findSystemConfig(SystemConfigVo systemConfigVo);

    /**
     * 统计
     *
     * @param systemConfigVo {@link SystemConfigVo}
     * @return 统计值
     */
    Long countSystemConfig(SystemConfigVo systemConfigVo);

    /**
     * 新增
     *
     * @param systemConfigAo {@link SystemConfigAo}
     * @return {@link SystemConfig}
     */
    SystemConfig createSystemConfig(SystemConfigAo systemConfigAo);

    /**
     * 修改
     *
     * @param systemConfigAo {@link SystemConfigAo}
     * @return {@link SystemConfig}
     */
    SystemConfig updateSystemConfig(SystemConfigAo systemConfigAo);

    /**
     * 新增或修改
     *
     * @param systemConfigAo {@link SystemConfigAo}
     * @return {@link SystemConfig}
     */
    SystemConfig createOrUpdateSystemConfig(SystemConfigAo systemConfigAo);

    /**
     * 批量新增
     *
     * @param systemConfigAos {@link SystemConfigAo}
     * @return {@link SystemConfig}
     */
    List<SystemConfig> createSystemConfigBatch(List<SystemConfigAo> systemConfigAos);

    /**
     * 批量修改
     *
     * @param systemConfigAos {@link SystemConfigAo}
     * @return {@link SystemConfig}
     */
    List<SystemConfig> updateSystemConfigBatch(List<SystemConfigAo> systemConfigAos);

    /**
     * 批量新增或修改
     * id为空则新增，不为空则修改
     * 可以自行重写
     *
     * @param systemConfigAos {@link SystemConfigAo}
     * @return {@link SystemConfig}
     */
    List<SystemConfig> createOrUpdateSystemConfigBatch(List<SystemConfigAo> systemConfigAos);

    /**
     * 删除
     *
     * @param ids 表id集合
     */
    void deleteSystemConfig(List<Long> ids);

}
