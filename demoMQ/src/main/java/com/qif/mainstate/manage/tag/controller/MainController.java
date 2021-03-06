package com.qif.mainstate.manage.tag.controller;


import com.qif.mainstate.manage.tag.entity.MessageSender;
import com.qif.mainstate.manage.tag.entity.TagInfo;
import com.qif.mainstate.manage.tag.service.TaginfoService;
import com.rabbitmq.client.Channel;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/rabbit")
public class MainController {

    // 注入消息生产者
    @Autowired
    private MessageSender messageSender;

    @Autowired
    TaginfoService taginfoService;

    private Logger logger = LoggerFactory.getLogger(MessageSender.class);

    @RequestMapping(value = "/doValid")
    @ResponseBody
    public String doValid() {
        // 发送消息
        try {
            // 设置RoutingKey，匹配message.*即可
            messageSender.setRoutingKey("zx.*");
//            List<TagInfo> list = taginfoService.findTagAll();
            for (int i = 0; i < 200; i++) {
                messageSender.sendDataToQueue( System.currentTimeMillis()+" sdaasdasdasda");
//                messageSender.sendDataToQueue(list);
            }
        } catch (Exception e) {
            logger.error("xxx", e);
        }

        logger.info("to send message:{}", "insert Queue");

        return "success";
    }

    @RequestMapping(value = "/send")
    @ResponseBody
    public String doSend(HttpServletRequest request) {
        // 发送消息
        try {
            String author = request.getParameter("author");
            logger.info("taginfo: " + author);
            // 设置RoutingKey，匹配message.*即可
            messageSender.setRoutingKey("aaaa.*");
            messageSender.sendDataToQueue(author);
        } catch (Exception e) {
            logger.error("xxx", e);
        }
        return "success";
    }


}

