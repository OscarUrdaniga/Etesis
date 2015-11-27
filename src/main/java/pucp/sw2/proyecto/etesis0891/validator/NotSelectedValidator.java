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
public class NotSelectedValidator implements ConstraintValidator<Telefono, String> {

    @Override
    public void initialize(Telefono paramA) {
    }

    @Override
    public boolean isValid(String telefValue, ConstraintValidatorContext ctx) {
        if (telefValue == null) {
            return false;
        } else if (telefValue.matches("Seleccione")) {
            return false;
        } else {
            return true;
        }
    }

}
