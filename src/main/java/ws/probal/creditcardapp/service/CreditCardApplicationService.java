package ws.probal.creditcardapp.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ws.probal.creditcardapp.common.exception.RecordNotFoundException;
import ws.probal.creditcardapp.common.utils.AppUtils;
import ws.probal.creditcardapp.domain.entity.CreditCardApplication;
import ws.probal.creditcardapp.domain.enums.ApplicationStatusEnum;
import ws.probal.creditcardapp.domain.request.CreditCardRequest;
import ws.probal.creditcardapp.domain.response.CreditCardApplicationStatus;
import ws.probal.creditcardapp.domain.response.CreditCardCreateResponse;
import ws.probal.creditcardapp.repository.CreditCardApplicationRepository;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditCardApplicationService {

    private final CreditCardApplicationRepository creditCardApplicationRepository;

    public CreditCardCreateResponse saveCreditCardApplication(CreditCardRequest creditCardRequest) {

        CreditCardApplication creditCardApplication = new CreditCardApplication();
        BeanUtils.copyProperties(creditCardRequest, creditCardApplication);
        creditCardApplication.setReferenceId(AppUtils.generateUUID());
        creditCardApplication.setStatus(ApplicationStatusEnum.PENDING.getCode());
        creditCardApplication = creditCardApplicationRepository.save(creditCardApplication);

        return CreditCardCreateResponse.from(creditCardApplication);
    }

    public CreditCardApplicationStatus getCreditCardApplicationStatus(String referenceId) {
        CreditCardApplication creditCardApplication = creditCardApplicationRepository
                .findByReferenceId(referenceId).orElse(null);

        if (Objects.isNull(creditCardApplication)) {
            log.error("No application found with this reference id: {}", referenceId);
            throw new RecordNotFoundException("No application found with this reference id: " +  referenceId);
        }

        CreditCardApplicationStatus creditCardApplicationStatus = CreditCardApplicationStatus.builder().build();
        BeanUtils.copyProperties(creditCardApplication, creditCardApplicationStatus);
        return creditCardApplicationStatus;
    }
}
