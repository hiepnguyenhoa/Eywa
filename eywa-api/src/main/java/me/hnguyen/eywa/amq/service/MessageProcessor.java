package me.hnguyen.eywa.amq.service;

import me.hnguyen.eywa.config.bean.ConfigBean;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 * @param <T>
 * @author hnguyen
 */
public interface MessageProcessor<T> extends MessageListener, ConfigBean {

    void setConverterName(String converterName);

    String getConverterName();

    void messageProcessing(T message);

    void setMessageConverter(MessageConverter converter);

}
