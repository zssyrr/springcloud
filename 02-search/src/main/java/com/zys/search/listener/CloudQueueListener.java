package com.zys.search.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zys
 * @version v1.0.0
 * @Package : com.zys.search.listener
 * @Description : TODO
 * @Create on : 2020/10/29 20:58
 **/
@Component
public class CloudQueueListener {

    @StreamListener(value = "cloud-queue")
    public void listen(Object msg,
                       @Header(name = AmqpHeaders.CHANNEL)Channel channel,
                       @Header(name = AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws IOException {
        System.out.println(msg);
        channel.basicAck(deliveryTag,false);
    }
}
