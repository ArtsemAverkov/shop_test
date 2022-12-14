package ru.clevertec.parser;

import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Product;

import java.util.*;

public class Parser {
    ArrayList<ProductDto> stringArray = new ArrayList<>();

    public ArrayList<ProductDto> parser(String response) {
        Scanner scanner = new Scanner(response);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (Objects.nonNull(s)) {
                String[] split = s.split("-");
                List<String> stringList = Arrays.asList(split);
                stringArray.add( ProductDto.builder()
                                .id(Long.valueOf((stringList.get(0))))
                                .amount(Long.valueOf((stringList.get(1))))
                        .build());
            }
        }
        return stringArray;
    }
}
