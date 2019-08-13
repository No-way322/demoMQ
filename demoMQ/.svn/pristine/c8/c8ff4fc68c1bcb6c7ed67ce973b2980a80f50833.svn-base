package com.qif.mainstate.manage.tag.entity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.io.Serializable;

public class MessageSender implements Serializable {

	private AmqpTemplate amqpTemplate;

	private static String routingKey;//指定当前消息被谁接受

	private static String bindingKey;//指定当前Exchange下，什么样的RoutingKey会被下派到当前绑定的Queue中

	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

	public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public void sendDataToQueue(Object obj) {

		amqpTemplate.convertAndSend(this.routingKey, obj);
	}

	public String getBindingKey() {
		return bindingKey;
	}

	public void setBindingKey(String bindingKey) {
		this.bindingKey = bindingKey;
	}
}
