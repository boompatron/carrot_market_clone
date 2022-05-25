package com.carrot_market.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberFormDto {
    @NotBlank(message = "name is necessary")
    private String name;

    @NotEmpty(message = "email is necessary")
    @Email(message = "please give us an email format")
    private String email;

    @NotEmpty(message = "password is necessary")
    @Length(min = 8, max = 16, message = "password length should be between 8 to 16")
    private String password;

    @NotEmpty(message = "address is necessary")
    private String address;
}
