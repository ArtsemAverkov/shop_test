package ru.clevertec.common.check;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.clevertec.check.Checks;
import ru.clevertec.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CheckTest {
    private Checks checks;

    public CheckTest(Checks checks) {
        this.checks = checks;
    }

    @Test
    void checkCountingTest(){
        Product product = new Product();
        product.setId(1L);
        product.setName("apple");
        product.setAmount(2L);
        product.setPrice(23);
        List<Product> list = new ArrayList<>();
        list.add(product);
        Product resultProduct = new Product();
        product.setId(1L);
        product.setName("apple");
        product.setAmount(2L);
        product.setPrice(46);
        List<Product> resultList = new ArrayList<>();
        resultList.add(resultProduct);
        Assertions.assertEquals(checks.checkCounting(list), resultList);
    }

    @Test
    void getSumAfterDiscounterTest(){
        Product product = new Product();
        product.setId(1L);
        product.setName("apple");
        product.setAmount(2L);
        product.setPrice(23);

        Product productSecond = new Product();
        product.setId(1L);
        product.setName("apple");
        product.setAmount(2L);
        product.setPrice(17);
        final double sum = 40;
        List<Product> list = new ArrayList<>();
        list.add(product);
        list.add(productSecond);
        Assertions.assertEquals(checks.getSumAfterDiscounter(list), sum);
    }
}
