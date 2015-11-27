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
public class CorreoValidator implements ConstraintValidator<Correo, String>{

    @Override
    public void initialize(Correo paramA) {
    }

    @Override
    public boolean isValid(String CorreoValue, ConstraintValidatorContext ctx) {
        if(CorreoValue==null)
            return false;
        if(CorreoValue.matches("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*([A-Za-z]{2,])$")){
            return true;
        }
        return false;
    }        
}
