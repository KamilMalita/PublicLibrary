package com.library.govLibrary.validator;

import com.library.govLibrary.model.Author;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AuthorValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Author.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Author author = (Author) o;
        if(author.getName().length() < 3){
            errors.reject("name", "Name is too short. Minimal length is 3.");
        }
    }
}
