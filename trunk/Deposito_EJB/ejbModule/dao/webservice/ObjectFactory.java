
package dao.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dao.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InformarLog_QNAME = new QName("http://webservice/", "informarLog");
    private final static QName _InformarVenta_QNAME = new QName("http://webservice/", "informarVenta");
    private final static QName _InformarLogResponse_QNAME = new QName("http://webservice/", "informarLogResponse");
    private final static QName _InformarVentaResponse_QNAME = new QName("http://webservice/", "informarVentaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dao.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InformarVentaResponse }
     * 
     */
    public InformarVentaResponse createInformarVentaResponse() {
        return new InformarVentaResponse();
    }

    /**
     * Create an instance of {@link InformarVenta }
     * 
     */
    public InformarVenta createInformarVenta() {
        return new InformarVenta();
    }

    /**
     * Create an instance of {@link InformarLog }
     * 
     */
    public InformarLog createInformarLog() {
        return new InformarLog();
    }

    /**
     * Create an instance of {@link InformarLogResponse }
     * 
     */
    public InformarLogResponse createInformarLogResponse() {
        return new InformarLogResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformarLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "informarLog")
    public JAXBElement<InformarLog> createInformarLog(InformarLog value) {
        return new JAXBElement<InformarLog>(_InformarLog_QNAME, InformarLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformarVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "informarVenta")
    public JAXBElement<InformarVenta> createInformarVenta(InformarVenta value) {
        return new JAXBElement<InformarVenta>(_InformarVenta_QNAME, InformarVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformarLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "informarLogResponse")
    public JAXBElement<InformarLogResponse> createInformarLogResponse(InformarLogResponse value) {
        return new JAXBElement<InformarLogResponse>(_InformarLogResponse_QNAME, InformarLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformarVentaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "informarVentaResponse")
    public JAXBElement<InformarVentaResponse> createInformarVentaResponse(InformarVentaResponse value) {
        return new JAXBElement<InformarVentaResponse>(_InformarVentaResponse_QNAME, InformarVentaResponse.class, null, value);
    }

}
