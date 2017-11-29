package fr.afcepf.al30.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD) //pour @XmlTransient sur private
public class Devise {
	
	private String codeDevise; //"EUR" , "USD" , "JPY" , "GBP" , ...
	private double tauxChange; //par rapport au dollar
	
	

	@Override
	public String toString() {
		return "Devise [codeDevise=" + codeDevise + ", tauxChange=" + tauxChange + "]";
	}

	public Devise(String codeDevise, double tauxChange) {
		super();
		this.codeDevise = codeDevise;
		this.tauxChange = tauxChange;
	}


	
	
}
