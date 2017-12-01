package fr.afcepf.al30.ws.client;

import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al30.data.Devise;
import fr.afcepf.al30.ws.service.IServiceDevise;

public class ServiceDeviseBusinessDelegateSoap implements IServiceDevise{
	
	private IServiceDevise proxyWsDevise; //proxy vers WS distant
	
	private void initSoapProxy(){
		try {
			Properties props = new Properties(); //java.util
			props.load(Thread.currentThread()
					   .getContextClassLoader().getResourceAsStream("ws.properties"));
			String wsdlUrlAsString = props.getProperty("devise.wsdl");
			System.out.println("wsdlUrlAsString="+wsdlUrlAsString);
			URL wsdlUrl = new URL(wsdlUrlAsString);
		
			
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
	
	public ServiceDeviseBusinessDelegateSoap(){
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
