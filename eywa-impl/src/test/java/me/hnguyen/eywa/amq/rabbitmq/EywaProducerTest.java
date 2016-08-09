package me.hnguyen.eywa.amq.rabbitmq;

import me.hnguyen.eywa.amq.RabbitConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hnguyen
 */
//@Ignore
public class EywaProducerTest {

    @Test
    public void testSenderTemplateCreatesExchange() {
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(RabbitConfig.class);

        EywaSenderTemplate senderTemplate = ctx.getBean(EywaSenderTemplate.class);

        senderTemplate.send("Test");
    }
    
}
