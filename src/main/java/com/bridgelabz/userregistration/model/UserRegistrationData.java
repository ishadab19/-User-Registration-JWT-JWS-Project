package com.bridgelabz.userregistration.model;
import com.bridgelabz.userregistration.dto.UserLoginDTO;
import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_registration")
public class UserRegistrationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")
    private int userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;

//    public UserRegistrationData() {
//
//    }

    public UserRegistrationData(UserRegistrationDTO userRegistrationDTO) {
        this.firstName = userRegistrationDTO.firstName;
        this.lastName = userRegistrationDTO.lastName;
        this.emailId = userRegistrationDTO.emailId;
        this.password = userRegistrationDTO.password;
    }

    public UserRegistrationData(UserLoginDTO userLoginDTO) {
        this.emailId = userLoginDTO.emailId;
        this.password = userLoginDTO.password;
    }


}
