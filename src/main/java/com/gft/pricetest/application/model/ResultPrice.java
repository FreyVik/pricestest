package com.gft.pricetest.application.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResultPrice {

    private Integer productId;

    private Integer brandId;

    private Integer priceId;

    private LocalDateTime appliedDate;

    private Float price;
}
