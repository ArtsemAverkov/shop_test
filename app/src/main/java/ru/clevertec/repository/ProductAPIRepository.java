package ru.clevertec.repository;


import ru.clevertec.entity.Product;
import ru.clevertec.utill.ProductUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProductAPIRepository implements ProductRepository {


    @Override
    public List<Product> read(List<Long> id, List<Long> amount) {
        List<Product> product = ProductUtils.createProduct();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            int finalI = i;
                List<Product> collect = product.stream()
            .filter(product1 -> Objects.equals(product1.getId(), id.get(finalI)))
            .collect(Collectors.toList());
               productList.addAll(collect);
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


