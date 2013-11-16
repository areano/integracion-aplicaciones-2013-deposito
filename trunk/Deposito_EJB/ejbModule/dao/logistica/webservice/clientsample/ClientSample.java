package dao.logistica.webservice.clientsample;

import java.net.MalformedURLException;
import java.net.URL;

import dao.logistica.webservice.*;

public class ClientSample {

	public static void main(String[] args) throws MalformedURLException {
	        LogisticaMonitoreoBeanService service1 = new LogisticaMonitoreoBeanService(new URL(""));
	        LogisticaMonitoreoWS port1 = service1.getLogisticaMonitoreoWSPort();
	        System.out.println("Server said: " + port1.informarVenta(null));
	        System.out.println("Server said: " + port1.informarLog(null));
	}
}
