package dao.webservice.clientsample;

import dao.webservice.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        LogisticaMonitoreoBeanService service1 = new LogisticaMonitoreoBeanService();
	        System.out.println("Create Web Service...");
	        LogisticaMonitoreoWS port1 = service1.getLogisticaMonitoreoWSPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.informarVenta(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port1.informarLog(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Create Web Service...");
	        LogisticaMonitoreoWS port2 = service1.getLogisticaMonitoreoWSPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.informarVenta(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.informarLog(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
