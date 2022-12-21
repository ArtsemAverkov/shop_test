package ru.clevertec.view;

import ru.clevertec.check.Checks;
import ru.clevertec.createCheck.Create;
import ru.clevertec.createCheck.CreateCheckInFile;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Product;
import ru.clevertec.parser.Parser;
import ru.clevertec.parser.ParserInConsole;
import ru.clevertec.service.ProductAPIService;
import ru.clevertec.service.ProductService;

import java.util.*;
import java.util.stream.Collectors;

public class StoreView implements View {
    private final Create createCheckInFile;
    private final ProductService productService;
    private final Parser parser;
    private final Checks checks = new Checks();
    public StoreView() {
       productService = new ProductAPIService();
        createCheckInFile = new CreateCheckInFile();
        parser = new ParserInConsole();
    }

    @Override
    public void start(String response) {
        List<ProductDto> productDtos = parser.parserInConsole(response);
        List<Long> longList = productDtos.stream()
                .map(ProductDto::getId)
                .collect(Collectors.toList());

        List<Long> collectAmount = productDtos.stream()
                .map(ProductDto::getAmount)
                .collect(Collectors.toList());

        List<Product> read = productService.read(longList, collectAmount);
        List<Product> productList = checks.checkCounting(read);
        System.out.println("Check " + productList);
        Double allSum = checks.getAllSum();
        System.out.println("Sum : " + allSum);
        Double sumAfterDiscounter = checks.getSumAfterDiscounter(productList);
        System.out.println("sum After Discounter : " + sumAfterDiscounter);

        createCheckInFile.createInFile(productList,
                Collections.singletonList(allSum),
                Collections.singletonList(sumAfterDiscounter));



    }
}

