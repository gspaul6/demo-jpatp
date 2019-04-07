/**
 * 
 */
package dev.bank;
import java.time.LocalDate;

import javax.persistence.*;
/**
 * @author Genie_singh
 *
 */
@Entity
@DiscriminatorValue("AV")
public class AssuranceVie extends Compte{
	private LocalDate dateFin;
    private double tauxAss;
	public AssuranceVie(){
		
	}
	public AssuranceVie(LocalDate dateone, double taux){
		this.setDateFin(dateone);
		this.setTauxAss(taux);
	}
	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public double getTauxAss() {
		return tauxAss;
	}
	public void setTauxAss(double tauxAss) {
		this.tauxAss = tauxAss;
	}
	

}
