package com.qif.mainstate.manage.priority.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class PriorityConsumer {
	public static final String ip = "127.0.0.1";
    public static final int port = 5672;
    public static final String username = "zhengxiang";
    public static final String password = "322122";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPassword(password);
        connectionFactory.setUsername(username);
        connectionFactory.setPort(port);
        connectionFactory.setHost(ip);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume("queue_priority", false, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println(msg);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }
    }
}

