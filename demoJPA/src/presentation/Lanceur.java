package presentation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.Contact;
import metier.Film;

public class Lanceur {

		public static void main(String[] args) {
			
			// 1. Ouverture de l'unite de persistence
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
			EntityManager em = emf.createEntityManager();
			
			// 2. Ouverture de la transaction
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			// 3. Creation d'un objet metier
			Adresse s = new Adresse();
			s.setVille("Lyon");
			s.setNumRue("120 rue massena");
			s.setCodePostal("69006");
			
			Film f = new Film();
			f.setNomFilm("aaaaa");
			
			Contact c = new Contact();
			c.setNom("toto");
			c.setPrenom("titi");
			c.setEmail("toto.titi@mail.com");
			c.setAdresse(s);
			Collection <Film> cf = new ArrayList<>();
			cf.add(f);
			c.setFilms(cf);
			
			// 4. Persistance de l'objet métier
			em.persist(c);
			
			// 5. Validation de la transaction 
			tx.commit();
			
			// 6. Fermeture de l'unité de persistance
			em.close();
			emf.close();
			
			
			
			
		}
}
