package com.zys.customer.factory;

import com.zys.customer.client.SearchClient;
import com.zys.customer.fallback.SearchFallBack;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.customer.factory
 * @Description : TODO
 * @Create on : 2020/10/27 19:43
 **/
@Component
public class SearchFallBackFactory implements FallbackFactory<SearchClient> {
    @Autowired
    private SearchFallBack searchFallBack;

    @Override
    public SearchClient create(Throwable throwable) {
        throwable.printStackTrace();
        return searchFallBack;
    }
}
