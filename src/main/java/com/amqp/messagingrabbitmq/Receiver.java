package com.amqp.messagingrabbitmq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * https://spring.io/guides/gs/messaging-rabbitmq/#scratch
 * https://www.baeldung.com/spring-amqp-reactive
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
