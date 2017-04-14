package metier;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) // heritage dans la meme classe !!!!!!!!!!!!!!!!!!!!!!!!!!!MEILLEURE SOLUTION AU NIVEAU VISUEL
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // la classe n'apparait plus : une sequence se crée
@Inheritance(strategy=InheritanceType.JOINED) // classe mere + classes filles
@DiscriminatorColumn(name="Type_Film")
public abstract class Film {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // pour solution 1 et 3
	//@GeneratedValue(strategy=GenerationType.TABLE) // pour solution 2
	private int idFilm;
	private String nomFilm;
	
	@ManyToMany(mappedBy="films")
	private Collection<Contact> contacts;
	
	
	
	
	public int getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}
	public String getNomFilm() {
		return nomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + "]";
	}
	
	
	
}
