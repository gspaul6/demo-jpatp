package dev.bank;

import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name = "OPERATION")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DATE")
	private LocalDate date;

	@Column(name = "MONTANT")
	private double montant;

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + ", opraccount="
				+ opraccount + "]";
	}

	@Column(name = "MOTIF")
	private String motif;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getOpraccount() {
		return opraccount;
	}

	public void setOpraccount(Compte opraccount) {
		this.opraccount = opraccount;
	}

	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte opraccount;

}
