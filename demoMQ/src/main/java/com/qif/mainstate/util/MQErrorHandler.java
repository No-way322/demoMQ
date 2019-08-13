/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MQErrorHandler
 * Author:   Administrator
 * Date:     2019/1/9 11:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.util;

import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;
import org.apache.commons.lang.reflect.FieldUtils;
import org.slf4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

public class MQErrorHandler implements ErrorHandler {

    private Logger logger = LoggerFactory.getLogger(MQErrorHandler.class);

//    @Autowired
//    private RedisService redisService;
    @Autowired
    private MessageConverter msgConverter;

    @Override
    public void handleError(Throwable cause) {
        Field mqMsgField = FieldUtils.getField(Exception.class, "mqMsg", true);
        if (mqMsgField != null) {
            try {
                Message mqMsg = (Message) mqMsgField.get(cause);
                Object msgObj = msgConverter.fromMessage(mqMsg);
                logger.error("handle MQ msg: " + msgObj + " failed, record it to redis.", cause);
//                redisService.zadd(App.MsgErr.MQ_MSG_ERR_RECORD_KEY, new Double(new Date().getTime()), msgObj.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.error("An error occurred.", cause);
        }
    }

}