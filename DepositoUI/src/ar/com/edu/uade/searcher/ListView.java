package ar.com.edu.uade.searcher;

import com.vaadin.ui.VerticalSplitPanel;

@SuppressWarnings("serial")
public class ListView extends VerticalSplitPanel {
    public ListView(ArticuloList articuloList, ArticuloForm articuloForm) {
        addStyleName("dashboard");
        //addComponent(articuloList);
        //addComponent(articuloForm);
        setFirstComponent(articuloList);
        setSecondComponent(articuloForm);
        setSplitPosition(40);
    }
}