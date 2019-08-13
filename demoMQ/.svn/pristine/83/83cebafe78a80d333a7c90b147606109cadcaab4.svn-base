package com.qif.mainstate.common.interceptor;

import com.qif.mainstate.manage.tag.entity.TagInfo;
import com.qif.mainstate.manage.tag.service.TaginfoService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

public class MessageConsumer implements ChannelAwareMessageListener {

    private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    MongoTemplate mongoTemplate;

//    @Override
//    public void onMessage(Message message) {
////		createOrder();
//        logger.info("receive message:{}", message);
//    }

    /**
     * 关键点在实现了ChannelAwareMessageListener的onMessage方法后，会有2个参数。一个是message（消息实体），一个是channel就是当前的通道
     * 很多地方都没有说清楚怎么去手动ack，其实手动ack就是在当前channel里面调用basicAsk的方法，并传入当前消息的tagId就可以了
     *
     * @param message
     * @param channel
     * @throws Exception
     */
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
//        logger.info("receive message:{}", message);
//        //手动应答和自动应答不一样，需要将autoAck设置为false，当消费者收到消息在合适的时候来显示的进行确认，说我已经接收到了该消息了，
//        // RabbitMQ可以从队列中删除该消息了，可以通过显示调用channel.basicAck(envelope.getDeliveryTag(), false);来告诉消息服务器来删除消息
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);//deliveryTag是tag的id，由生产者生成

        try {
            //业务逻辑
            logger.info("消费 receive msg : " + message);
//            mongoTemplate.insert(message);
            // 消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //手动确认确认消息成功消费
        } catch (Exception e) {
            logger.info("消费失败: " + message);
            try {
                // ack返回false，并重新回到队列，api里面解释得很清楚
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
