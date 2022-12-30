package com.bridgelabz.userregistration.service;

import com.bridgelabz.userregistration.dto.ResponseDTO;
import com.bridgelabz.userregistration.model.EmailModel;
import org.springframework.http.ResponseEntity;

public interface IEmailService {

    public void sendEmail(EmailModel emailModel);
}
