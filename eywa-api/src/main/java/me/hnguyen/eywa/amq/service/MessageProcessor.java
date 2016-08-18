package me.hnguyen.eywa.amq.service;

import me.hnguyen.eywa.config.bean.ConfigBean;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 *
 * @author hnguyen
 * @param <T>
 */
public interface MessageProcessor<T> extends MessageListener, ConfigBean {
    
    public void setConverterName(String converterName);
    
    public String getConverterName();
    
    public void messageProcessing(T message);
    
    public void setMessageConverter(MessageConverter converter);

}
