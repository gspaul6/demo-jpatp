package dev.bank;
import javax.persistence.*;

@Entity
@Table(name="COMPTE")
public class Compte {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	
	@Column(name="NUMERO")
	private String numero;
	
	
	@Column(name="SOLDE")
	private double solde;


	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}

}
