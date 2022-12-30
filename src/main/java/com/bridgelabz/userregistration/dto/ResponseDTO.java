package com.bridgelabz.userregistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor

public class ResponseDTO {
    private String message;
    private Object data;

//    public ResponseDTO(String message, Object data) {
//        this.message = message;
//        this.data = data;
   // }


}
