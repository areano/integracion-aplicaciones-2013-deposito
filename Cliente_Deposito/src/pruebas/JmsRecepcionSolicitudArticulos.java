package pruebas;

import javax.jms.JMSException;

import clientes.GenericQueueClient;

public class JmsRecepcionSolicitudArticulos {

	public static void main(String[] args) {

		String mensaje = "<solicitudArticulos><idSolicitud>1</idSolicitud><idModulo>2</idModulo><articulos><articulo><codigo>PEPE1</codigo><cantidad>10</cantidad></articulo></articulos></solicitudArticulos>";
		enviarMensajePrueba(mensaje);
	}

	private static void enviarMensajePrueba(String mensaje) {
		try {
			GenericQueueClient cola = new GenericQueueClient("jms/queue/solicitud", "127.0.0.1", "4447", "deposito", "deposito123");
			cola.enviar(mensaje);
			cola.cerrarConexion();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
