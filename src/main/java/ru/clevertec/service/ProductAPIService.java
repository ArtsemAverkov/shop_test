package ru.clevertec.service;

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
    public List<Product> read(List<Long> id, List<Long> amount) {
        return productRepository.read(id, amount);
    }
}
