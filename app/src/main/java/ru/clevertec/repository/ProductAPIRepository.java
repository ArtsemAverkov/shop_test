package ru.clevertec.repository;


import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Product;
import ru.clevertec.utill.ProductUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductAPIRepository implements ProductRepository {


    @Override
    public List<Product> read(ProductDto id) {
        List<Product> product = ProductUtils.createProduct();
        List<Product> collect = product.stream()
                .filter(product1 -> Objects.equals(product1.getId(), id.getId()))
                .collect(Collectors.toList());
        return collect;
    }
}
