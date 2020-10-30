package com.zys.customer.fallback;

import com.zys.customer.client.SearchClient;
import com.zys.customer.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.customer.fallback
 * @Description : TODO
 * @Create on : 2020/10/27 19:33
 **/
@Component
public class SearchFallBack implements SearchClient {
    @Override
    public String table() {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer getById(Integer id) {
        return new Customer(-1,"",-1,new Date());
    }

    @Override
    public Customer updateById(Integer id, String name, Integer age, Date birthday) {
        return null;
    }
}
