package dev.bank;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="BANQUE")
public class Banque {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	@Column(name="NOM")
	private String nom;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@OneToMany(mappedBy="account")
	private List<Client> bank; 
	
public Banque(){
	bank=new ArrayList<Client>(); 
}

@Override
public String toString() {
	return "Banque [id=" + id + ", nom=" + nom + ", bank=" + bank + "]";
}

public List<Client> getBank() {
	return bank;
}

public void setBank(List<Client> bank) {
	this.bank = bank;
}
	
}
