package com.zclcs.erp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zclcs.erp.api.bean.ao.SystemConfigAo;
import com.zclcs.erp.api.bean.entity.SystemConfig;
import com.zclcs.erp.api.bean.vo.SystemConfigVo;
import com.zclcs.erp.core.base.BasePage;
import com.zclcs.erp.core.base.BasePageAo;
import com.zclcs.erp.mapper.SystemConfigMapper;
import com.zclcs.erp.service.SystemConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.zclcs.erp.api.bean.entity.table.SystemConfigTableDef.SYSTEM_CONFIG;

/**
 * 系统配置 Service实现
 *
 * @author zclcs
 * @since 2023-09-14 11:36:13.675
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Override
    public BasePage<SystemConfigVo> findSystemConfigPage(BasePageAo basePageAo, SystemConfigVo systemConfigVo) {
        QueryWrapper queryWrapper = getQueryWrapper(systemConfigVo);
        Page<SystemConfigVo> page = this.mapper.paginateAs(basePageAo.getPage(), basePageAo.getLimit(), queryWrapper, SystemConfigVo.class);
        return new BasePage<>(page);
    }

    @Override
    public List<SystemConfigVo> findSystemConfigList(SystemConfigVo systemConfigVo) {
        QueryWrapper queryWrapper = getQueryWrapper(systemConfigVo);
        return this.mapper.selectListByQueryAs(queryWrapper, SystemConfigVo.class);
    }

    @Override
    public SystemConfigVo findSystemConfig(SystemConfigVo systemConfigVo) {
        QueryWrapper queryWrapper = getQueryWrapper(systemConfigVo);
        return this.mapper.selectOneByQueryAs(queryWrapper, SystemConfigVo.class);
    }

    @Override
    public Long countSystemConfig(SystemConfigVo systemConfigVo) {
        QueryWrapper queryWrapper = getQueryWrapper(systemConfigVo);
        return this.mapper.selectCountByQuery(queryWrapper);
    }

    private QueryWrapper getQueryWrapper(SystemConfigVo systemConfigVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select(
                SYSTEM_CONFIG.ID,
                SYSTEM_CONFIG.SALESMAN,
                SYSTEM_CONFIG.PHONE,
                SYSTEM_CONFIG.TITLE
        );
        // TODO 设置公共查询条件
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemConfig createSystemConfig(SystemConfigAo systemConfigAo) {
        SystemConfig systemConfig = new SystemConfig();
        BeanUtil.copyProperties(systemConfigAo, systemConfig);
        this.save(systemConfig);
        return systemConfig;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemConfig updateSystemConfig(SystemConfigAo systemConfigAo) {
        SystemConfig systemConfig = new SystemConfig();
        BeanUtil.copyProperties(systemConfigAo, systemConfig);
        this.updateById(systemConfig);
        return systemConfig;
    }

    @Override
    public SystemConfig createOrUpdateSystemConfig(SystemConfigAo systemConfigAo) {
        SystemConfig systemConfig = new SystemConfig();
        BeanUtil.copyProperties(systemConfigAo, systemConfig);
        this.saveOrUpdate(systemConfig);
        return systemConfig;
    }

    @Override
    public List<SystemConfig> createSystemConfigBatch(List<SystemConfigAo> systemConfigAos) {
        List<SystemConfig> systemConfigList = new ArrayList<>();
        for (SystemConfigAo systemConfigAo : systemConfigAos) {
            SystemConfig systemConfig = new SystemConfig();
            BeanUtil.copyProperties(systemConfigAo, systemConfig);
            systemConfigList.add(systemConfig);
        }
        saveBatch(systemConfigList);
        return systemConfigList;
    }

    @Override
    public List<SystemConfig> updateSystemConfigBatch(List<SystemConfigAo> systemConfigAos) {
        List<SystemConfig> systemConfigList = new ArrayList<>();
        for (SystemConfigAo systemConfigAo : systemConfigAos) {
            SystemConfig systemConfig = new SystemConfig();
            BeanUtil.copyProperties(systemConfigAo, systemConfig);
            systemConfigList.add(systemConfig);
        }
        updateBatch(systemConfigList);
        return systemConfigList;
    }

    @Override
    public List<SystemConfig> createOrUpdateSystemConfigBatch(List<SystemConfigAo> systemConfigAos) {
        List<SystemConfig> systemConfigList = new ArrayList<>();
        for (SystemConfigAo systemConfigAo : systemConfigAos) {
            SystemConfig systemConfig = new SystemConfig();
            BeanUtil.copyProperties(systemConfigAo, systemConfig);
            systemConfigList.add(systemConfig);
        }
        saveOrUpdateBatch(systemConfigList);
        return systemConfigList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSystemConfig(List<Long> ids) {
        this.removeByIds(ids);
    }

}
