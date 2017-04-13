package presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Contact;

public class Lanceur {

		public static void main(String[] args) {
			
			// 1. Ouverture de l'unite de persistence
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
			EntityManager em = emf.createEntityManager();
			
			// 2. Ouverture de la transaction
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			// 3. Creation d'un objet metier
			Contact c = new Contact();
			c.setNom("toto");
			c.setPrenom("titi");
			c.setEmail("toto.titi@mail.com");
			
			// 4. Persistance de l'objet métier
			em.persist(c);
			
			// 5. Validation de la transaction 
			tx.commit();
			
			// 6. Fermeture de l'unité de persistance
			em.close();
			emf.close();
			
			
			
			
		}
}
