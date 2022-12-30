package com.bridgelabz.userregistration.controller;

import com.bridgelabz.userregistration.dto.ResponseDTO;
import com.bridgelabz.userregistration.dto.UserLoginDTO;
import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationData;
import com.bridgelabz.userregistration.service.EmailService;
import com.bridgelabz.userregistration.service.IUserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userregistration")
@Slf4j
public class UserRegistrationController {
    @Autowired
    private IUserRegistrationService service;
    @Autowired
    private EmailService emailService;

    /**
     * Method :- Method for User Login.
     *
     * @param :- passing UserLoginDTO as Input
     * @return :- Returning Token.
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(
            @RequestBody UserLoginDTO userLoginDTO) {
        log.info("inside userLogin Controller Method");
        ResponseDTO responseDTO = new ResponseDTO("User Logged In Successfully..!!",
                service.loginUser(userLoginDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method for User Registration.
     *
     * @param userDTO :- passing UserRegistrationDTO as Input
     * @return :- Returning UserData
     */

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(
            @Valid @RequestBody UserRegistrationDTO userDTO) {
        UserRegistrationData userData = service.registerUser(userDTO);
        log.info("inside registerUser Controller Method");
        ResponseDTO responseDTO = new ResponseDTO("User Added Successfully", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Get All User Records.
     *
     * @return :- Returning  All User Records Present in Database.
     */
    @GetMapping("/getUserInfo")
    public ResponseEntity<ResponseDTO> getUserInfo() {
        List<UserRegistrationData> userDataList = null;
        userDataList = service.getUserInfo();
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info", userDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


}
