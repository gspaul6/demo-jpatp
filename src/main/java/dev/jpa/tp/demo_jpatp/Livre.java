package dev.jpa.tp.demo_jpatp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="LIVRE")
public class Livre {
	@Id // Obligatory
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="TITRE")
	private String titre;
	
	@Column(name="AUTEUR")
	private String auteur;
    
	
	@ManyToMany(mappedBy="book") 
	private List<Emprunt> borrow;
	
	
	public List<Emprunt> getBorrow() {
		return borrow;
	}
	public void setBorrow(List<Emprunt> borrow) {
		this.borrow = borrow;
	}
	public Livre(){
		borrow=new ArrayList<Emprunt>();
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", borrow=" + borrow + "]";
	}
	
}
