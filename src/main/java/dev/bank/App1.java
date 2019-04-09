package dev.bank;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.RandomStringUtils;

public class App1 {

	public static Scanner scan = new Scanner(System.in);
	public static Compte compte = new Compte();
	public static Operation operation = new Operation();
	public static Clientb client1 = new Clientb();
	public static Banque bank1 = new Banque();
	public static List<Banque> listbank = new ArrayList<Banque>();
	public static EntityManagerFactory emf;
	public static EntityManager em1;

	public static void openConnection() {
		// Etape 1 - Créer une instance d'EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("banque");
		// Début d'une unité de travail
		em1 = emf.createEntityManager();
	}

	public static EntityTransaction transaction;

	public static void beginTransaction() {
		transaction = em1.getTransaction();
		transaction.begin();
	}

	public static void closeConnection() {
		em1.close();
		emf.close();
	}

	public static void enterBanquetable() {

		// first bank name
		bank1.setNom("BNP");
		em1.persist(bank1);
		listbank.add(bank1);
		System.out.println(bank1.getNom());

		// second bank
		Banque bank3 = new Banque();
		bank3.setNom("SOCIETE");
		em1.persist(bank3);
		listbank.add(bank3);
		System.out.println(bank3.getNom());

		// Third Bank
		Banque bank4 = new Banque();
		bank4.setNom("CA");
		em1.persist(bank4);
		listbank.add(bank4);
		System.out.println(bank4.getNom());
		// transaction.commit();
		// closeConnection();
	}

