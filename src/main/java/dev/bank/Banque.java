package dev.bank;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BANQUE")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
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

	@OneToMany(mappedBy = "account")
	private List<Clientb> bank;

	public Banque() {
		bank = new ArrayList<Clientb>();
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", bank=" + bank + "]";
	}

	public List<Clientb> getBank() {
		return bank;
	}

	public void setBank(List<Clientb> bank) {
		this.bank = bank;
	}

}
