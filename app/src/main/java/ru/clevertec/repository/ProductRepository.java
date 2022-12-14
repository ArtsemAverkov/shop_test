package ru.clevertec.repository;

import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> read(ProductDto id);
}
