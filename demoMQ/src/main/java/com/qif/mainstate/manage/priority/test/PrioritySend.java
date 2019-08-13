package com.qif.mainstate.manage.priority.test;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.springframework.util.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection; 


/**
 * @author Administrator
 *https://sheungxin.iteye.com/blog/2344874
 */
public class PrioritySend {  
    private static String exchange_name="priority_direct";  
      
    public static void prioritySend(Serializable mes) throws IOException, TimeoutException{  
        Connection conn=MqManager.GetRabbitConnection();  
        Channel channel=conn.createChannel();  
        channel.exchangeDeclare(exchange_name, "topic");  
        //发送10条消息  
        for(int i=0;i<2000;i++){  
            //随机设置消息优先级  
//            Builder properties=new BasicProperties.Builder();  
//            int priority=new Random().nextInt(100);  
//            properties.priority(priority);//建议0~255，超过貌似也没问题  
        	
        	AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
            if(i==123||i==909||i==456)
                builder.priority(5);
            AMQP.BasicProperties properties = builder.build();
            String _mes=mes.toString()+i;  
            channel.basicPublish(exchange_name, "", properties, SerializationUtils.serialize(_mes));  
            System.out.println(" "+_mes);  
        }  
        channel.close();  
        conn.close();  
    }  
      
    public static void main(String[] args) throws IOException, TimeoutException {  
        prioritySend("priority send:hello world!");  
    }  
  
}  
