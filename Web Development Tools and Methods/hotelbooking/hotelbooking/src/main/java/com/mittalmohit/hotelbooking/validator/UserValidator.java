package com.mittalmohit.hotelbooking.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mittalmohit.hotelbooking.pojo.User;

public class UserValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAccount.userName", "error.invalid.userAccount.userName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAccount.password", "error.invalid.userAccount.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.phoneNumber", "Phone Number Required");
    }
    
    public void validateLoginCredentials(Object obj, Errors errors)
    {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAccount.userName", "error.invalid.userAccount.userName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAccount.password", "error.invalid.userAccount.password", "Password Required");       
    }
}
