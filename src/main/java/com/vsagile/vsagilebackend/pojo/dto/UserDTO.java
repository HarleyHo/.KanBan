package com.vsagile.vsagilebackend.pojo.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * DTO for {@link com.vsagile.vsagilebackend.pojo.po.User}
 */
@AllArgsConstructor
@Getter
@ToString
public class UserDTO implements Serializable {
    private final Integer id;
    @Size(max = 255)
    private final String name;
    @Size(max = 255)
    private final String password;
    @Size(max = 255)
    private final String email;
    private final Integer role;
    @Size(max = 100)
    private final String iconUrl;
}