package ru.clevertec.service;

import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Product;
import ru.clevertec.repository.ProductAPIRepository;
import ru.clevertec.repository.ProductRepository;

import java.util.List;

public class ProductAPIService implements ProductService{
    private ProductRepository productRepository;

    public ProductAPIService() {
       productRepository = new ProductAPIRepository();
    }

    @Override
    public List<Product> read(ProductDto id) {
        return productRepository.read(id);
    }
}
