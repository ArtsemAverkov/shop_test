package ru.clevertec.common.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.clevertec.entity.Product;
import ru.clevertec.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    private Parser parser;

    public ParserTest(Parser parser) {
        this.parser = parser;
    }
    @Test
    void parserInConsoleTest(){
        Product product = new Product();
        product.setId(1L);
        product.setName("apple");
        product.setAmount(1L);
        product.setPrice(23);

        Product productSecond = new Product();
        product.setId(3L);
        product.setName("apple");
        product.setAmount(4L);
        product.setPrice(17);
        List<Product> list = new ArrayList<>();
        list.add(product);
        list.add(productSecond);
        String parameter = "1-1" + '\n'  + "3-4";
        Assertions.assertEquals(parser.parserInConsole(parameter), list);
    }
}
