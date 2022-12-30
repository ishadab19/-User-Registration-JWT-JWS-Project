package com.bridgelabz.userregistration.repository;

import com.bridgelabz.userregistration.model.UserRegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRegistrationRepository extends JpaRepository<UserRegistrationData,Integer> {

    //@Query(value = "select * from user_registration where email_id = :emailId", nativeQuery = true)
}
