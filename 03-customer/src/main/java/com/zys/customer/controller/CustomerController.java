package com.zys.customer.controller;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zys.customer.client.SearchClient;
import com.zys.customer.entity.Customer;
import com.zys.customer.stream.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.customer.controller
 * @Description : TODO
 * @Create on : 2020/10/26 21:14
 **/
@RestController
@RequestMapping("/sys/customer")
public class CustomerController {
    @Resource
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private SearchClient searchClient;

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMsg")
    public void sendMsg(){
        streamClient.output().send(MessageBuilder.withPayload("hello world").build());
    }

    @GetMapping("/table")
    public String table(){
        /*//1.通过EurekaClient获取SEARCH的信息
        InstanceInfo search = eurekaClient.getNextServerFromEureka("SEARCH", false);
        //2.通过InstanceInfo对象获取访问路径
        String url = search.getHomePageUrl();

        //3.使用restTemplate访问
        String result = restTemplate.getForObject(url + "/search/customer/table", String.class);
        return result;
         */

        /*String result = restTemplate.getForObject("http://SEARCH/search/customer/table", String.class);
        return result;*/

        String result = searchClient.table();
        return result;
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        Customer result = searchClient.save(customer);
        return result;
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getByIdFallback",
            commandProperties = {
            //开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"),
                    //10s内总请求数达到10个，才计算断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
                    //open会持续30s
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "30000"),
                    //10个请求失败率达到10%就open断路器
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "10")
            })
    public Customer getById(@PathVariable Integer id) {
        if(id==0){
            throw new RuntimeException();
        }
        Customer customer = searchClient.getById(id);
        return customer;
    }

    //降级方法
    public Customer getByIdFallback(@PathVariable Integer id){
        return new Customer(-1,"hystrix返回的托底数据",-1,new Date());
    }

    @GetMapping("updateById")
    public Customer updateById(Integer id, String name, Integer age, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
        Customer customer = searchClient.updateById(id, name, age, birthday);
        return customer;
    }
}
