package ws.probal.creditcardapp.domain.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardApplicationStatus {

    private String firstName;

    private String lastName;

    private String referenceId;

    private String status;

}
