package ru.clevertec.view;


import ru.clevertec.check.Checks;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Product;
import ru.clevertec.parser.Parser;
import ru.clevertec.service.ProductAPIService;
import ru.clevertec.service.ProductService;

import java.util.*;
import java.util.stream.Collectors;


public class StoreView implements View {
    private ProductService productService;
    Parser parser = new Parser();
    Checks check = new Checks();
    public StoreView() {
       productService = new ProductAPIService();
    }

    @Override
    public void start(String response) {
        ArrayList<ProductDto> parser = this.parser.parser(response);
        List<Long> longList = parser.stream()
                .map(ProductDto::getId)
                .collect(Collectors.toList());

        List<Long> collectAmount = parser.stream()
                .map(ProductDto::getAmount)
                .collect(Collectors.toList());

        List<Product> read = productService.read(longList, collectAmount);
        System.out.println("read = " + read);

        List<Product> checkСounting = check.checkСounting(read);
        System.out.println("checkСounting = " + checkСounting);
    }
    }

