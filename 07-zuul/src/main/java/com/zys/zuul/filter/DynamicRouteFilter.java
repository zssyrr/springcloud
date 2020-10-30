package com.zys.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.zuul.filter
 * @Description : TODO
 * @Create on : 2020/10/29 15:01
 **/
@Component
public class DynamicRouteFilter extends ZuulFilter {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.RIBBON_ROUTING_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //1.获取请求携带的参数
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String redisKey = request.getParameter("redisKey");
        //2.判断redisKey不为null
        if(!StringUtils.isEmpty(redisKey)){
            Object serviceId = redisTemplate.opsForHash().get(redisKey, "serviceid");
            Object requestUri = redisTemplate.opsForHash().get(redisKey, "requesturi");
            requestContext.put(FilterConstants.SERVICE_ID_KEY,serviceId);
            requestContext.put(FilterConstants.REQUEST_URI_KEY,requestUri);
        }
        return null;
    }
}
