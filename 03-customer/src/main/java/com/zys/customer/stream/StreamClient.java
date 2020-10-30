package com.zys.customer.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.customer.stream
 * @Description : TODO
 * @Create on : 2020/10/29 20:44
 **/
public interface StreamClient {
    @Output(value = "cloud-queue")
    MessageChannel output();
}
