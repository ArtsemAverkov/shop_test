package ru.clevertec.common.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.clevertec.entity.Product;
import ru.clevertec.repository.ProductRepository;

import java.util.Collections;


public class RepositoryTest {
    private ProductRepository productRepository;

    public RepositoryTest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Test
    void readTestValidProduct (){
        Product product = new Product();
        product.setId(1L);
        product.setName("apple");
        product.setAmount(2L);
        product.setPrice(23);
        Assertions.assertEquals(productRepository.read(Collections.singletonList(product.getId()),
                Collections.singletonList(product.getAmount())), product);
    }
}
