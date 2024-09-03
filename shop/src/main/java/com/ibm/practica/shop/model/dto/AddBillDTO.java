package com.ibm.practica.shop.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBillDTO {

    @NotNull
    private Float cost;
    @NotNull
    private String description;
}
