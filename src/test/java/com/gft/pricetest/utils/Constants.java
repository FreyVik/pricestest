package com.gft.pricetest.utils;


import com.gft.pricetest.application.model.AppTariffRequest;
import com.gft.pricetest.application.model.ResultPrice;
import com.gft.pricetest.domain.model.Price;
import com.gft.pricetest.infrastructure.models.ResultPriceDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Constants {

    public static final LocalDateTime SIMPLE_LOCAL_DATE_TIME = LocalDateTime.of(
            LocalDate.of(2020, 6, 14),
            LocalTime.of(1, 0, 0));

    public static final LocalDateTime FIRST_START_LOCAL_DATE_TIME = LocalDateTime.of(
            LocalDate.of(2020, 6, 14),
            LocalTime.of(0, 0, 0));

    public static final LocalDateTime FIRST_END_LOCAL_DATE_TIME = LocalDateTime.of(
            LocalDate.of(2020, 12, 31),
            LocalTime.of(23, 59, 59));

    public static final LocalDateTime SECOND_START_LOCAL_DATE_TIME = LocalDateTime.of(
            LocalDate.of(2020, 6, 14),
            LocalTime.of(15, 0, 0));

    public static final LocalDateTime SECOND_END_LOCAL_DATE_TIME = LocalDateTime.of(
            LocalDate.of(2020, 6, 14),
            LocalTime.of(18, 30, 0));

    public static final ResultPrice SIMPLE_RESULT_PRICE = ResultPrice.builder()
            .productId(1)
            .brandId(1)
            .appliedDate(SIMPLE_LOCAL_DATE_TIME)
            .price(25.5f)
            .build();

    public static final ResultPriceDTO RESULT_PRICE_DTO = new ResultPriceDTO();

    public static final Price FIST_TARIFF_PRICE = Price.builder()
            .brandId(1)
            .startDate(FIRST_START_LOCAL_DATE_TIME)
            .endDate(FIRST_END_LOCAL_DATE_TIME)
            .priceId(1)
            .productId(53455)
            .priority(0)
            .price(35.5f)
            .curr("EUR")
            .build();

    public static final Price SECOND_TARIFF_PRICE = Price.builder()
            .brandId(1)
            .startDate(SECOND_START_LOCAL_DATE_TIME)
            .endDate(SECOND_END_LOCAL_DATE_TIME)
            .priceId(2)
            .productId(53455)
            .priority(1)
            .price(25.45f)
            .curr("EUR")
            .build();

    public static final List<Price> SIMPLE_PRICE_LIST = List.of(FIST_TARIFF_PRICE, SECOND_TARIFF_PRICE);

    public static final List<Price> SIMPLE_PRICE_LIST_OF_1 = List.of(SECOND_TARIFF_PRICE);

    public static final AppTariffRequest SIMPLE_APP_TARIFF_REQUEST = AppTariffRequest.builder()
            .appliedDate(SIMPLE_LOCAL_DATE_TIME)
            .productId(53455)
            .brandId(1)
            .build();

    public Constants() {
        RESULT_PRICE_DTO.setProductId(1);
        RESULT_PRICE_DTO.setBrandId(1);
        RESULT_PRICE_DTO.setAppliedDate("2020-06-14 18:30:01");
        RESULT_PRICE_DTO.setPrice(25.5f);
    }
}
