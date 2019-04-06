package dev.jpa.tp.demo_jpatp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="emprunt")
public class Emprunt {
	@Id // Obligatory
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DATE_DEBUT")
	private Date date_debut;
	
	@Column(name="DATE_FIN")
	private Date date_fin;
	
	@Column(name="DELAI")
	private int delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client_id;
	
	@ManyToMany
	@JoinTable(name="compo", 
			joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"))
           private List<Livre>book;
	
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", delai=" + delai
				+ ", client_id=" + client_id +  "]";
	}

	public List<Livre> getBook() {
		return book;
	}

	public void setBook(List<Livre> book) {
		this.book = book;
	}

	public Emprunt(){
		book=new ArrayList<Livre>();
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public int getDelai() {
		return delai;
	}
	public void setDelai(int delai) {
		this.delai = delai;
	}
	public Client getClient_id() {
		return client_id;
	}
	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}
	

}
