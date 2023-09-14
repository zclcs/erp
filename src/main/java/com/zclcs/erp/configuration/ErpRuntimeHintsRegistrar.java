package com.zclcs.erp.configuration;

import com.zclcs.erp.utils.ClazzUtil;
import lombok.SneakyThrows;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import java.util.Set;

/**
 * mica-ip2region native 支持
 *
 * @author zclcs
 */
public class ErpRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

    @SneakyThrows
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        Set<Class<?>> classes = ClazzUtil.getClasses("com.zclcs.erp.api");
        classes.addAll(ClazzUtil.getClasses("com.zclcs.erp.core.base"));
        for (Class<?> aClass : classes) {
            hints.reflection().registerType(aClass, MemberCategory.values());
        }
        hints.resources()
                .registerPattern("mapper/*")
        ;
    }

}
