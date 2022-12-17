package ru.clevertec.entity;


import lombok.Data;
import lombok.experimental.Accessors;
import org.decimal4j.util.DoubleRounder;


import java.time.LocalDate;
import java.util.Optional;


@Data
@Accessors(chain = true)
public class Product {
    private LocalDate localDate = LocalDate.now();
    private Long id;
    private  String name;
    private  double price;
    private  Long amount;
    private double sum;
    private MetaInf metaInf;

    public Optional<MetaInf> getMetaInf(){
        return Optional.ofNullable(metaInf);
    }


    @Override
    public String toString() {
        return  '\n' +"data :" + localDate +
                ", id: " + id +
                ", name :'" + name + '\'' +
                ", price :" + price +
                ", amount :" + amount +
                ", sum :" + sum +'\n' +
                " metaInf :" + metaInf;
    }


}
