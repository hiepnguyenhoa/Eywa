package me.hnguyen.eywa.amq;

import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.rabbitmq.EywaSenderConfigImpl;
import me.hnguyen.eywa.service.EywaSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
@EnableScheduling
public class EywaSenderApp {

    @Inject
    EywaSenderConfigImpl eywaSenderConfig;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(EywaSenderConfigImpl.class);
        EywaSenderApp app = ctx.getBean(EywaSenderApp.class);
        app.sendMessage();
    }

    int count = 0;

    @Scheduled(fixedDelay = 2000)
    private void sendMessage() {
        List<EywaSender> senders = eywaSenderConfig.getEywaSenders();
        for (EywaSender sender : senders) {
            sender.send(++count + " -- this is a message");
        }
    }

}
