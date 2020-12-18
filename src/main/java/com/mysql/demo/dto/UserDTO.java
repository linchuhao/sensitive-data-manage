package com.mysql.demo.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank
    @Valid
    private String username;
    @NotBlank
    private String password;
}
