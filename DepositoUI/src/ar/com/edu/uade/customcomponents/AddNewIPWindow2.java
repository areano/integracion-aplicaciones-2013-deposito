package ar.com.edu.uade.customcomponents;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

class AddNewIPWindow2 extends Window {
	private static final long serialVersionUID = -1867392910754863989L;
	private TextField ip;
	private String configuredIP;
	
	public AddNewIPWindow2() {
		super("Agregue nueva IP"); // Set window caption
	
        center();
        configuredIP = "";
        // Some basic content for the window
        FormLayout content = new FormLayout();
        content.addComponent(new Label("IP"));
        content.addComponent(ip);
        content.setMargin(true);
        setContent(content);
        setClosable(true);
        setResizable(true);
        setDraggable(true);
        setModal(true);
        // Trivial logic for closing the sub-window
        Button ok = new Button("OK",new Button.ClickListener() {
			private static final long serialVersionUID = 3216294094902350962L;
			public void buttonClick(ClickEvent event) {
				configuredIP = ip.getValue();
                close(); // Close the sub-window
            }
        });
        content.addComponent(ok);
    }
	public String getConfiguredIP (){
		return configuredIP;
	}
}