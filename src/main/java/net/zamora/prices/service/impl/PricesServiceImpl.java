package net.zamora.prices.service.impl;

import net.zamora.exceptions.NotFoundException;
import net.zamora.prices.repository.PricesRepository;
import net.zamora.prices.repository.entity.Prices;
import net.zamora.prices.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public List<Prices> getAll(){
        return pricesRepository.findAll();
    }

    @Override
    public Prices getByBrandProductAndDate(Integer brandId, Integer productId, Instant date) throws NotFoundException {
        List<Prices> datePrices = pricesRepository.findAllByPricesPkBrandIdAndPricesPkProductId(brandId, productId, date);
        if (datePrices.size()==0){
            throw new NotFoundException("price-not-exist",
                    String.format("No existe una tarifa para el producto %d de la cadena %d en la fecha %s", productId, brandId, date.toString()));
        }
        return datePrices.get(0);
    }
}
