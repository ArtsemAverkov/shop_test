package ru.clevertec.service;

import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> read(ProductDto id);
}
