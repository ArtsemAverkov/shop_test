package ru.clevertec.check;

import ru.clevertec.dto.PrintCheckDto;
import ru.clevertec.entity.Product;

import java.util.List;
import java.util.function.Consumer;

public interface ChechI {
    List<Product> checkСounting (List<Product> productList);

}
