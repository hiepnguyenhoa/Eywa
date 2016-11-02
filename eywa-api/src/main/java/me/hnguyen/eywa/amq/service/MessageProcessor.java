package me.hnguyen.eywa.amq.service;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConverter;

import me.hnguyen.eywa.config.bean.ConfigBean;

/**
 * @author hnguyen
 */
public interface MessageProcessor<T> extends MessageListener, ConfigBean {

    void setConverterName(String converterName);

    String getConverterName();

    void messageProcessing(T message);

    void setMessageConverter(MessageConverter converter);

}
