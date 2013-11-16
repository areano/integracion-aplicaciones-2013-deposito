package dao;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import parsers.EntradaLogParser;
import parsers.ParserException;
import log.EntradaLog;
import dao.logistica.Log;
import dao.logistica.LogAsincronico;
import dao.logistica.LogSincronico;
import dao.logistica.webservice.LogisticaMonitoreoBeanService;
import dao.logistica.webservice.LogisticaMonitoreoWS;

/**
 * Session Bean implementation class LogSincronico
 */
@Stateless
@LocalBean
public class LogLogisticaDAO {

	/**
	 * Default constructor.
	 */
	public LogLogisticaDAO() {
	}

	public void log(EntradaLog entrada, boolean sincronico) {
		try {

			String data = getData(entrada);
			Log logger;

			if (sincronico) {
				logger = new LogSincronico(null);
			} else {
				logger = new LogAsincronico();
			}

			logger.informarLog(data);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getData(EntradaLog entrada) throws ParserException {

		EntradaLogParser parser = new EntradaLogParser();
		return parser.toString(entrada);
	}

}
