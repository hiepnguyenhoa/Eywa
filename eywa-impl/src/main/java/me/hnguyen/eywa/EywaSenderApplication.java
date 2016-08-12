package me.hnguyen.eywa;

import java.util.ArrayList;
import java.util.List;
import me.hnguyen.eywa.amq.RabbitConfig;
import me.hnguyen.eywa.amq.rabbitmq.EywaAMQServerConfig;
import me.hnguyen.eywa.amq.rabbitmq.EywaSenderConfigImpl;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import me.hnguyen.eywa.amq.rabbitmq.EywaSenderConfig;

/**
 *
 * @author hnguyen
 */
public class EywaSenderApplication {

//    private final ApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitConfig.class);
//
//    public List<EywaSenderTemplate> createEywaSenderTemplates(ApplicationContext ctx) {
//        Validate.notNull(ctx);
//        EywaAMQServerConfig eywaAMQServerConfig = ctx.getBean(EywaAMQServerConfig.class);
//        Validate.notNull(eywaAMQServerConfig);
//        List<EywaSenderTemplate> senderTemplates = new ArrayList<>();
//        List<Exchange> exchanges = eywaAMQServerConfig.getExchanges();
//        List<Binding> bindings = eywaAMQServerConfig.getBindings();
//        
//        for(Exchange exchange:exchanges){
//            RabbitTemplate rabbitTemplate = eywaAMQServerConfig.
//            EywaSenderTemplate senderTmpl = new EywaSenderTemplateImpl(rabbitTemplate)
//                    
//        }
//
//        senderTemplate.send("topic.*", "Test");
//    }
//
//    public static void main(String[] args) {
//
//        EywaSenderApplication senderApplication = new EywaSenderApplication();
//
//        List<EywaSenderTemplate> senderTemplates = senderApplication.createEywaSenderTemplates(senderApplication.ctx);
//    }
}
