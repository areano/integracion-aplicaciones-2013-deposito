package wsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2013-11-16T10:40:34.209-03:00
 * Generated source version: 2.4.6
 * 
 */
@WebService(targetNamespace = "http://webservice/", name = "LogisticaMonitoreoWS")
@XmlSeeAlso({ObjectFactory.class})
public interface LogisticaMonitoreoWS {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "informarVenta", targetNamespace = "http://webservice/", className = "wsclient.InformarVenta")
    @WebMethod
    @ResponseWrapper(localName = "informarVentaResponse", targetNamespace = "http://webservice/", className = "wsclient.InformarVentaResponse")
    public java.lang.String informarVenta(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "informarLog", targetNamespace = "http://webservice/", className = "wsclient.InformarLog")
    @WebMethod
    @ResponseWrapper(localName = "informarLogResponse", targetNamespace = "http://webservice/", className = "wsclient.InformarLogResponse")
    public java.lang.String informarLog(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}