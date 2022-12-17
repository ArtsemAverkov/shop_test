package ru.clevertec.createCheck;


import lombok.NoArgsConstructor;
import ru.clevertec.entity.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@NoArgsConstructor
public class CreateCheckInFile implements Create{
    @Override
    public void createInFile(List<Product> productList, List<Double> allSum, List<Double> discount) {
        try{
            FileWriter writer = new FileWriter("app/src/main/resources/check.txt");

            for(Product line : productList)
            {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));

            }
            for(Double line : allSum)
            {
                writer.write(String.valueOf("Sum :" + line));
                writer.write(System.getProperty("line.separator"));

            }
            for(Double line : discount)
            {
                writer.write(String.valueOf("Sum After Discount :" + line));
                writer.write(System.getProperty("line.separator"));
            }
            writer.close();
        }catch (IOException ex){ex.printStackTrace();}

    }
}
