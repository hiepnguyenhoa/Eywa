package me.hnguyen.eywa.sender;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.service.EywaSender;
import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.dto.LoggingDtoImpl;
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

    @Scheduled(fixedDelay = 500)
    private void sendMessage() {
        List<EywaSender> senders = eywaSenderConfig.getEywaSenders();
        senders.stream().forEach((sender) -> {
            sender.send(createLoggingDto());
            System.out.println("[-] " + Thread.currentThread().getName() + " Send message " + ++count);
        });
    }
    
    private static LoggingDto createLoggingDto(){
        return new LoggingDtoImpl(1l,new Date(), "createLoggingDto", "Message Title", "INFO");
    }

}
