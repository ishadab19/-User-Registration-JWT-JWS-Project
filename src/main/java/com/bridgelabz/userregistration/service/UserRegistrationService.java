package com.bridgelabz.userregistration.service;


import com.bridgelabz.userregistration.dto.UserLoginDTO;
import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import com.bridgelabz.userregistration.model.EmailModel;
import com.bridgelabz.userregistration.model.UserRegistrationData;
import com.bridgelabz.userregistration.repository.IUserRegistrationRepository;
import com.bridgelabz.userregistration.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserRegistrationService implements IUserRegistrationService {
    @Autowired
    private IUserRegistrationRepository iUserRegistrationRepository;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IEmailService iEmailService;


    private List<UserRegistrationData> addData = new ArrayList<>();


    /**
     * Method :- Method for User Login.
     */
    @Override
    public String loginUser(UserLoginDTO userLoginDTO) {
        UserRegistrationData userData = null;
        userData = new UserRegistrationData(userLoginDTO);
        String token = tokenUtil.createToken(userData.getUserId());
        EmailModel emailModel = new EmailModel(userData.getEmailId(), "Successfully", "This is your Token" + token);
        iEmailService.sendEmail(emailModel);
        log.info("LoginUser Service Method Successfully executed");
        String message = "Logged in Successfully!! Your token is : " + token;
        return message;
    }

    /**
     * Method :- Method to Get All User Records.
     */
    @Override
    public List<UserRegistrationData> getUserInfo() {
        log.info("getUserInfo Service Method Successfully executed");
        return iUserRegistrationRepository.findAll();
    }

    /**
     * Method :- Method for User Registration.
     */
    @Override
    public UserRegistrationData registerUser(UserRegistrationDTO userDTO) {
        UserRegistrationData userData = new UserRegistrationData(userDTO);
        String encodedPassword = bCryptPasswordEncoder.encode(userData.getPassword());
        userData.setPassword(encodedPassword);
        EmailModel emailModel = new EmailModel(userData.getEmailId(), "Account Registration", "Your Account Registration is Successfully Done..!!");
        iEmailService.sendEmail(emailModel);
        log.info("registerUser Service Method Successfully executed");
        iUserRegistrationRepository.save(userData);
        return userData;
    }
}
