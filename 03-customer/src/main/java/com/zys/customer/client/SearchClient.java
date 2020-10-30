package com.zys.customer.client;

import com.zys.customer.entity.Customer;
import com.zys.customer.factory.SearchFallBackFactory;
import com.zys.customer.fallback.SearchFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.customer.client
 * @Description : TODO
 * @Create on : 2020/10/27 16:10
 **/
//@FeignClient(value = "SEARCH",fallback = SearchFallBack.class)
@FeignClient(value = "SEARCH",fallbackFactory = SearchFallBackFactory.class)
public interface SearchClient {

    @RequestMapping(value = "/search/customer/table",method = RequestMethod.GET)
    String table();

    @RequestMapping("/search/customer//save")
    Customer save(@RequestBody Customer customer);

    @GetMapping("/search/customer//get/{id}")
    Customer getById(@PathVariable Integer id);

    @PostMapping("/search/customer//updateById")
    Customer updateById(@RequestParam(value = "id") Integer id,
                        @RequestParam(value = "name") String name,
                        @RequestParam(value = "age") Integer age,
                        @RequestParam(value = "birthday") Date birthday);
}
