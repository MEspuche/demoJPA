package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("COURT")
public class CourtMetrage extends Film {
	
	private String production;

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	
	
}
