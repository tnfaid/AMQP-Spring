package com.amqp.messagingrabbitmq.publisher;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {

    private final static String QUEUE_NAME = "products_queue";

    public static void main(String[]args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.32.6.236");
        factory.setUsername("app");
        factory.setPassword("1rstwap");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String message = "product details";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}