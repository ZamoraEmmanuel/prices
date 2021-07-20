package net.zamora.prices.service;

import net.zamora.exceptions.NotFoundException;
import net.zamora.prices.repository.entity.Prices;

import java.time.Instant;
import java.util.List;

public interface PricesService {
    List<Prices> getAll();

    Prices getByBrandProductAndDate(Integer brandId, Integer productId, Instant date) throws NotFoundException;
}
