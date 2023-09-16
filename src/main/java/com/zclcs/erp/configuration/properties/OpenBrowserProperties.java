package com.zclcs.erp.configuration.properties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zclcs
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@ConfigurationProperties(prefix = "open-browser")
public class OpenBrowserProperties {

    /**
     * 是否自动打开
     */
    private Boolean open = true;

    /**
     * 浏览器url
     */
    private String openUrl;

    /**
     * 命令
     */
    private String cmd = "cmd   /c   start";

}
