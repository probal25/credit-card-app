package ws.probal.creditcardapp.domain.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Schema
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardRequest {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Min(0)
    private BigDecimal annualIncome;

    @NotEmpty
    private String address;
}
