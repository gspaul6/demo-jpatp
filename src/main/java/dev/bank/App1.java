package dev.bank;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.RandomStringUtils;

public class App1 {

	public static Scanner scan = new Scanner(System.in);
	public static Compte compte = new Compte();
	public static Operation operation = new Operation();
	public static Client client1 = new Client();
	public static Banque bank1 = new Banque();
	public static List<Banque> listbank = new ArrayList<Banque>();

	public static void openaccount() {
		System.out.println("Welcome to the Bank");
		// Etape 1 - Créer une instance d'EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpatp");

		// Début d'une unité de travail
		EntityManager em1 = emf.createEntityManager();
		System.out.println("please entere your nom");
		String name = scan.next();
		try {
			TypedQuery<Client> query = em1.createQuery("select c from Client c where c.nom=?", Client.class);
			query.setParameter(1, name);
			client1 = query.getResultList().get(0);
			if (client1 != null) {

				System.out.println("please  fill in the details---");
				System.out.println("Enter your nom");
				String nom = scan.next();
				client1.setNom(nom);
				System.out.println("Enter your prenom");
				String prenom = scan.next();
				client1.setPrenom(prenom);
				System.out.println("Enter your dateofbirth in the manner with the slash operator dd/mm/yyyy");
				String dob = scan.next();
				// 20/03/2019
				LocalDate localDate = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				client1.setDateNaissance(localDate);
				em1.persist(client1);

				// first bank name
				bank1.setNom("Bnpparibas");
				em1.persist(bank1);
				listbank.add(bank1);

				// second bank
				bank1.setNom("Societe general");
				em1.persist(bank1);
				listbank.add(bank1);

				// Third Bank
				bank1.setNom("CA");
				em1.persist(bank1);
				listbank.add(bank1);

				// for demanding the account
				System.out.println("choose from these banks, give a number");
				System.out.println("1. BNP");
				System.out.println("2. SOCIETE");
				System.out.println("3. CA");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					// account no.
					String numerobank1 = RandomStringUtils.random(5, "abcdefg");
					compte.setNumero(numerobank1);
					System.out.println("entre an amount for depositing");
					double amount1 = scan.nextDouble();
					compte.setSolde(amount1);
					em1.persist(compte);
					// banque
					TypedQuery<Banque> query11 = em1.createQuery("select b from Banque b where b.nom='Bnpparibas'",
							Banque.class);
					bank1 = query11.getResultList().get(0);
					em1.persist(bank1);
					// operation
					operation.setDate(LocalDate.now());
					operation.setMontant(amount1);
					operation.setMotif("first transaction");
					em1.persist(operation);
					break;

				case 2:
					String numerobank2 = RandomStringUtils.random(5, "abcdefg");
					compte.setNumero(numerobank2);
					System.out.println("entre an amount for depositing");
					double amount2 = scan.nextDouble();
					compte.setSolde(amount2);
					em1.persist(compte);
					// banque
					TypedQuery<Banque> query12 = em1.createQuery("select b from Banque b where b.nom='Societe general'",
							Banque.class);
					bank1 = query12.getResultList().get(0);
					em1.persist(bank1);
					// operation
					operation.setDate(LocalDate.now());
					operation.setMontant(amount2);
					operation.setMotif("first transaction");
					em1.persist(operation);
					break;
				case 3:
					String numerobank3 = RandomStringUtils.random(5, "abcdefg");
					compte.setNumero(numerobank3);
					System.out.println("entre an amount for depositing");
					double amount3 = scan.nextDouble();
					compte.setSolde(amount3);
					em1.persist(compte);
					// banque
					TypedQuery<Banque> query13 = em1.createQuery("select b from Banque b where b.nom='CA'",
							Banque.class);
					bank1 = query13.getResultList().get(0);
					em1.persist(bank1);
					// operation
					operation.setDate(LocalDate.now());
					operation.setMontant(amount3);
					operation.setMotif("first transaction");
					em1.persist(operation);
					break;

				}
				System.out.println();
			}
		} catch (EntityNotFoundException e) {
			System.out.println("entity not found" + e);
		}
		em1.close();

		emf.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			openaccount();

		} catch (DataAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}

// ---------------------------********************---------------------notes-------------------------------************************-----------------
// création d'une requête
// TypedQuery<Client> requete = em1.createQuery("select l from client l",
// Client.class);
//
// List<Client> listeLivres = requete.getResultList();
//
// listeLivres.forEach(unLivre -> {
// System.out.println(unLivre.getId() + " - " + unLivre.getTitre() + " - " +
// unLivre.getAuteur());
// });
//// after using find function
// try {
// Client client = em1.find(Client.class, 1);
// if (client != null) {
//
// System.out.println("the entry is" + client.toString());
// }
// } catch (EntityNotFoundException e) {
// System.out.println("entity not found" + e);
// }
//
//// to get the borrowers
// TypedQuery<Emprunt> requeteEmprunts = em1.createQuery("select e from Emprunt
// e where e.client_id=id",
// Emprunt.class);
//
// List<Emprunt> empruntLivres = requeteEmprunts.getResultList();
//
// empruntLivres.forEach(unemprunt -> {
// System.out.println(unemprunt.getClient_id().getNom().toUpperCase() + " - "
// + unemprunt.getClient_id().getPrenom() + "->" + unemprunt.getDelai() + " days
// of delai");
// });

// to create a table of compte operation Client , banque
// Fin d'une unité de travail