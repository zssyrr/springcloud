package com.zys.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.search
 * @Description : TODO
 * @Create on : 2020/10/27 15:20
 **/
@SpringBootApplication
@EnableEurekaClient
public class SearchApplicationReplicas {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplicationReplicas.class,args);
    }
}
