package dev.bank;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BANQUE")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
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
