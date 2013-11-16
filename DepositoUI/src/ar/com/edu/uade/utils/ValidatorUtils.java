package ar.com.edu.uade.utils;

import java.util.Collection;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.AbstractTextField;

import dto.ArticuloDTO;



public  class ValidatorUtils {
	 
    private ValidatorUtils() {}
     
    public static void installSingleValidator(AbstractTextField field, String attribute) {
         
        Collection<Validator> validators = field.getValidators();

        if (validators == null || validators.isEmpty()) {

            field.addValidator(new BeanValidator(ArticuloDTO.class, attribute));
        }
    }
}