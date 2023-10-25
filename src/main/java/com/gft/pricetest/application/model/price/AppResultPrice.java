package com.gft.pricetest.application.model.price;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AppResultPrice {

    private Integer productId;

    private Integer brandId;

    private LocalDateTime appliedDate;

    private Float price;
}
