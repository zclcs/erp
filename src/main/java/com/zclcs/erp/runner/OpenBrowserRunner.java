package com.zclcs.erp.runner;

import com.zclcs.erp.configuration.properties.OpenBrowserProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zclcs
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OpenBrowserRunner implements CommandLineRunner {

    private final OpenBrowserProperties openBrowserProperties;

    @Override
    public void run(String... args) {
        if (openBrowserProperties.getOpen()) {
            String runCmd = openBrowserProperties.getCmd() + " " + openBrowserProperties.getOpenUrl();
            System.out.println("运行的命令: " + runCmd);
            Runtime run = Runtime.getRuntime();
            try {
                run.exec(runCmd);
                log.info("启动浏览器打开项目成功");
            } catch (Exception e) {
                log.warn("启动浏览器打开项目成功");
            }
        }
    }
}
