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
public class DNIValidator implements ConstraintValidator<Codigo, String>{

    @Override
    public void initialize(Codigo paramA) {
    }

    @Override
    public boolean isValid(String codigoValue, ConstraintValidatorContext ctx) {
        if(codigoValue==null || codigoValue.trim().length()==0 )
            return false;
        else if (codigoValue.matches("[\\s]*[0-9]*[1-9]+")){            
                return true;
            }       
        else{                  
            return true;
        }
    }          
}
