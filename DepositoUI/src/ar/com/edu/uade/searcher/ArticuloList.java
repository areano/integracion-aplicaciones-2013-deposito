package ar.com.edu.uade.searcher;



import ar.com.edu.uade.data.ArticuloContainer;

import com.vaadin.ui.Component;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Runo;

import dto.ArticuloDTO;

@SuppressWarnings("serial")
public class ArticuloList extends Table {
    public ArticuloList(ArticuloContainer container) {
        setSizeFull();
        addStyleName(Runo.TABLE_SMALL);
        setContainerDataSource(container);
        setVisibleColumns(ArticuloContainer.NATURAL_COL_ORDER);
        setColumnHeaders(ArticuloContainer.COL_HEADERS_ENGLISH);

        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);

        setSelectable(true);
        setImmediate(true);
//        addListener((ValueChangeListener) app);
        /* We don't want to allow users to de-select a row */
        setNullSelectionAllowed(false);

    }

}