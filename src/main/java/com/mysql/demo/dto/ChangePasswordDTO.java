package com.mysql.demo.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChangePasswordDTO extends UserDTO{
    @NotBlank
    private String newPassword;
}
