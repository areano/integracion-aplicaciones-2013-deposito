package ar.com.edu.uade.view.articulo;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.TextField;

public class LongField extends TextField implements TextChangeListener {
		private static final long serialVersionUID = 1L;
		String lastValue;

		public LongField() {
		    setImmediate(true);
		    setTextChangeEventMode(TextChangeEventMode.EAGER);
		    addTextChangeListener(this);
		}

		@Override
		public void textChange(TextChangeEvent event) {
		    String text = event.getText();
		    try {
		        new Long(text);
		        lastValue = text;
		    } catch (NumberFormatException e) {
		        setValue(lastValue);
		    }
		}

}