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
@DiscriminatorValue("V")
public class Virement extends Operation{

	private String benefecierie;
	public Virement(){
		
	}
public Virement(String benedict){
		this.setBenefecierie(benedict);
	}
public String getBenefecierie() {
	return benefecierie;
}
public void setBenefecierie(String benefecierie) {
	this.benefecierie = benefecierie;
}
}
