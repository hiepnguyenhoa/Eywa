package me.hnguyen.eywa.util;

import me.hnguyen.eywa.amq.exception.CreateExchangeException;
import me.hnguyen.eywa.config.bean.ExchangeBean;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import static org.springframework.amqp.core.ExchangeTypes.*;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;

/**
 *
 * @author hnguyen
 */
public class EywaExchangeFactory {

    private static final String EXCEPTION_MSG = "Unsupport the exchange type";

    public static Exchange createExchange(ExchangeBean exchangeDto) {
        Validate.notNull(exchangeDto);
        Exchange exchange = null;
        switch (exchangeDto.getType()) {
            case DIRECT:
                exchange = new DirectExchange(exchangeDto.getName());
                break;
            case TOPIC:
                exchange = new TopicExchange(exchangeDto.getName());
                break;
            case FANOUT:
                exchange = new FanoutExchange(exchangeDto.getName());
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
