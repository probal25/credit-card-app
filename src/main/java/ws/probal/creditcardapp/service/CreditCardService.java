package ws.probal.creditcardapp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ws.probal.creditcardapp.common.utils.AppUtils;
import ws.probal.creditcardapp.domain.entity.CreditCardApplication;
import ws.probal.creditcardapp.domain.enums.ApplicationStatusEnum;
import ws.probal.creditcardapp.domain.request.CreditCardRequest;
import ws.probal.creditcardapp.domain.response.CreditCardCreateResponse;
import ws.probal.creditcardapp.repository.CreditCardApplicationRepository;

@Service
@RequiredArgsConstructor
public class CreditCardService {

    private final CreditCardApplicationRepository creditCardApplicationRepository;

    public CreditCardCreateResponse saveCreditCardApplication(CreditCardRequest creditCardRequest) {

        CreditCardApplication creditCardApplication = new CreditCardApplication();
        BeanUtils.copyProperties(creditCardRequest, creditCardApplication);
        creditCardApplication.setReferenceId(AppUtils.generateUUID());
        creditCardApplication.setStatus(ApplicationStatusEnum.PENDING.getCode());
        creditCardApplication = creditCardApplicationRepository.save(creditCardApplication);

        return CreditCardCreateResponse.from(creditCardApplication);
    }
}
