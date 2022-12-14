package ru.clevertec.view;


import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Product;
import ru.clevertec.parser.Parser;
import ru.clevertec.service.ProductAPIService;
import ru.clevertec.service.ProductService;

import java.util.*;


public class StoreView implements View {
    private ProductService productService;
    Parser parser = new Parser();
    public StoreView() {
       productService = new ProductAPIService();
    }

    @Override
    public void start(String response) {
        ArrayList<ProductDto> parser = this.parser.parser(response);
        List<Product> read = productService.read(parser.get(0));
        System.out.println("read = " + read);

    }
    }

