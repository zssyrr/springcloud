package com.zys.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.sidecar
 * @Description : TODO
 * @Create on : 2020/10/29 20:23
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableSidecar
public class SidecarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class,args);
    }
}
