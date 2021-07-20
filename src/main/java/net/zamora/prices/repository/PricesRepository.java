package net.zamora.prices.repository;

import net.zamora.prices.repository.entity.Prices;
import net.zamora.prices.repository.entity.PricesPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface PricesRepository extends JpaRepository<Prices, PricesPk> {

    @Query("SELECT p " +
            "FROM Prices p " +
            "WHERE p.pricesPk.brandId = :brandId " +
            "AND p.pricesPk.productId = :productId " +
            "AND p.startDate <= :date " +
            "AND :date <= p.endDate " +
            "ORDER BY p.priority desc")
    List<Prices> findAllByPricesPkBrandIdAndPricesPkProductId(@Param("brandId")Integer brandId,
                                                              @Param("productId") Integer productId,
                                                              @Param("date") Instant date);


}
