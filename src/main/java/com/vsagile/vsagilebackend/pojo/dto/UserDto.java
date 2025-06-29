package com.vsagile.vsagilebackend.pojo.dto;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.vsagile.vsagilebackend.pojo.User}
 */
@Value
public class UserDto implements Serializable {
    Integer id;
    @Size(max = 255)
    String userName;
    @Size(max = 255)
    String password;
    @Size(max = 255)
    String nickname;
    @Size(max = 255)
    String email;
    Integer role;
}