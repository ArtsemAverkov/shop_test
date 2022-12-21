package ru.clevertec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrintCheckDto {
    private LocalDate localDate = LocalDate.now();
    private long id;
    private String name;
    private double price;
    private int amount;
    private double sum;

    @Override
    public String toString() {
        return "localDate=" + localDate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", sum=" + sum +
                '}';
    }
}
