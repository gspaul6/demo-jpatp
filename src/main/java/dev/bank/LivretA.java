/**
 * 
 */
package dev.bank;
import javax.persistence.*;
/**
 * @author Genie_singh
 *
 */
@Entity
@DiscriminatorValue("LA")
public class LivretA extends Compte  {

	private double taux;

	public LivretA(){
		
	}
	public LivretA(double taux)
	{
		this.setTaux(taux);
	}
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
