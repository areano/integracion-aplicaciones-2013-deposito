package ar.com.edu.uade.view.articulo;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;
@SuppressWarnings("serial")
@Theme("vadintest")
public class ArticuloCreationFormView extends VerticalLayout implements View{
	protected static final String FORMVIEW = "form";
	protected static final String ELECTFORMVIEW = "eform";
	protected static final String MODAFORMVIEW = "oform";
	protected static final String MUEBLEFORMVIEW = "uform";
	protected static final String NIÑOFORMVIEW = "nform";
	public ArticuloCreationFormView() {
		setSizeFull();
		
//		if (form==ELECTFORMVIEW) {
//			ElectrodomesticoFormView articleForm;
//			articleForm = new ElectrodomesticoFormView();
//			addComponent(articleForm);
//		}else if (form == MODAFORMVIEW) {
//			ModaFormView articleForm;
//			articleForm = new ModaFormView();
//			addComponent(articleForm);
//			
//		}else if (form==MUEBLEFORMVIEW) {
//			MuebleFormView articleForm;
//			articleForm = new MuebleFormView();
//			addComponent(articleForm);
//		}else if (form ==NIÑOFORMVIEW) {
//			InfantilFormView articleForm;
//			articleForm = new InfantilFormView();
//			addComponent(articleForm);
//		}

		ElectrodomesticoFormView articleForm;
		articleForm = new ElectrodomesticoFormView();
		addComponent(articleForm);
		
		
		
	}
	@Override
	public void enter(ViewChangeEvent event) {	
		
	}

}
