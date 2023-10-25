package com.gft.pricetest.application.model.price;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AppTariffRequest {

    LocalDateTime appliedDate;

    Integer productId;

    Integer chainId;

}
