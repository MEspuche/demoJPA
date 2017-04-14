package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Long")
public class LongMetrage extends Film {

	public String cinema;

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

	@Override
	public String toString() {
		return "LongMetrage [cinema=" + cinema + ", getIdFilm()=" + getIdFilm() + ", getNomFilm()=" + getNomFilm()
				+  super.toString() +  "]";
	}
	
	
	
}
