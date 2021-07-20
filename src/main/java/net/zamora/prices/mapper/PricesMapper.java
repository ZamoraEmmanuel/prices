package net.zamora.prices.mapper;

import net.zamora.prices.controller.dto.PricesDto;
import net.zamora.prices.repository.entity.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesMapper {

    @Mapping(target = "productId", source = "pricesPk.productId")
    @Mapping(target = "brandId", source = "pricesPk.brandId")
    @Mapping(target = "priceList", source = "pricesPk.priceList")
    PricesDto toDto(Prices prices);
}
