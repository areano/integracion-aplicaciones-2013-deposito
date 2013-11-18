package ar.com.edu.uade.depositoui;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import sessionBeans.DepositoFacade;
import view.InfantilView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("dashboard")
@Title("Administrador de Deposito")
@Stateful
public class TestEJB  extends UI {
	@EJB
	DepositoFacade facade;
	public TestEJB(){
		
	};
	@Override
	protected void init(VaadinRequest request) {
		facade.altaInfatil(new InfantilView());		
	}

}
