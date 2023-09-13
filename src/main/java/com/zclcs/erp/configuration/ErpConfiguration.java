package com.zclcs.erp.configuration;

import com.zclcs.erp.utils.ClazzUtil;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

/**
 * ip2region 自动化配置
 *
 * @author zclcs
 */
@Configuration
@ImportRuntimeHints(ErpRuntimeHintsRegistrar.class)
//@RegisterReflectionForBinding
public class ErpConfiguration {

}
