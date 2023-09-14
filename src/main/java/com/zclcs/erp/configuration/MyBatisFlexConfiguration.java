package com.zclcs.erp.configuration;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.dialect.DbType;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author zclcs
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class MyBatisFlexConfiguration implements MyBatisFlexCustomizer {

    private final ApplicationContext context;

    @Override
    public void customize(FlexGlobalConfig globalConfig) {

        FlexGlobalConfig config = FlexGlobalConfig.getDefaultConfig();
        config.setDbType(DbType.H2);

        //开启审计功能
        AuditManager.setAuditEnable(true);

        //设置 SQL 审计收集器
        AuditManager.setMessageCollector(auditMessage ->
                log.debug("Flex exec sql took {} ms >>> {}", auditMessage.getElapsedTime()
                        , auditMessage.getFullSql())
        );
    }

}
