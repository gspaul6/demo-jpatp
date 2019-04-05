package dev.bank;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "SOLDE")
	private double solde;

	@ManyToMany
	@JoinTable(name = "compot", joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"))
	private List<Clientb> clientaccount;

	@OneToMany(mappedBy = "opraccount")
	private List<Operation> operation;

	public Compte() {
		setOperation(new ArrayList<Operation>());
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

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

}
