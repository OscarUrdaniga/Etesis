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
public class CodigoValidator implements ConstraintValidator<Codigo, String>{

    @Override
    public void initialize(Codigo paramA) {
    }

    @Override
    public boolean isValid(String codigoValue, ConstraintValidatorContext ctx) {
        if(codigoValue==null || codigoValue.trim().length()==0 || codigoValue.trim().length()>8)
            return false;
        else if (codigoValue.matches("\\d{10]"))
            return true;
        else return false;
    }
    
    
    
}
