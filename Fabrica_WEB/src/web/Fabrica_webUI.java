package web;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;

import view.SolicitudArticulosItemView;
import view.SolicitudCompraView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ejbfacade.EJBFacade;

@SuppressWarnings("serial")
@Theme("fabrica_web")
public class Fabrica_webUI extends UI {

	@WebServlet(value = {"/adm/*", "/VAADIN/*"}, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Fabrica_webUI.class)
	public static class Servlet extends VaadinServlet {
	}

	
	private Table armarTabla(){
		Table table= new Table("Solicitudes de compra");
		List<SolicitudCompraView> listaView=null;
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

		/* Define the names and data types of columns.
		 * The "default value" parameter is meaningless here. */
		table.addContainerProperty("Fecha", String.class,  null);
		table.addContainerProperty("Codigo",  Long.class,  null);
		table.addContainerProperty("Contenido", TextField.class, null);
		table.addContainerProperty("Enviar", CheckBox.class,  null);
		
		try {
			listaView=EJBFacade.getIntance().getSolicitudesDeCompra();
		} catch (NamingException e) {
			// TODO MostrarError de que no me pude conectar al ejb.
			e.printStackTrace();
			table.addItem(new Object[] {
				    "2013/11/26","1",new TextField("ERROR DE CONEXION AL EJB"), new CheckBox("",false)}, new Integer(1));
			return table;
		}
		
		int i=0;

		for (SolicitudCompraView scv : listaView){
			String textoArts="";
			String textoDate="";
			CheckBox check= new CheckBox("",false);
			TextField articulos= new TextField("articulos");
			
			if (scv.getDate()!=null) formatoDelTexto.format(scv.getDate());
//			if (scv.getCompletado) check.setEnabled(false);
			for (SolicitudArticulosItemView item: scv.getArticulos()){
				textoArts=textoArts + "\n Art:" + item.getArticulo().getCodigo() + "|" + item.getCantidad() + "u." ;
			}
			
			articulos.setValue(textoArts);
			
			table.addItem(new Object[] {
					textoDate,scv.getCodigoSolicitud(),articulos, check}, new Integer(i));
			
			i++;
		}
		
		return table;
	}

	private Button crearBoton(final VerticalLayout layout, final Table tabla){
		Button button=new Button("Enviar Solicitudes");
		 button.addClickListener(new Button.ClickListener() {
		 public void buttonClick(ClickEvent event) {
			 layout.addComponent(new Label("Enviado"));
			 enviarSolicitudes(tabla);
		 }
		 });
		return button;
	}
	
	protected void enviarSolicitudes(Table table) {

		List<Long> lista=new ArrayList<Long>();
		

		// Iterate over the item identifiers of the table.
		for (Iterator i = table.getItemIds().iterator(); i.hasNext();) {
		    // Get the current item identifier, which is an integer.
		    int iid = (Integer) i.next();
		    
		    // Now get the actual item from the table.
		    Item item = table.getItem(iid);
		    
		    // And now we can get to the actual checkbox object.
		    CheckBox check = (CheckBox)
		            (item.getItemProperty("Enviar").getValue());
		    
		    // If the checkbox is selected.
		    if (check.getValue() == true) {

		    	lista.add((Long) item.getItemProperty("Codigo").getValue());
		    	
		    }
		}
		 
		try {
			EJBFacade.getIntance().entregarCompras(lista);
		} catch (NamingException e) {
			// TODO Mostrar error de comunicacion
			e.printStackTrace();
		}
		
	}

	@Override
	 protected void init(VaadinRequest request) {

		 final VerticalLayout layout = new VerticalLayout();
		 layout.setMargin(true);
		 setContent(layout);
			
		
		/* Create the table with a caption. */
		Table table = armarTabla();
		
		layout.addComponent(table);

		 
		 Button button = crearBoton(layout, table);
		 layout.addComponent(button);
		 }
		
		// Allow selecting items from the table.
//		table.setSelectable(true);
		
		// Send changes in selection immediately to server.
//		table.setImmediate(true);
		
		
//		// Handle selection change.
//		table.addValueChangeListener(new Property.ValueChangeListener() {
//		    public void valueChange(ValueChangeEvent event) {
//		        current.setValue("Selected: " + table.getValue());
//		    }
//		});
				 
	 }

