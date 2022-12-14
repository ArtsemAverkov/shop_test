package ru.clevertec.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class MetaInf {
    private LocalDate expirationDate;
    private boolean isDiscount;
    private List<Shop> shopList;


    public Optional<List<Shop>> getShopList(){
        return Optional.of(shopList);
    }
}
