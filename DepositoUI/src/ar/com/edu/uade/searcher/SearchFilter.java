package ar.com.edu.uade.searcher;


import java.io.Serializable;

@SuppressWarnings("serial")
public class SearchFilter implements Serializable {

    private final String term;
    private final Object propertyId;


    public SearchFilter(Object propertyId, String searchTerm) {
        this.propertyId = propertyId;
        term = searchTerm;

    }

    /**
     * @return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * @return the propertyId
     */
    public Object getPropertyId() {
        return propertyId;
    }


}
