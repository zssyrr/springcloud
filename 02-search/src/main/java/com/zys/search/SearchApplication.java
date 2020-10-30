package com.zys.search;

import com.zys.search.stream.StreamClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.search
 * @Description : TODO
 * @Create on : 2020/10/26 20:29
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableBinding(StreamClient.class)
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class,args);
    }
}
