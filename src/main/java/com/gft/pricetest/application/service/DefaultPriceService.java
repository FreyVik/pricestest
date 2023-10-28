package com.gft.pricetest.application.service;

import com.gft.pricetest.application.model.ResultPrice;
import com.gft.pricetest.application.model.AppTariffRequest;
import com.gft.pricetest.domain.model.Price;
import com.gft.pricetest.domain.repository.PriceRepositoryH2;
import com.gft.pricetest.exceptions.exception.NotFoundTariffPriceException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DefaultPriceService implements PriceService {

    PriceRepositoryH2 priceRepository;

    public DefaultPriceService(PriceRepositoryH2 priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public ResultPrice getTariffPrice(AppTariffRequest appTariffRequest) {

        List<Price> prices = priceRepository.findByAppliedDateAndProductIdAndBrandId(
                appTariffRequest.getAppliedDate(),
                appTariffRequest.getProductId(),
                appTariffRequest.getBrandId());

        if (!prices.isEmpty()) {
            Price selectedPrice = prices.stream()
                    .max(Comparator.comparingInt(Price::getPriority)).get();

            return ResultPrice.builder()
                    .productId(selectedPrice.getProductId())
                    .brandId(selectedPrice.getBrandId())
                    .priceId(selectedPrice.getPriceId())
                    .appliedDate(appTariffRequest.getAppliedDate())
                    .price(selectedPrice.getPrice())
                    .build();

        } else {
            throw new NotFoundTariffPriceException(appTariffRequest);
        }
    }
}
