package ws.probal.creditcardapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ws.probal.creditcardapp.domain.dto.ApplicationDetail;
import ws.probal.creditcardapp.domain.entity.CreditCardApplication;
import ws.probal.creditcardapp.domain.enums.ApplicationStatusEnum;
import ws.probal.creditcardapp.domain.events.NewCreditCardEvent;
import ws.probal.creditcardapp.repository.CreditCardApplicationRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventPublisherService {

    private final CreditCardApplicationRepository creditCardApplicationRepository;

    public NewCreditCardEvent publishEvent() {
        List<CreditCardApplication> creditCardApplications = creditCardApplicationRepository
                .findByStatus(ApplicationStatusEnum.PENDING.getCode());

        List<ApplicationDetail> applicationDetails = creditCardApplications.stream().map(creditCardApplication -> {
            ApplicationDetail applicationDetail = ApplicationDetail.builder().build();
            BeanUtils.copyProperties(creditCardApplication, applicationDetail);
            creditCardApplication.setStatus(ApplicationStatusEnum.PUBLISHED.getCode());
            return applicationDetail;
        }).toList();

        if (!applicationDetails.isEmpty()) {
            creditCardApplicationRepository.saveAll(creditCardApplications);

            log.info("### New credit card applications have been checked and ready for publish," + " Total records: {}",
                    applicationDetails.size());

            return NewCreditCardEvent.builder().applicationDetails(applicationDetails).build();
        }
        return null;
    }
}
