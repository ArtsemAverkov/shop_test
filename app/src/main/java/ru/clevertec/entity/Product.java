package ru.clevertec.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Optional;


@Data
@Accessors(chain = true)
public class Product {
    private Long id;
    private  String name;
    private  Long price;
    private  Long amount;
    private MetaInf metaInf;

    public Optional<MetaInf> getMetaInf(){
        return Optional.ofNullable(metaInf);
    }


    @Override
    public String toString() {
        return '\n' + "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", metaInf=" + metaInf;
    }


}
