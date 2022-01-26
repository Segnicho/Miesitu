package com.miesitu.web_project.form;


import javax.validation.constraints.*;



import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class SignUpForm {
    @NotEmpty(message = "Frist name field cannot be empty")
    @NotNull
    @Size(min= 4, message ="Frist name should be more than 4 characters")
    private String fristName;

    @Size(min= 4, message ="Last name should be more than 4 characters")
    @NotEmpty(message = "Last name field cannot be empty")
    @NotNull
    private String lastName;
    @Email
    @Nullable
    private String email;

    @NotNull(message = "phone number field cannot be empty")
    private int phone;

    @Size(min =  8 , message = "Password should be at least 8 characters long")
    @NotEmpty(message = "Password field cannot be empty")
    @NotNull
    private String password;

    @Size(min =  8 , message = "Password should be at least 8 characters long")
    @NotEmpty(message = "Password field cannot be empty")
    @NotNull
    private String Confirm_Password;

    @AssertTrue(message = "Password Doesnot Match")
    private boolean passwordMatches = true;// passwordChecker(this.getPassword(), this.getConfirm_Password());

    @NotNull
    private String area;

    @NotNull
    private int code;
    @NotNull
    private String userName="Hello User";
}
