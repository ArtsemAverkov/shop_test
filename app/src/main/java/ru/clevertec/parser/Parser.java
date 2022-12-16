package ru.clevertec.parser;

import ru.clevertec.dto.ProductDto;


import java.util.*;



public class Parser {
    ArrayList<ProductDto> stringArray = new ArrayList<>();
    List<String> listArray = new ArrayList<>();
    public static String getDiscount = null;
    private final static String DISCOUNT = "swee-1111";


    public ArrayList<ProductDto> parser(String response) {
        Scanner scanner = new Scanner(response);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            List<String> strings = Arrays.asList(split);
            int size = strings.size();

            for (int i = 0; i < size; i++) {
                String s1 = strings.get(i);
                listArray.add(s1);
            }
            if (s.equals(DISCOUNT)) {
                idDiscount();
            }
        }
        addProductDtos();
        System.out.println("stringArray Parser = " + stringArray);
        return stringArray;
        }

    private void idDiscount () {
        String s = listArray.get(listArray.size()-1);
        getDiscount=s;
                listArray.remove(listArray.size()-1);
            }

    private void addProductDtos () {
        for (int i = 0; i < listArray.size(); i++) {
            String split = listArray.get(i);
            String[] splitResult = split.split("-");
            List<String> asList = Arrays.asList(splitResult);
            stringArray.add(ProductDto.builder()
                    .id(Long.valueOf((asList.get(0))))
                    .amount(Long.valueOf((asList.get(1))))
                    .build());
            System.out.println("stringArray = " + stringArray);
        }
    }
}


