package com.amqp.messagingrabbitmq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * https://spring.io/guides/gs/messaging-rabbitmq/#scratch
 * https://www.baeldung.com/spring-amqp-reactive
 * https://www.baeldung.com/rabbitmq-spring-amqp
 *
 * https://stackoverflow.com/questions/43513681/rabbitmq-get-messages-from-a-queue-using-curl
 * https://cdn.rawgit.com/rabbitmq/rabbitmq-management/v3.7.9/priv/www/api/index.html
 * https://stackoverflow.com/questions/53351186/publish-to-rabbitmq-queue-with-http-api
 */
@Component
public class Receiver
{
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message)
    {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch()
    {
        return latch;
    }
}
