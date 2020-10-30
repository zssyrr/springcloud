package com.zys.customer.servlet;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.customer.servlet
 * @Description : TODO
 * @Create on : 2020/10/28 18:38
 **/
@WebServlet("/hystrix.stream")
public class HystrixServlet extends HystrixMetricsStreamServlet {
}
