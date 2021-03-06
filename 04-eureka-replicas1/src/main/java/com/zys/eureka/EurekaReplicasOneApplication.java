package com.zys.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.eureka
 * @Description : TODO
 * @Create on : 2020/10/26 21:47
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaReplicasOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaReplicasOneApplication.class,args);
    }
}
