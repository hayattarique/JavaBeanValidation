package com.jbva.validator;

import com.jbva.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null||value.length()<10||value.length()>12){
            return false;
        }
        return value.chars().allMatch(ch->Character.isDigit(ch));
    }

}
