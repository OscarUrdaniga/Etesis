/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.validator;

import static java.awt.PageAttributes.MediaType.A;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Alejandra
 */
public class PasswordValidator implements ConstraintValidator<Password, String>{

    @Override
    public void initialize(Password paramA) {
    }

    @Override
    public boolean isValid(String passValue, ConstraintValidatorContext ctx) {
        if(passValue==null)
            return false;       
        else if (passValue.contains("[A-Z]"))
        return true;
        else if (passValue.contains("d{10}"))
            return true;
        else return false;
    }
    
}
