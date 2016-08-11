package me.hnguyen.eywa.util;

import me.hnguyen.eywa.amq.exception.CreateExchangeException;
import me.hnguyen.eywa.config.bean.ExchangeBean;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import static org.springframework.amqp.core.ExchangeTypes.*;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;

/**
 *
 * @author hnguyen
 */
public class ExchangeFactory {

    private static final String EXCEPTION_MSG = "Unsupport the exchange type";

    public static Exchange createExchange(ExchangeBean exchangeConf) {
        if (exchangeConf == null) {
            return null;
        }
        Exchange exchange = null;
        switch (exchangeConf.getType()) {
            case DIRECT:
                exchange = new DirectExchange(exchangeConf.getName());
                break;
            case TOPIC:
                exchange = new TopicExchange(exchangeConf.getName());
                break;
            case FANOUT:
                exchange = new FanoutExchange(exchangeConf.getName());
                break;
            case HEADERS:
            case SYSTEM:
            case DELAYED:
            default:
                throw new CreateExchangeException(EXCEPTION_MSG);
        }
        return exchange;
    }
}
