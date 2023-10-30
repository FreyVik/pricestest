package com.gft.pricetest.infrastructure.adapter.mapper;

import com.gft.pricetest.application.model.ResultPrice;
import com.gft.pricetest.infrastructure.models.ResultPriceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultPriceMapper {

    ResultPriceDTO toDto(ResultPrice resultPrice);

    ResultPrice dtoToResultPrice(ResultPriceDTO resultPriceDTO);

}
