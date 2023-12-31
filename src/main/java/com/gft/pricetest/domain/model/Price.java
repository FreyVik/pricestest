package com.gft.pricetest.domain.model;

import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    Integer brandId;

    LocalDateTime startDate;

    LocalDateTime endDate;

    Integer priceId;

    Integer productId;

    Integer priority;

    Float price;

    String curr;

}
