package me.hnguyen.eywa.amq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 *
 * @author hnguyen
 * @param <T>
 */
public abstract class MessageProcessorAbst<T> implements MessageProcessor<T> {

    private Long id;

    protected String converterName;
    
    private MessageConverter messageConverter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setConverterName(String converterName) {
        this.converterName = converterName;
    }

    @Override
    public String getConverterName() {
        return this.converterName;
    }
    
    public void setMessageConverter(MessageConverter converter){
        this.messageConverter = converter;
    }

    @Override
    public void onMessage(Message msg) {
//        T t = (T)this.messageConverter.fromMessage(msg);
//        messageProcessing(t);
        System.out.println("[X] receive " + msg);
    }

}
