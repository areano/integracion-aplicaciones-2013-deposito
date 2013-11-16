package dao.logistica;

import java.net.MalformedURLException;
import java.net.URL;

import dao.logistica.webservice.LogisticaMonitoreoBeanService;
import dao.logistica.webservice.LogisticaMonitoreoWS;

public class LogSincronico implements Log {

	private LogisticaMonitoreoWS puerto;

	public LogSincronico(URL url) throws MalformedURLException {
		LogisticaMonitoreoBeanService ws = new LogisticaMonitoreoBeanService(url);
		puerto = ws.getLogisticaMonitoreoWSPort();
	}

	@Override
	public String informarLog(String log) {
		return puerto.informarLog(log);
	}

}
