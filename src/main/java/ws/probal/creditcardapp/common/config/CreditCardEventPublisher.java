package ws.probal.creditcardapp.common.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ws.probal.creditcardapp.domain.events.NewCreditCardEvent;
import ws.probal.creditcardapp.service.EventPublisherService;

import java.util.function.Supplier;

@Slf4j
@Configuration
@AllArgsConstructor
public class CreditCardEventPublisher {
    private EventPublisherService eventPublisherService;

    @Bean
    public Supplier<NewCreditCardEvent> publishNewCreditCardEvent() {
        return () -> eventPublisherService.publishEvent();
    }
}
