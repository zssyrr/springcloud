package com.zys.search.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.search.stream
 * @Description : TODO
 * @Create on : 2020/10/29 20:55
 **/
public interface StreamClient {
    @Input("cloud-queue")
    SubscribableChannel input();
}
