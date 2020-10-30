package com.zys.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.zuul.filter
 * @Description : TODO
 * @Create on : 2020/10/29 11:06
 **/
@Component
public class AuthFilter extends ZuulFilter {
    //指定过滤器类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override  //指定过滤器的执行顺序
    public int filterOrder() {
        return FilterConstants.RIBBON_ROUTING_FILTER_ORDER - 9;
    }

    @Override  //过滤器开关
    public boolean shouldFilter() {
        return true;
    }

    @Override  //过滤器要执行的业务逻辑处理
    public Object run() throws ZuulException {
        //传递一个参数：token=123
        //获取request
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //拿到token参数
        String token = request.getParameter("token");
        //校验是否登录
        if(token==null || !"123".equals(token)){
            //token校验失败，直接响应数据
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
