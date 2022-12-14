package ru.clevertec.parser;

import ru.clevertec.dto.ProductDto;
import ru.clevertec.entity.Discount;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParserInConsole implements Parser{
    ArrayList<ProductDto> stringArray = new ArrayList<>();
    List<String> listArray = new ArrayList<>();
    public static String getDiscount = null;
    private final String pattern = "(\\bC)";
    private final Pattern ptrn = Pattern.compile(pattern);

    @Override
    public ArrayList<ProductDto> parserInConsole (String response) {
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
            searchDiscount(s);
        }
        addProductDtos();
        return stringArray;
    }

    private void searchDiscount(String s) {
        Matcher matcher = ptrn.matcher(s);
        if (matcher.find()) {
            if (Objects.equals(s,Discount.CARD_1111.toString())) {
                idDiscount();
            }else {
                listArray.remove(listArray.size() - 1);
                System.out.println("No such card\n" +
                        " Please upload the card in CARD_xxxx format");
            }
        }
    }

    private void idDiscount (){
            String s = listArray.get(listArray.size() - 1);
            getDiscount = s;
            listArray.remove(listArray.size() - 1);
        }

    private void addProductDtos () {
        try {
            for (int i = 0; i < listArray.size(); i++) {
                String split = listArray.get(i);
                String[] splitResult = split.split("-");
                List<String> asList = Arrays.asList(splitResult);
                stringArray.add(ProductDto.builder()
                        .id(Long.valueOf((asList.get(0))))
                        .amount(Long.valueOf((asList.get(1))))
                        .build());
            }
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException ofBoundsException){
            System.out.println("You entered an invalid value\n" +
                    " enter a value in the format 1-1/id-amount");

        }
    }
}


