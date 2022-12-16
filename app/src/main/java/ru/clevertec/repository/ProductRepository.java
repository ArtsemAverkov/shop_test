package ru.clevertec.repository;

import ru.clevertec.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> read(List<Long> id, List<Long> amount);
}
