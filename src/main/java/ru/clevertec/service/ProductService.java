package ru.clevertec.service;

import ru.clevertec.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> read(List<Long> id, List<Long> amount);
}
