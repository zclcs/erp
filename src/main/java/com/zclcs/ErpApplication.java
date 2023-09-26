package com.zclcs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zclcs
 */
@SpringBootApplication(proxyBeanMethods = false)
@MapperScan(value = "com.zclcs.erp.mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class ErpApplication {

    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("javax.xml.accessExternalDTD", "all");
        SpringApplication.run(ErpApplication.class, args);
    }

}
