package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.time.LocalDate;


@Data
public class Voucher{
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double desconto;

    @NotNull(message = "Tipo is required")
    private String tipo;

    private LocalDate validade;

    private String valido;

    public boolean isActive(){
        var now = LocalDate.now();
        return now < validade;
    }

}