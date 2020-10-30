package com.zys.search.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "{code:1,msg:''}";
    }
}
