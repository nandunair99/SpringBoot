package com.narola.testspringboot.medicine.validation;

import com.narola.testspringboot.model.Medicine;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.time.LocalDate;

@Component
public class MedicineValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Medicine.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
            Medicine medicine=(Medicine)target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"medicineName","medicine.name.empty");
            //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cost","medicine.price.empty");
            //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"discount","medicine.discount.empty");
            //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mfgDate","medicine.mfgdate.empty");
            //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"expDate","medicine.expdate.empty");

            if(medicine.getCost()<=0.0)
            {
                errors.rejectValue("cost","medicine.price.invalid");
            }
            if(medicine.getDiscount()<=0.0)
            {
                errors.rejectValue("discount","medicine.discount.invalid");
            }

    }
}
