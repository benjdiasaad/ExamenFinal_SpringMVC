package com.humains.validators;

import com.humains.entities.Employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustumePassword implements ConstraintValidator<PasswordConf, Employee>{

    @Override
    public void initialize(PasswordConf constraintAnnotation) {

    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext constraintValidatorContext) {
        return employee.getPassword().equals(employee.getConfirmedPassword());
    }

    /*
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirmedPassword());
        return user.getPassword().equals(value.getPasswordRepeat())
    }*/
}
