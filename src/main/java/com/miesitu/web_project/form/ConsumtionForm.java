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
    @NotNull
    public float amount;

    @NotNull
    public int productId;

    private java.util.Date date = new java.util.Date();

}
