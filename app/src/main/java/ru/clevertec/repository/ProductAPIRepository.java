package ru.clevertec.repository;


import ru.clevertec.entity.Product;
import ru.clevertec.utill.ProductUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductAPIRepository implements ProductRepository {
    private final List<Product> product = ProductUtils.createProduct();
    @Override
    public List<Product> read(List<Long> id, List<Long> amount) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            int finalI = i;
            Stream<Product> productStream = product.stream()
                    .filter(product1 -> Objects.equals(product1.getId(), id.get(finalI)));
            List<Product> collect = productStream
            .collect(Collectors.toList());
                if (collect.size()!=0) {
                    productList.addAll(collect);
                }else {
                    System.out.println("По Id "+id.get(finalI) +" товара не найдено");
                }
        }
        List<Product> finalList = setAmount(productList, amount);
        return finalList;
    }



    public List<Product> setAmount(List<Product> list, List<Long> amount){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            product.setAmount(amount.get(i));
             productList.add(product);
        }
        return productList;
    }
}


