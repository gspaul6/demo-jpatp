package dev.jpa.tp.demo_jpatp;

import java.util.List;



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
    			//after using find function
    			try {Client client = em1.find(Client.class, 1);
    			if (client != null){  
    				
    				System.out.println("the entry is"+ client.toString());
    			} 
    			}
               catch (EntityNotFoundException e) 
    			{ System.out.println("entity not found"+e);
               }
    			
    			//to get the borrowers
                TypedQuery<Emprunt> requeteEmprunts = em1.createQuery("select e from Emprunt e where e.client_id=id", Emprunt.class);
    			
    			List<Emprunt> empruntLivres = requeteEmprunts.getResultList();
    			
    			empruntLivres.forEach(unemprunt -> {
    				System.out.println(unemprunt.getClient_id().getNom().toUpperCase() + " - " + unemprunt.getClient_id().getPrenom() +"->"
    			+ unemprunt.getDelai()+ " days of delai" );
    			});
    			
    			// Fin d'une unité de travail
    			em1.close();
    			
    			emf.close();
      
    }
}
