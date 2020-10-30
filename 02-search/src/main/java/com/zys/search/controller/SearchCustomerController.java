package com.zys.search.controller;

import com.zys.search.pojo.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.search.controller
 * @Description : TODO
 * @Create on : 2020/10/26 21:06
 **/
@RestController
@RequestMapping("/search/customer")
public class SearchCustomerController {
    @GetMapping("/table")
    public String table(){
//        int i = 1/0;
        return "{code:0,msg:''}";
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        return customer;
    }

    @GetMapping("/get/{id}")
    public Customer getById(@PathVariable Integer id){
//        int i = 1/0;
        return new Customer(id,"aaa",12,new Date());
    }

    @PostMapping("/updateById")
    public Customer updateById(Integer id,String name,Integer age,Date birthday){
        return new Customer(id,name,age,birthday);
    }
}
