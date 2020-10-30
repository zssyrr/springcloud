package com.zys.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.zuul.fallback
 * @Description : TODO
 * @Create on : 2020/10/29 19:39
 **/
@Component
public class ZuulFallback implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";  //指定哪些服务出现问题后执行当前服务降级方法
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        //route出现了cause问题
        System.out.println(route+"服务出现了："+cause.getMessage());
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return cause.getMessage();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                String msg = "服务器出问题了";
                return new ByteArrayInputStream(msg.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders header = new HttpHeaders();
                header.setContentType(MediaType.parseMediaType("text/html;charset=utf-8"));
                return header;
            }
        };
    }
}
