package com.gft.pricetest.infrastructure.controller;

import com.gft.pricetest.application.model.ResultPrice;
import com.gft.pricetest.application.model.AppTariffRequest;
import com.gft.pricetest.application.service.PriceService;
import com.gft.pricetest.infrastructure.api.PricesApi;
import com.gft.pricetest.infrastructure.mapper.ResultPriceMapper;
import com.gft.pricetest.infrastructure.models.ResultPriceDTO;
import com.gft.pricetest.utils.DateTimeFormatterUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController implements PricesApi {

    PriceService priceService;

    ResultPriceMapper resultPriceMapper;

    public PriceController (PriceService priceService, ResultPriceMapper resultPriceMapper) {
        this.priceService = priceService;
        this.resultPriceMapper = resultPriceMapper;
    }

    @Override
    public ResponseEntity<ResultPriceDTO> getPrice(String appliedDate, Integer productId, Integer chainId) {

        ResultPrice resultPrice = priceService.getTariffPrice(AppTariffRequest.builder()
                        .appliedDate(DateTimeFormatterUtil.parseToLocalDateTime(appliedDate))
                        .productId(productId)
                        .brandId(chainId)
                        .build());

        return new ResponseEntity<ResultPriceDTO>(resultPriceMapper.toDto(resultPrice), HttpStatus.OK);
    }
}
