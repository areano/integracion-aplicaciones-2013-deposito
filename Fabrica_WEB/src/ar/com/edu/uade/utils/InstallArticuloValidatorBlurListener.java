package ar.com.edu.uade.utils;

import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.ui.AbstractTextField;

public class InstallArticuloValidatorBlurListener implements BlurListener {

	private static final long serialVersionUID = -6795016282297553977L;
	private AbstractTextField field;
    private String attribute;	 
    public InstallArticuloValidatorBlurListener(AbstractTextField field, String attribute) {	 
        this.field = field;
        this.attribute = attribute;
    }	 
    @Override
    public void blur(BlurEvent event) {	 
        ValidatorUtils.installSingleValidator(field, attribute);
    }
}