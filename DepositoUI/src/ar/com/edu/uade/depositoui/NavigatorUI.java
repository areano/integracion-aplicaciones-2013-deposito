//package ar.com.edu.uade.depositoui;
//import ar.com.edu.uade.view.EnterView;
//import ar.com.edu.uade.view.articulo.ArticuloCreationFormView;
//
//import com.vaadin.navigator.Navigator;
//import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
//import com.vaadin.server.VaadinRequest;
//import com.vaadin.ui.CssLayout;
//import com.vaadin.ui.UI;
//import com.vaadin.ui.VerticalLayout;
//
//public class NavigatorUI extends UI {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -2971331017508043549L;
//	Navigator navigator;
//	protected static final String LOGINVIEW = "login";
//	protected static final String  MAINVIEW = "main";
//	protected static final String ELECTFORMVIEW = "eform";
//	protected static final String MODAFORMVIEW = "oform";
//	protected static final String MUEBLEFORMVIEW = "uform";
//	protected static final String INFANTILFORMVIEW = "nform";		
//
//
//    CssLayout root = new CssLayout();
//    VerticalLayout loginLayout;
//    CssLayout menu = new CssLayout();
//    CssLayout content = new CssLayout();
//    
//	@Override
//	protected void init(VaadinRequest request) {
//		getPage().setTitle("Navigation Example");
//		final VerticalLayout layout = new VerticalLayout();
//        layout.setMargin(true);
//        layout.setSpacing(true);
//        setContent(layout);
//        ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
//        navigator = new Navigator(UI.getCurrent(), viewDisplay);
//		//navigator = new Navigator(this, this);
//		// Create and register the views
//        navigator.addView("", new EnterView(true));
//		navigator.addView(MAINVIEW, new MainView());
//		navigator.addView(MODAFORMVIEW,new  ArticuloCreationFormView(MODAFORMVIEW));
//		navigator.addView(MUEBLEFORMVIEW,new  ArticuloCreationFormView(MUEBLEFORMVIEW));
//		navigator.addView(INFANTILFORMVIEW,new  ArticuloCreationFormView(NIÑOFORMVIEW));
//		navigator.addView(ELECTFORMVIEW,new  ArticuloCreationFormView(ELECTFORMVIEW));
//		
//	}
//}
