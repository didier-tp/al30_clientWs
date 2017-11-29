package fr.afcepf.al30.ws.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al30.data.Devise;

@WebService
public interface IServiceDevise {
	
	public double convertir(@WebParam(name="montant") double montant,
			                @WebParam(name="codeDeviseSource") String codeDeviseSource,
			                @WebParam(name="codeDeviseCible") String codeDeviseCible);
	public Devise rechercherDeviseParCode(@WebParam(name="codeDevise") String codeDevise);
	public List<Devise> rechercherToutesDevises();
	public List<Devise> rechercherDevisesAvecTauxMax(@WebParam(name="tauxMax") double tauxMax);
	
	public void ajouterDevise(@WebParam(name="d") Devise d);
	public void modifierDevise(@WebParam(name="d") Devise d);
	public void supprimerDevise(@WebParam(name="codeDevise") String codeDevise);
	//...

}
