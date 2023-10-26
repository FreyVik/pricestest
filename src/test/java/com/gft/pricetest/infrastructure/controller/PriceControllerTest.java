package com.gft.pricetest.infrastructure.controller;

import com.gft.pricetest.application.service.PriceService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @InjectMocks
    PriceController priceController;

    @Mock
    PriceService priceService;

//    @Test
//    @DisplayName("Verify injections")
//    void shouldVerifyInjections() {
//        when(priceService.getTariffPrice(any())).thenReturn(SIMPLE_RESULT_PRICE);
//
//        priceController.getPrice(OFFSET_DATE_TIME, 1, 1);
//
//        verify(priceService, times(1)).getTariffPrice(any());
//    }
}