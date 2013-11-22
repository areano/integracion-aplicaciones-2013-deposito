package ar.com.edu.uade.depositoui;


import javax.servlet.annotation.WebServlet;



import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = DepositoUI.class)

public class Servlet extends VaadinServlet {


}