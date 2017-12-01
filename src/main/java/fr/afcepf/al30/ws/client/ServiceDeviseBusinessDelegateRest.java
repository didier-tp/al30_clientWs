package fr.afcepf.al30.ws.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import fr.afcepf.al30.data.Devise;
import fr.afcepf.al30.ws.service.IServiceDevise;

public class ServiceDeviseBusinessDelegateRest implements IServiceDevise {
	
	private RestTemplate restTemplate = new RestTemplate();
	private String wsUrl = "http://localhost:8080/serveurWs/mvc/rest/devise";

	@Override
	public double convertir(double montant, String codeDeviseSource, String codeDeviseCible) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Devise rechercherDeviseParCode(String codeDevise) {
		return restTemplate.getForObject(wsUrl+"/"+codeDevise,Devise.class);
	}

	public <T> List<T> javaObjectListFromJsonString(String jsonString,Class objectClass){
		List<T> liste=null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			CollectionType typeReference =
				    TypeFactory.defaultInstance().constructCollectionType(List.class, objectClass);
			liste = mapper.readValue(jsonString,typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	@Override
	public List<Devise> rechercherToutesDevises() {
		String listeDevAsString= restTemplate.getForObject(wsUrl,String.class);
		return  javaObjectListFromJsonString(listeDevAsString,Devise.class);
	}

	@Override
	public List<Devise> rechercherDevisesAvecTauxMax(double tauxMax) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterDevise(Devise d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierDevise(Devise d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerDevise(String codeDevise) {
		// TODO Auto-generated method stub

	}

}
