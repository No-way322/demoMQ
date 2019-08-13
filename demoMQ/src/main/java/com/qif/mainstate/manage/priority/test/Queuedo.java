package com.qif.mainstate.manage.priority.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Queuedo {
    public static final String ip = "172.26.1.233";
    public static final int port = 5672;
    public static final String username = "qif";
    public static final String password = "qif123.,";

    public static void main(String[] arggs) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPassword(password);
        connectionFactory.setUsername(username);
        connectionFactory.setPort(port);
        connectionFactory.setHost(ip);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        //create exchange
        channel.exchangeDeclare("amq.topic","topic",true);
        //create queue with priority
        Map<String,Object> args = new HashMap<String,Object>();
        args.put("x-max-priority", 10);
        for(int i=0;i<10000;i++) {
//        	channel.queueDelete("qif_testqueue_"+i);
        	channel.queueDeclare("qif_testqueue_"+i, true, false, false, args);
            channel.queueBind("qif_testqueue_"+i, "amq.topic", "qif.testqueue_"+i);
        }

        //send message with priority
//        for(int i=0;i<10;i++) {
//            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
//            if(i%2!=0)
//                builder.priority(5);
//            AMQP.BasicProperties properties = builder.build();
//            channel.basicPublish("exchange_priority","rk_priority",properties,("messages-"+i).getBytes());
//        }

        channel.close();
        connection.close();
    }
}
