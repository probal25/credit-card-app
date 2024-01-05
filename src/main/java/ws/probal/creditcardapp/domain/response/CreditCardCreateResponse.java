package ws.probal.creditcardapp.domain.response;


import lombok.*;
import ws.probal.creditcardapp.domain.entity.CreditCardApplication;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardCreateResponse {
    private String applicationRefId;

    public static CreditCardCreateResponse from(CreditCardApplication creditCardApplication) {
        return CreditCardCreateResponse
                .builder()
                .applicationRefId(creditCardApplication.getReferenceId())
                .build();
    }
}
