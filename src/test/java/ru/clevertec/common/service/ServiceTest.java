package ru.clevertec.common.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.clevertec.common.extension.ValidParameterResolverProduct;
import ru.clevertec.entity.Product;
import ru.clevertec.repository.ProductRepository;
import ru.clevertec.service.ProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Nested
@ExtendWith(ValidParameterResolverProduct.class)
public class ServiceTest {
    private ProductService productService;

    public ServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Mock
    private ProductRepository productRepository;

    @RepeatedTest(1)
    void readProductService(){
        Product product = new Product();
        product.setId(1L);
        product.setName("apple");
        product.setAmount(2L);
        product.setPrice(23);
        List<Product> list = new ArrayList<>();
        list.add(product);


        Mockito.when(productRepository.read(Collections.singletonList(product.getId()),
                Collections.singletonList(product.getAmount()))).thenReturn(list);
        Assertions.assertEquals(Optional.of(list), productService.read(Collections.singletonList(product.getId()),
                Collections.singletonList(product.getAmount())));
    }

}
