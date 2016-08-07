package me.hnguyen.eywa.amq.rabbitmq;

import me.hnguyen.eywa.amq.SenderConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author hnguyen
 */
public class EywaProducerTest {

    @Test
    public void testSenderTemplateCreatesExchange() {
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(SenderConfig.class);

        EywaSenderTemplate senderTemplate = ctx.getBean(EywaSenderTemplate.class);

        senderTemplate.send("Test");
    }
}
