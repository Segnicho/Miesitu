package com.miesitu.web_project.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ConsumtionForm {
    @NotNull(message = "Error, amount cannot be empty")
    public float amount;

    @NotNull(message = "Unknown error, please try again")
    public int productId;

    private java.util.Date date = new java.util.Date();

}
