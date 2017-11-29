package fr.afcepf.al30.ws.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al30.ws.service.IServiceTva;

public class StartClientWsApp {

	public static void main(String[] args) {
		
		try {
			String machineServeur="FORM062"; //ou "192.168.102.151";
			//String machineServeur="localhost";//ou adress ip (ipconfig)
			String portTcpIp="8080"; //ou 8081
			URL wsdlUrl = new URL("http://" +
			                      machineServeur + ":" + portTcpIp
			                      + "/serveurWs/services/tva?wsdl");
			/*
			//NB: ce code s'appuie sur le code généré par wsimport:
			//(new ....Service()).get....Port()
			ServiceTvaImplService service = new ServiceTvaImplService(wsdlUrl);
			IServiceTva tvaWs = service.getServiceTvaImplPort();
			*/
			
			QName SERVICE_NAME = new QName("http://service.ws.al30.afcepf.fr/",
					                       "ServiceTvaImplService");
			QName PORT_NAME = new QName("http://service.ws.al30.afcepf.fr/",
                    "ServiceTvaImplPort");
			
			Service service = Service.create(wsdlUrl, SERVICE_NAME);
			IServiceTva tvaWs = (IServiceTva)
			                 service.getPort(PORT_NAME, IServiceTva.class);
			
			System.out.println("auteur=" + tvaWs.getAuteur());
			System.out.println("tva=" + tvaWs.tva(200.0,20.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
