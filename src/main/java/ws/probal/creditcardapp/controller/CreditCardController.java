package ws.probal.creditcardapp.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.probal.creditcardapp.domain.request.CreditCardRequest;
import ws.probal.creditcardapp.domain.response.CreditCardCreateResponse;
import ws.probal.creditcardapp.service.CreditCardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credit-card")
@Tag(name = "Credit card application")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Operation(summary = "Create a new credit card application")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping("/apply")
    public ResponseEntity<CreditCardCreateResponse> createNewCreditCardRequest(@RequestBody CreditCardRequest creditCardRequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creditCardService.saveCreditCardApplication(creditCardRequest));
    }

}