	public static void openaccount() {
		System.out.println("Welcome to the Bank");
		// calling the method to open connection
		// openConnection();
		// calling the method to close connection
		// beginTransaction();

		System.out.println("please entere your nom");
		String name = scan.next();
		try {
			TypedQuery<Clientb> query = em1.createQuery("select c from Clientb c where c.nom=?1", Clientb.class);
			query.setParameter(1, name);
			List<Clientb> list = query.getResultList();// it sends the list

			if (list.isEmpty()) {

				System.out.println("please  fill in the details for the first client");
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

				// giving the address
				Adresse addr;
				System.out.println("Enter your numero your road");
				Integer numero = scan.nextInt();
				System.out.println("enter the street address");
				String street = scan.next();
				System.out.println("enter the ville with code postal");
				String vil = scan.next();
				addr = new Adresse(numero, street, vil);
				client1.setAdresse(addr);
				em1.persist(client1);
				transaction.commit();

				// new transaction
				beginTransaction();

				// for demanding the account
				System.out.println("choose from these banks, give a number");
				System.out.println("1. BNP");
				System.out.println("2. SOCIETE");
				System.out.println("3. CA");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					// account no.
					String numerobank1 = RandomStringUtils.random(5, "123456");
					compte.setNumero(numerobank1);
					System.out.println("entre an amount for depositing");
					double amount1 = scan.nextDouble();
					compte.setSolde(amount1);
					em1.persist(compte);

					// banque
					TypedQuery<Banque> query11 = em1.createQuery("select b from Banque b where b.nom='BNP'",
							Banque.class);
					List<Banque> bank2 = query11.getResultList();
					// bank1 = query11.getResultList().get(0);
					Iterator tim = bank2.iterator();
					while (tim.hasNext()) {
						Banque tom = (Banque) tim.next();

						client1.setAccount(tom);
						em1.merge(client1);

					}

					TypedQuery<Clientb> query22 = em1.createQuery("select c from Clientb c where c.account=:ref",
							Clientb.class);
					query22.setParameter("ref", client1.getAccount());
					List<Clientb> clientb = query22.getResultList();
					compte.setClientaccount(clientb);
					TypedQuery<Compte> query33 = em1.createQuery("select co from Compte co where co.id=:ref ",
							Compte.class);
					query33.setParameter("ref", compte.getId());
					List<Compte> compte12 = query33.getResultList();
					client1.setBorrowaccount(compte12);

					// operation
					operation.setDate(LocalDate.now());
					operation.setMontant(amount1);
					operation.setMotif("first transaction");
					operation.setOpraccount(compte);
					em1.persist(operation);
					em1.merge(compte);
					em1.merge(client1);
					break;

				case 2:
					String numerobank2 = RandomStringUtils.random(5, "123456");
					compte.setNumero(numerobank2);
					System.out.println("entre an amount for depositing");
					double amount2 = scan.nextDouble();
					compte.setSolde(amount2);
					em1.persist(compte);

					// banque
					TypedQuery<Banque> query12 = em1.createQuery("select b from Banque b where b.nom='SOCIETE'",
							Banque.class);
					List<Banque> bankSociete = query12.getResultList();

					// em1.persist(bank1);
					Iterator second = bankSociete.iterator();
					while (second.hasNext()) {
						Banque tommo = (Banque) second.next();

						client1.setAccount(tommo);
						em1.merge(client1);

					}
					TypedQuery<Clientb> query44 = em1.createQuery("select c from Clientb c where c.account=:ref",
							Clientb.class);
					query44.setParameter("ref", client1.getAccount());
					List<Clientb> clientb1 = query44.getResultList();
					compte.setClientaccount(clientb1);
					TypedQuery<Compte> query55 = em1.createQuery("select co from Compte co where co.id=:ref ",
							Compte.class);
					query55.setParameter("ref", compte.getId());
					List<Compte> compte21 = query55.getResultList();
					client1.setBorrowaccount(compte21);

					// operation
					operation.setDate(LocalDate.now());
					operation.setMontant(amount2);
					operation.setMotif("first transaction");
					operation.setOpraccount(compte);
					em1.persist(operation);
					em1.merge(compte);
					em1.merge(client1);
					break;

				case 3:
					String numerobank3 = RandomStringUtils.random(5, "1234567");
					compte.setNumero(numerobank3);
					System.out.println("entre an amount for depositing");
					double amount3 = scan.nextDouble();
					compte.setSolde(amount3);
					em1.persist(compte);

					// banque
					TypedQuery<Banque> query13 = em1.createQuery("select b from Banque b where b.nom='CA'",
							Banque.class);
					List<Banque> bankCa = query13.getResultList();
					Iterator third = bankCa.iterator();
					while (third.hasNext()) {
						Banque tommoCa = (Banque) third.next();

						client1.setAccount(tommoCa);
						em1.merge(client1);

					}
					TypedQuery<Clientb> query66 = em1.createQuery("select c from Clientb c where c.account=:ref",
							Clientb.class);
					query66.setParameter("ref", client1.getAccount());
					List<Clientb> clientb2 = query66.getResultList();
					compte.setClientaccount(clientb2);
					TypedQuery<Compte> query77 = em1.createQuery("select co from Compte co where co.id=:ref ",
							Compte.class);
					query77.setParameter("ref", compte.getId());
					List<Compte> compte31 = query77.getResultList();
					client1.setBorrowaccount(compte31);

					// operation
					operation.setDate(LocalDate.now());
					operation.setMontant(amount3);
					operation.setMotif("first transaction");
					operation.setOpraccount(compte);
					em1.persist(operation);
					em1.merge(compte);
					em1.merge(client1);
					break;

				}
				System.out.println();
			}
		} catch (EntityNotFoundException e) {
			System.out.println("entity not found" + e);
		}
		// transaction.commit();
		// closeConnection();
	}

	public static void existingAccount() {
		System.out.println("would you like to open a joint account ");
		System.out.println("1. yes");
		System.out.println("2. no");
		String single = scan.next();
		int singleAccount = Integer.parseInt(single);
		switch (singleAccount) {
		case 1:
			Clientb client2 = new Clientb();
			System.out.println("please  fill in the details for the first client");
			System.out.println("Enter your nom");
			String nom = scan.next();
			client2.setNom(nom);
			System.out.println("Enter your prenom");
			String prenom = scan.next();
			client2.setPrenom(prenom);
			System.out.println("Enter your dateofbirth in the manner with the slash operator dd/mm/yyyy");
			String dob = scan.next();
			// 20/03/2019
			LocalDate localDate = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			client1.setDateNaissance(localDate);

			// giving the address
			Adresse addr2;
			System.out.println("Enter your numero your road");
			Integer numero = scan.nextInt();
			System.out.println("enter the street address");
			String street = scan.next();
			System.out.println("enter the ville with code postal");
			String vil = scan.next();
			addr2 = new Adresse(numero, street, vil);
			client2.setAdresse(addr2);
			em1.persist(client2);
			System.out.println("please provide the client name ");
			String accountName = scan.next().toUpperCase();

			TypedQuery<Clientb> query11 = em1.createQuery("select c from Clientb c where c.nom=:ref", Clientb.class);
			query11.setParameter("ref", accountName);
			List<Clientb> clientForBankName = query11.getResultList();

			Iterator iterClientb = clientForBankName.iterator();
			while (iterClientb.hasNext()) {
				Banque tom = (Banque) iterClientb.next();

				client2.setAccount(tom);
				em1.merge(client2);

			}

			TypedQuery<Clientb> query66 = em1.createQuery("select c from Clientb c where c.account=:ref",
					Clientb.class);
			query66.setParameter("ref", client2.getAccount());
			List<Clientb> clientb2 = query66.getResultList();
			compte.setClientaccount(clientb2);

			TypedQuery<Compte> query77 = em1.createQuery("select co from Compte co where co.id=:ref ", Compte.class);
			query77.setParameter("ref", compte.getId());
			List<Compte> compte31 = query77.getResultList();
			client2.setBorrowaccount(compte31);

			// operation
			TypedQuery<Operation> query88 = em1.createQuery("select o from Operation o where o.ID_COMPTE=:ref",
					Operation.class);
			query66.setParameter("ref", client2.getAccount());
			List<Operation> compte1 = query88.getResultList();
			operation.setOpraccount(compte);
			em1.merge(operation);
			em1.merge(compte);
			em1.merge(client2);

			break;
		case 2:
			break;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			openConnection();
			beginTransaction();
			enterBanquetable();
			openaccount();
			transaction.commit();
			closeConnection();
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