package ru.clevertec.check;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.entity.Product;
import ru.clevertec.parser.Parser;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checks implements ChechI {
    public double allSum = 0.0;
    public List<Product> checkСounting(List<Product> productList) {
        final Consumer<Product> productConsumer = products ->
                Comparator.naturalOrder();
        productList.stream()
                .peek(productConsumer)
                .peek(product -> {
                    Long amount = product.getAmount();
                    double price = product.getPrice();
                    product.setSum(price * amount);
                })
                .forEach(productConsumer);


       sumAll(productList);


        getDiscount(productList, productConsumer);
        return productList;
    }

    private void sumAll (List<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            double sum = productList.get(i)
                    .getSum();
            allSum += sum;
        }
    }

    public void getDiscount(List<Product> productList, Consumer<Product> productConsumer) {
        List<Product> collect = productList.stream()
                .filter(product -> product.getMetaInf().get().isDiscount())
                .collect(Collectors.toList());

        if (Objects.nonNull(Parser.getDiscount)) {
            if (collect.size() >= 5) {
                collect.stream()
                        .peek(productConsumer)
                        .peek(product -> {
                            double sum = product.getSum();
                            product.setSum((sum * 0.9));
                        })
                        .forEach(productConsumer);
            }
        }
    }

    public Double getSumAfterDiscounter(List<Product> productList) {
        double allSum = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            double sum = productList.get(i)
                    .getSum();
            allSum += sum;
        }
        return allSum;
    }

}