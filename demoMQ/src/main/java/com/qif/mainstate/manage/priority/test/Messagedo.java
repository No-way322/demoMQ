package com.qif.mainstate.manage.priority.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Messagedo {
	
	public static final String ip = "172.26.1.33";
    public static final int port = 5672;
    public static final String username = "hejun";
    public static final String password = "123456";

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
           for(int j=0;j<1000;j++) {
              AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
//          if(i%2!=0)
//              builder.priority(5);
              AMQP.BasicProperties properties = builder.build();
              channel.basicPublish("amq.topic","qif.testqueue_"+i,properties,("messages-"+j).getBytes());
           }
        }

        channel.close();
        connection.close();
    }
}


