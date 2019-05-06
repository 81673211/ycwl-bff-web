package com.fred.ycwl.bff.web;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/30 15:07
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BFFWebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BFFWebApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
