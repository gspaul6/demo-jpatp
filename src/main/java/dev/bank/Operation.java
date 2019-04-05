package dev.bank;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="OPERATION")
public class Operation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	@Column(name="DATE")
	private Date date;
	
	
	@Column(name="MONTANT")
	private double montant;
	
	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}
	@Column(name="MOTIF")
	private String motif;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	
	

}
