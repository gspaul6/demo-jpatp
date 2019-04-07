package dev.bank;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@Table(name = "CLIENTB")
public class Clientb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Embedded
	private Adresse adresse;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "DATENAISSANCE")
	private LocalDate dateNaissance;

	@ManyToMany(mappedBy = "clientaccount")
	private List<Compte> borrowaccount;

	public List<Compte> getBorrowaccount() {
		return borrowaccount;
	}

	public void setBorrowaccount(List<Compte> borrowaccount) {
		this.borrowaccount = borrowaccount;
	}

	@ManyToOne
	@JoinColumn(name = "BANQUE_ID")
	private Banque account;

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", borrowaccount=" + borrowaccount + ", account=" + account + "]";
	}

	public Banque getAccount() {
		return account;
	}

	public void setAccount(Banque account) {
		this.account = account;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
