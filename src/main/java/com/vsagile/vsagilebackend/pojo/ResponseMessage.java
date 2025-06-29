package com.vsagile.vsagilebackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseMessage<T> {
    private Integer status;
    private String msg;
    private T data;

    public static <T> ResponseMessage<?> success(T data){
        return new ResponseMessage<>(HttpStatus.OK.value(), "OK", data);
    }

    public static <T> ResponseMessage<?> success(){
        return new ResponseMessage<>(HttpStatus.OK.value(), "OK", "null");
    }
}
