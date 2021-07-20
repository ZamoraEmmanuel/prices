package net.zamora.prices.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PricesDto {

    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private Instant startDate;
    private Instant endDate;
    private Float price;

}
