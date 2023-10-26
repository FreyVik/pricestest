package com.gft.pricetest.application.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultPrice {

    private Integer productId;

    private Integer brandId;

    private LocalDateTime appliedDate;

    private Float price;
}
