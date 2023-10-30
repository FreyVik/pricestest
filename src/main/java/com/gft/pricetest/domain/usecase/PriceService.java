package com.gft.pricetest.domain.usecase;

import com.gft.pricetest.application.model.ResultPrice;
import com.gft.pricetest.application.model.AppTariffRequest;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {

    ResultPrice getTariffPrice(AppTariffRequest appTariffRequest);

}
