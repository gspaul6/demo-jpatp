package dev.jpa.tp.demo_jpatp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Etape 1 - Créer une instance d'EntityManagerFactory
    			EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpatp");
    			
    			// Début d'une unité de travail
    			EntityManager em1 = emf.createEntityManager();
    			
    			// création d'une requête
    			TypedQuery<Livre> requete = em1.createQuery("select l from Livre l", Livre.class);
    			
    			List<Livre> listeLivres = requete.getResultList();
    			
    			listeLivres.forEach(unLivre -> {
    				System.out.println(unLivre.getId() + " - "  + unLivre.getTitre() + " - " + unLivre.getAuteur());
    			});
    			
    			
    			// Fin d'une unité de travail
    			em1.close();
    			
    			emf.close();
        System.out.println( "Hello World!" );
    }
}
