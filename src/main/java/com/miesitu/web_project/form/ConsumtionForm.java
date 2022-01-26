package com.miesitu.web_project.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ConsumtionForm {
    @Positive(message = "Amount must be greater than 0")
    public float amount;

    @NotNull(message = "Unknown error, please try again")
    public int productId;

    private java.util.Date date = new java.util.Date();

}
