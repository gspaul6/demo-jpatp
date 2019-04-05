package dev.bank;
import java.util.*;
import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import dev.jpa.tp.demo_jpatp.Emprunt;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	
	
	@Column(name="NOM")
	private String nom;
	
	@Embedded
	private Adresse adresse;
	
	@Column(name="PRENOM")
	private String prenom;
	
	@Column(name="DATENAISSANCE")
	private Date dateNaissance;
	
	@ManyToMany(mappedBy="book") 
	private List<Compte> borrow;
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", account=" + account + "]";
	}


	public Banque getAccount() {
		return account;
	}


	public void setAccount(Banque account) {
		this.account = account;
	}


	@ManyToOne 
	@JoinColumn(name="BANQUE_ID") 
	private Banque account; 
	


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


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
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
