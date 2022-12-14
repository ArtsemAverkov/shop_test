package ru.clevertec.utill;


import ru.clevertec.entity.MetaInf;
import ru.clevertec.entity.Product;
import ru.clevertec.entity.Shop;

import java.time.LocalDate;
import java.util.List;


public class ProductUtils {
    public static List<Product> createProduct(){
        List<Product> products = List.of(
                new Product()
                        .setId(1L)
                        .setName("banana")
                        .setPrice(2L)
                        .setAmount(500L)
                        .setMetaInf(new MetaInf()
                                .setDiscount(true)
                                .setExpirationDate(LocalDate.parse("2022-06-08"))
                                .setShopList(List.of(
                                        Shop.ALMI,
                                        Shop.DVA_GUSIA
                                ))
                        ),
                new Product()
                        .setId(2L)
                        .setName("apple")
                        .setPrice(1L)
                        .setAmount(500L)
                        .setMetaInf(new MetaInf()
                                .setDiscount(false)
                                .setExpirationDate(LocalDate.parse("2022-06-08"))
                                .setShopList(List.of(
                                        Shop.EVROOPT,
                                        Shop.DVA_GUSIA,
                                        Shop.KOPEECHKA
                                ))
                        ),
                new Product()
                        .setId(4L)
                        .setName("lemon")
                        .setPrice(4L)
                        .setAmount(100L)
                        .setMetaInf(new MetaInf()
                                .setDiscount(false)
                                .setExpirationDate(LocalDate.parse("2022-10-10"))
                                .setShopList(List.of(
                                        Shop.ALMI,
                                        Shop.KOPEECHKA
                                ))
                        ),
                new Product()
                        .setId(3L)
                        .setName("bread")
                        .setPrice(1L)
                        .setAmount(300L)
                        .setMetaInf(new MetaInf()
                                .setDiscount(true)
                                .setExpirationDate(LocalDate.parse("2022-05-25"))
                                .setShopList(List.of(
                                        Shop.KOPEECHKA
                                ))
                        )
        );
        return products;
    }

}
