package net.zamora.prices.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "price")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prices {

    @EmbeddedId
    private PricesPk pricesPk;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price", columnDefinition = "NUMERIC(5,2)")
    private Float price;

    @Column(name = "curr")
    private String currency;

}
