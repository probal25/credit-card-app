package ws.probal.creditcardapp.domain.events;


import lombok.*;
import ws.probal.creditcardapp.domain.dto.ApplicationDetail;
import ws.probal.creditcardapp.domain.enums.EventType;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCreditCardEvent {
    private EventType eventType = EventType.NEW_CREDIT_CARD;
    private List<ApplicationDetail> applicationDetails;
}
