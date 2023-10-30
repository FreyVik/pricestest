package com.gft.pricetest.infrastructure.adapter.entity;

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
public class PriceEntity {

    Integer brandId;

    LocalDateTime startDate;

    LocalDateTime endDate;

    @Id
    Integer priceId;

    Integer productId;

    Integer priority;

    Float price;

    String curr;
}
