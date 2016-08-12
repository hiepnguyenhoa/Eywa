package me.hnguyen.eywa.amq;

import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.rabbitmq.EywaSendAndReceiveConfig;
import me.hnguyen.eywa.amq.rabbitmq.EywaSenderConfigImpl;
import me.hnguyen.eywa.amq.service.EywaSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author hnguyen
 */
public class EywaSendAndReceiveApp {

    @Inject
    EywaSenderConfigImpl eywaSenderConfig;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(EywaSendAndReceiveConfig.class);
        EywaSendAndReceiveApp app = ctx.getBean(EywaSendAndReceiveApp.class);
        app.sendMessage();
    }

    int count = 0;

    @Scheduled(fixedDelay = 2000)
    private void sendMessage() {
        List<EywaSender> senders = eywaSenderConfig.getEywaSenders();
        senders.stream().forEach((sender) -> sender.send( " -- this is a message " + ++count));
    }
    
}
