package com.bridgelabz.userregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailModel {
    private String to;
    private String subject;
    private String body;
}
