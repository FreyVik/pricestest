package com.gft.pricetest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class Price {

    Integer brandId;

    LocalDateTime startDate;

    LocalDateTime endDate;

    @Id
    Integer priceList;

    Integer productId;

    Integer priority;

    Float price;

    String curr;
}
