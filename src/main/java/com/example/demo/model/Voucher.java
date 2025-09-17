package com.example.demo.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class Voucher{

    @NotBlank(message="Código é requerido")
    @Pattern(regexp="^[A-Z0-9]{4,10}$", message = "Código precisa ter entre 4 e 10 letras maiúsculas e números")
    private String code;

    @NotNull(message = "Tipo é requerido")
    private String type;

    @NotNull(message = "Valor é requerido")
    @Positive(message = "Precisa ser positivo")
    private BigDecimal value;

    @NotNull(message = "Valor é requerido")
    @Min(value = 0, message = "Não pode ser negativo")
    private BigDecimal minimumPuchase;

    @NotNull(message = "Valor é requirido")
    @Future(message = "Expiração precisa ser futura")
    private LocalDateTime expirationDate;

    @NotNull(message = "Limite é requerido")
    @Min(value = 0, message = "Precisa ser ao menos 1")
    private Integer usageLimit;

    private Integer usageCount = 0;
    

    // @NotBlank(message = "Name is required")
    // private String name;

    // @NotNull(message = "Price is required")
    // @Positive(message = "Price must be positive")
    // private Double desconto;

    // private LocalDate validade;

    // private String valido;

    public boolean isActive(){
        var now = LocalDate.now();
        return now < expirationDate;
    }

}