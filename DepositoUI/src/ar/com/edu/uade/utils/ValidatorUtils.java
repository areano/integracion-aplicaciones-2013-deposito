package ar.com.edu.uade.utils;

import java.util.Collection;

import view.ArticuloView;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.AbstractTextField;



public  class ValidatorUtils {
	 
    private ValidatorUtils() {}
     
    public static void installSingleValidator(AbstractTextField field, String attribute) {
         
        Collection<Validator> validators = field.getValidators();

        if (validators == null || validators.isEmpty()) {

            field.addValidator(new BeanValidator(ArticuloView.class, attribute));
        }
    }
}