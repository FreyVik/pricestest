package com.gft.pricetest.infrastructure.adapter.mapper;

import com.gft.pricetest.domain.model.Price;
import com.gft.pricetest.infrastructure.adapter.entity.PriceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    List<Price> toDomain(List<PriceEntity> price);

}
