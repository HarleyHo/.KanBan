package com.vsagile.vsagilebackend.pojo.vo;

import com.vsagile.vsagilebackend.pojo.po.User;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserVO implements Serializable {
    private final Integer id;
    @Size(max = 255)
    private final String name;
    @Size(max = 255)
    private final String email;
    private final Integer role;
    @Size(max = 100)
    private final String iconUrl;
}