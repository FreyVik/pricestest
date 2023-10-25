package com.gft.pricetest.framework.controller.price;

import com.gft.pricetest.api.PricesApi;
import com.gft.pricetest.application.model.price.AppResultPrice;
import com.gft.pricetest.application.model.price.AppTariffRequest;
import com.gft.pricetest.application.service.price.PriceService;
import com.gft.pricetest.utils.DateTimeFormatter;
import com.gonzalo.pricetest.models.ResultPriceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController implements PricesApi {

    PriceService priceService;

    public PriceController (PriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public ResponseEntity<ResultPriceDTO> getPrice(String appliedDate, Integer productId, Integer chainId) {

        AppResultPrice resultPrice = priceService.getTariffPrice(AppTariffRequest.builder()
                        .appliedDate(DateTimeFormatter.parseToLocalDateTime(appliedDate))
                        .productId(productId)
                        .chainId(chainId)
                        .build());

        ResultPriceDTO resultDto = new ResultPriceDTO();
        resultDto.setProductId(resultPrice.getProductId());
        resultDto.setPrice(resultPrice.getPrice());
        resultDto.setAppliedDate(resultPrice.getAppliedDate().toString());
        resultDto.setBrandId(resultPrice.getBrandId());

        return new ResponseEntity<ResultPriceDTO>(resultDto, HttpStatus.OK);
    }
}
