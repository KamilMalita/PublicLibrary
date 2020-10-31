package com.library.govLibrary.validation;

import com.library.govLibrary.model.Author;
import com.library.govLibrary.model.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Users.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", "username.empty");
        Users user = (Users) o;
        if (user.getUsername().equals(""))
            errors.reject("username");
    }
}
