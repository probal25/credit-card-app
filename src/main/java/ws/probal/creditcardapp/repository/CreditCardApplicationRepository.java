package ws.probal.creditcardapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.probal.creditcardapp.domain.entity.CreditCardApplication;

import java.util.List;

public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApplication, Long> {
    List<CreditCardApplication> findByStatus(String status);
}
