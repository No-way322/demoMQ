package com.qif.mainstate.manage.priority.consume;

import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class Recv3 {
	
	private final static String QUEUE_NAME = "test_queue_consume";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        
        Map<String, Object> consumerArgs = new HashMap<>(8);
		consumerArgs.put("x-priority", 10);
		Object a = consumerArgs.get("x-priority");
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumerArgs, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("优先级是:"+a+" [x] Received333 '" + message + "'");
            //休眠
//            Thread.sleep(100);
            // 返回确认状态
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }

}
