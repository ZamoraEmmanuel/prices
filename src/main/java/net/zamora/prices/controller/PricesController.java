package net.zamora.prices.controller;

import net.zamora.exceptions.NotFoundException;
import net.zamora.prices.controller.dto.PricesDto;
import net.zamora.prices.mapper.PricesMapper;
import net.zamora.prices.repository.entity.Prices;
import net.zamora.prices.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/prices")
public class PricesController {

    @Autowired
    private PricesService pricesService;

    @Autowired
    private PricesMapper pricesMapper;

    @GetMapping
    public List<Prices> getAll(){
        return pricesService.getAll();
    }

    @GetMapping(value="/{brandId}/{productId}/{date}")
    public PricesDto getByBrandProductAndDate(
            @PathVariable("brandId") Integer brandId,
            @PathVariable("productId") Integer productId,
            @PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date
            ) throws NotFoundException {
        return pricesMapper.toDto(pricesService.getByBrandProductAndDate(brandId,productId,date.toInstant()));
    }
}
