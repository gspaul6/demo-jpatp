package dev.bank;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
	@JoinTable(name = "compot", joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "id"))
	private List<Clientb> clientaccount;

	public List<Clientb> getClientaccount() {
		return clientaccount;
	}

	public void setClientaccount(List<Clientb> clientaccount) {
		this.clientaccount = clientaccount;
	}

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
