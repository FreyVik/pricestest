package com.gft.pricetest.infrastructure.adapter.exception;

import com.gft.pricetest.application.model.AppTariffRequest;
import lombok.Getter;

@Getter
public class NotFoundTariffPriceException extends RuntimeException {

    private AppTariffRequest appTariffRequest;

    public NotFoundTariffPriceException(AppTariffRequest appTariffRequest) {

        this.appTariffRequest = appTariffRequest;

    }
}
