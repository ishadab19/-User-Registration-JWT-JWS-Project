package com.bridgelabz.userregistration.service;

import com.bridgelabz.userregistration.model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService  implements IEmailService{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailModel emailModel) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("me.shadab19@gmail.com");
        message.setTo(emailModel.getTo());
        message.setText(emailModel.getBody());
        message.setSubject(emailModel.getSubject());
        mailSender.send(message);
        System.out.println("Mail sent successfully..");
        
    }
}
