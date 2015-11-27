/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pucp.sw2.proyecto.etesis0891.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Alejandra
 */
public class TelefonoValidator implements ConstraintValidator<Telefono, String>{

    @Override
    public void initialize(Telefono paramA) {
    }

    @Override
    public boolean isValid(String telefValue, ConstraintValidatorContext ctx) {
        if(telefValue==null){
            return false;
        }
        else if (telefValue.matches("\\d{10}"))
            return true;
        else if(telefValue.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        //validating phone number where area code is in braces ()
        else if(telefValue.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
        //return false if nothing matches the input
        else return false;
    }
    
}
