package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        //Create code to make sure inventory is between mix and max value
        if (part.getInv() > part.getMaxInv()){
            //display error message when inventory is greater than the max inventory
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Too much inventory for part: " + part.getName()).addConstraintViolation();
            return false;
        }
        else if (part.getInv() < part.getMinInv()){
            //display error message when inventory is greater than the max inventory
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Insufficient inventory for part: " + part.getName()).addConstraintViolation();
            return false;
        }
        else {
            return true;
        }
    }
}
