package ru.clevertec.createCheck;

import ru.clevertec.entity.Product;

import java.util.List;

public interface Create {
    void createInFile(List<Product> productList, List<Double> allSum, List<Double> discount);
}
