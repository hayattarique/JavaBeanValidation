package com.jbva.test;

import com.jbva.beans.Customer;
import com.jbva.group.DemographicGroup;
import com.jbva.group.LoanInfoGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.time.LocalDate;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        Customer customer = Customer.builder().firstName("Hayat").
                lastName("Tariq").dob(LocalDate.now().minusYears(20)).
                emailAddress("takram403@gmail.com").gender("Male").mobileNo("7970325605").build();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer, DemographicGroup.class);
        violations.forEach(violation -> {
            System.out.println(violation.getMessage());
        });


    }
}
