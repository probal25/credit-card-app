package ws.probal.creditcardapp.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.probal.creditcardapp.domain.request.CreditCardRequest;
import ws.probal.creditcardapp.domain.response.CreditCardApplicationStatus;
import ws.probal.creditcardapp.domain.response.CreditCardCreateResponse;
import ws.probal.creditcardapp.service.CreditCardApplicationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credit-card-application")
@Tag(name = "Credit card application")
public class CreditCardApplicationController {

    private final CreditCardApplicationService creditCardApplicationService;

    @Operation(summary = "Create a new credit card application")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping("/apply")
    public ResponseEntity<CreditCardCreateResponse> createNewCreditCardRequest(@RequestBody CreditCardRequest creditCardRequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creditCardApplicationService.saveCreditCardApplication(creditCardRequest));
    }

    @Operation(summary = "Get status of credit card application")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/status/{referenceId}")
    public ResponseEntity<CreditCardApplicationStatus> creditCardApplicationStatus(@PathVariable String referenceId) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(creditCardApplicationService.getCreditCardApplicationStatus(referenceId));
    }

}
