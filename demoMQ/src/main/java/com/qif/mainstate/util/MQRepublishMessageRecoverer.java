/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MQRepublishMessageRecoverer
 * Author:   Administrator
 * Date:     2019/1/9 10:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public class MQRepublishMessageRecoverer implements MessageRecoverer {

    private Logger logger = LoggerFactory.getLogger(MQRepublishMessageRecoverer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter msgConverter;

    /**
     * 监听出错，也就是没有抓取的异常而是抛出的异常会触发该方法，我们就会在这个接口的实现中，将消息重新入队列
     *
     * @param message
     * @param cause
     */
    @Override
    public void recover(Message message, Throwable cause) {
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        headers.put("x-exception-stacktrace", getStackTraceAsString(cause));
        headers.put("x-exception-message", cause.getCause() != null ? cause.getCause().getMessage() : cause.getMessage());
        headers.put("x-original-exchange", message.getMessageProperties().getReceivedExchange());
        headers.put("x-original-routingKey", message.getMessageProperties().getReceivedRoutingKey());
        this.rabbitTemplate.send(message.getMessageProperties().getReceivedExchange(), message.getMessageProperties().getReceivedRoutingKey(), message);
        logger.error("handler msg (" + msgConverter.fromMessage(message) + ") err, republish to mq.", cause);
    }

    private String getStackTraceAsString(Throwable cause) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        cause.printStackTrace(printWriter);
        return stringWriter.getBuffer().toString();
    }
}