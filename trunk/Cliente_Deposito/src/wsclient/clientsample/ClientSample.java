package wsclient.clientsample;

import java.net.MalformedURLException;
import java.net.URL;

import wsclient.*;

public class ClientSample {
	static String mensaje ="<log><fecha>2013-11-16 10:10:10</fecha><idModulo>6</idModulo><mensaje>test mensaje G6</mensaje></log>";


			
	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        //LogisticaMonitoreoBeanService service1 = new LogisticaMonitoreoBeanService();
	        URL wsdlLocation;
			try {
				wsdlLocation = new URL("http://172.16.174.55:8080/LogisticaMonitoreo/LogisticaMonitoreoWS");
				 LogisticaMonitoreoBeanService service1 =  new LogisticaMonitoreoBeanService(wsdlLocation);
			        
			        System.out.println("Create Web Service...");
			        LogisticaMonitoreoWS port1 = service1.getLogisticaMonitoreoWSPort();
			        System.out.println("Call Web Service Operation...");
		
			        System.out.println("Server said: " + port1.informarLog(mensaje));
			        //Please input the parameters instead of 'null' for the upper method!
			
			        System.out.println("***********************");
			        System.out.println("Call Over!");
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	}
}
