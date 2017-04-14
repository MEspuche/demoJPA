package presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Adresse;
import metier.Contact;
import metier.CourtMetrage;
import metier.Film;
import metier.LongMetrage;
import metier.Telefilm;

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
			
			
			LongMetrage ml = new LongMetrage();
			ml.setNomFilm("film1");
			ml.setCinema("gaumont");
			
			CourtMetrage cm = new CourtMetrage();
			cm.setNomFilm("film2court");
			cm.setProduction("Canal+");
			
			Telefilm ts = new Telefilm();
			ts.setChaine("tf1");
			ts.setNomFilm("josephine");
			
			Contact c = new Contact();
			c.setNom("toto");
			c.setPrenom("titi");
			c.setEmail("toto.titi@mail.com");
			c.setAdresse(s);
			Collection<Film> cf = new ArrayList<>();
			
			cf.add(cm);
			cf.add(ts);
			c.setFilms(cf);
		
			
			// 4. Persistance de l'objet métier
			em.persist(ml);
			em.persist(c);
			
			em.persist(cm);
			em.persist(ts);
			
			// 5. Validation de la transaction 
			tx.commit();
			
			//Recuperation du film d'id 1
			System.out.println("\n Recuperation du film d'id1");
			Film f = em.find(Film.class, 1);
			System.out.println(f);
			
			
			//modification
			tx.begin();
			f.setNomFilm("film modifié");
			em.merge(f);
			tx.commit();
			
			
			//suppression film
			tx.begin();
			em.remove(f);
			tx.commit();
			
			//selection de tous les films
			System.out.println("\n Liste de tous les films");
			List<Film> listerFilm = em.createQuery("SELECT f FROM Film f").getResultList();
			for (Film ff:listerFilm)
			{
				System.out.println(ff);
			}
			
			
			//Selection du film dont le nom du film est josephine
			System.out.println("\n Recuperation du film dont le nom est josephine");
			Query q = em.createQuery("SELECT f FROM Film f WHERE f.nomFilm = :lenom");
			q.setParameter("lenom", "josephine");
			List<Film> liste = q.getResultList();
			for (Film ff2 : liste)
			{
				System.out.println(ff2);
			}
			
			//Selection du film dont le nom du film contient un mot cle
			System.out.println("\n Recuperation du film qui contient la lettre i");
			Query q2= em.createQuery("SELECT f FROM Film f WHERE f.nomFilm LIKE :lenom");
			q2.setParameter("lenom", "%i%");
			List<Film> liste2 = q2.getResultList();
			for (Film ff3 : liste2)
			{
				System.out.println(ff3);
			}
			
			//exemple de getsingleresult
			System.out.println("\n Recuperation du film d'id2");
			Film f5 = (Film) em.createQuery("SELECT f FROM Film f WHERE f.idFilm = 2").getSingleResult();
			System.out.println(f5);
			// 6. Fermeture de l'unité de persistance
			em.close();
			emf.close();
			
			
			
			
		}
}
