package ws.probal.creditcardapp.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@AllArgsConstructor
public enum ApplicationStatusEnum {

    PENDING("PENDING", "Application Pending"),
    PUBLISHED("PUBLISHED", "Application Published"),
    APPROVED("APPROVED", "Application Approved"),
    ;

    private String code;
    private String description;
}
