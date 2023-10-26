package com.gft.pricetest.application.service;

import com.gft.pricetest.application.model.ResultPrice;
import com.gft.pricetest.application.model.AppTariffRequest;
import com.gft.pricetest.domain.model.Price;
import com.gft.pricetest.domain.repository.PriceRepositoryH2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DomainPriceService implements PriceService {

    PriceRepositoryH2 priceRepository;

    public DomainPriceService(PriceRepositoryH2 priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public ResultPrice getTariffPrice(AppTariffRequest appTariffRequest) {

        List<Price> prices = priceRepository.findByAppliedDateAndProductId(appTariffRequest.getAppliedDate(), appTariffRequest.getProductId());

        if (!prices.isEmpty()) {
            Price selectedPrice = prices.stream()
                    .max(Comparator.comparingInt(Price::getPriority)).get();

            return ResultPrice.builder()
                    .productId(selectedPrice.getProductId())
                    .brandId(selectedPrice.getBrandId())
                    .appliedDate(appTariffRequest.getAppliedDate())
                    .price(selectedPrice.getPrice())
                    .build();

        } else {
            return null;
        }


    }
}
