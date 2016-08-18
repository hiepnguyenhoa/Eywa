package me.hnguyen.eywa.amq.processor;

import me.hnguyen.eywa.amq.service.MessageProcessor;
import me.hnguyen.eywa.config.bean.ConfigBeanAbst;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 *
 * @author hnguyen
 * @param <T>
 */
public abstract class MessageProcessorAbst<T> extends ConfigBeanAbst implements MessageProcessor<T> {

    protected String converterName;
    
    private MessageConverter messageConverter;

    @Override
    public void setConverterName(String converterName) {
        this.converterName = converterName;
    }

    @Override
    public String getConverterName() {
        return this.converterName;
    }
    
    @Override
    public void setMessageConverter(MessageConverter converter){
        this.messageConverter = converter;
    }

    @Override
    public void onMessage(Message msg) {
        T t = (T)this.messageConverter.fromMessage(msg);
        messageProcessing(t);
    }

    @Override
    public String getKeyMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
