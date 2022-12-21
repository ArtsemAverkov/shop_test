package ru.clevertec.parser;

import ru.clevertec.dto.ProductDto;

import java.util.List;

public interface Parser {
    List<ProductDto> parserInConsole(String response);
}
