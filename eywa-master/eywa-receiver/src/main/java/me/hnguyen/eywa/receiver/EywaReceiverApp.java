package me.hnguyen.eywa.receiver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hnguyen
 */
public class EywaReceiverApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
            = new AnnotationConfigApplicationContext(EywaReceiverConfigImpl.class);
    }
}
