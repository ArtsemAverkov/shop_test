package ru.clevertec.check;

import lombok.Data;
import ru.clevertec.entity.Product;
import ru.clevertec.parser.Parser;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Data
public class Checks {
    public List<Product> checkСounting (List<Product> productList){
        final Consumer<Product> productConsumer = products ->
                Comparator.naturalOrder();


            productList.stream()
                    .peek(productConsumer)
                    .peek(product -> {
                        Long amount = product.getAmount();
                        Long price = product.getPrice();
                        product.setPrice(price * amount);
                    })
                    .forEach(productConsumer);

        List<Product> collect = productList.stream()
                .filter(product -> product.getMetaInf().get().isDiscount())
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        if (Objects.nonNull(Parser.getDiscount)) {
            collect.stream()
                    .peek(productConsumer)
                    .peek(product -> {
                        Long price = product.getPrice();
                        product.setPrice((price * 10));
                    })
                    .forEach(productConsumer);
        }

        return productList;

    }
}
