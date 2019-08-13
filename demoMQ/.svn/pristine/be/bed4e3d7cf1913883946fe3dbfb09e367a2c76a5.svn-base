package com.qif.mainstate.manage.priority.test;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MqManager {
	public static final String ip = "127.0.0.1";
    public static final int port = 5672;
    public static final String username = "zhengxiang";
    public static final String password = "322122";
    public static final String QueueName = "mqqqueue";
    
	public static Connection GetRabbitConnection() {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setUsername(username);
	    factory.setPassword(password);
	    factory.setHost(ip);
	    factory.setPort(port);
	    Connection conn = null;
	    try {
	        conn = factory.newConnection();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return conn;
	}

}
