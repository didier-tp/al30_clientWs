package fr.afcepf.al30.ws.client;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al30.data.Devise;
import fr.afcepf.al30.ws.service.IServiceDevise;
import fr.afcepf.al30.ws.service.IServiceTva;

public class ServiceDeviseBusinessDelegate implements IServiceDevise{
	
	private IServiceDevise proxyWsDevise; //proxy vers WS distant
	
	private void initSoapProxy(){
		try {
			String machineServeur="FORM062"; //ou "192.168.102.151";
			//String machineServeur="localhost";//ou adress ip (ipconfig)
			String portTcpIp="8080"; //ou 8081
			URL wsdlUrl = new URL("http://" +
			                      machineServeur + ":" + portTcpIp
			                      + "/serveurWs/services/devise?wsdl");
			
			
			QName SERVICE_NAME = new QName("http://service.ws.al30.afcepf.fr/",
					                       "ServiceDeviseImplService");
			QName PORT_NAME = new QName("http://service.ws.al30.afcepf.fr/",
                    "ServiceDeviseImplPort");
			
			Service service = Service.create(wsdlUrl, SERVICE_NAME);
			this.proxyWsDevise = (IServiceDevise)
			                 service.getPort(PORT_NAME, IServiceDevise.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ServiceDeviseBusinessDelegate(){
		initSoapProxy();
	}

	@Override
	public double convertir(double montant, String codeDeviseSource, String codeDeviseCible) {
		return proxyWsDevise.convertir(montant, codeDeviseSource, codeDeviseCible);
	}

	@Override
	public Devise rechercherDeviseParCode(String codeDevise) {
		return proxyWsDevise.rechercherDeviseParCode(codeDevise);
	}

	@Override
	public List<Devise> rechercherToutesDevises() {
		return proxyWsDevise.rechercherToutesDevises();
	}

	@Override
	public List<Devise> rechercherDevisesAvecTauxMax(double tauxMax) {
		return proxyWsDevise.rechercherDevisesAvecTauxMax(tauxMax);
	}

	@Override
	public void ajouterDevise(Devise d) {
		proxyWsDevise.ajouterDevise(d);
	}

	@Override
	public void modifierDevise(Devise d) {
		proxyWsDevise.modifierDevise(d);
	}

	@Override
	public void supprimerDevise(String codeDevise) {
		proxyWsDevise.supprimerDevise(codeDevise);
	}

}
