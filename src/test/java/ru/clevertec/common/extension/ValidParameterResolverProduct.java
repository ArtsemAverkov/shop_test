package ru.clevertec.common.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.MetaInf;
import ru.clevertec.entity.Product;
import ru.clevertec.entity.Shop;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class ValidParameterResolverProduct implements ParameterResolver {

     public static List<Product> productsVali = List.of(
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
                        .setId(3L)
                        .setName("tomato")
                        .setPrice(2.2)
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
                        .setId(4L)
                        .setName("cherry")
                        .setPrice(1.7)
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
                        .setId(5L)
                        .setName("water")
                        .setPrice(4.6)
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
                        .setId(6L)
                        .setName("banana")
                        .setPrice(3.1)
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
                        .setId(7L)
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
                        .setId(8L)
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
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType()==ProductDto.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return productsVali.get(new Random().nextInt(productsVali.size()));
    }
}
