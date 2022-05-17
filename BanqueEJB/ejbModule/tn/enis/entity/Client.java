package tn.enis.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id // PK
	private String cin;
	private String nom;
	private String prenom;
	private String adresse;
	// bidirectionnelle
	@OneToMany(mappedBy = "client")
	private List<Compte> comptes;

	public Client() {
		super();
	}

	public Client(String cin, String nom, String prenom, String adresse) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Client other = (Client) obj;
		return Objects.equals(cin, other.cin);
	}

	@Override
	public String toString() {
		return "Client [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}

}

/*
 * package tn.enis.entity;
 * 
 * import java.io.Serializable; import java.util.List; import java.util.Objects;
 * 
 * import javax.persistence.Entity; import javax.persistence.Id; import
 * javax.persistence.OneToMany; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "t_client") public class Client implements Serializable {
 * private static final long serialVersionUID = 1L;
 * 
 * @Id // PK private Long cin; private String nom; private String prenom;
 * private String adresse; //bidirectionnelle
 * 
 * @OneToMany(mappedBy = "client") private List<Compte> comptes;
 * 
 * public Client() { super(); }
 * 
 * public Client(Long cin, String nom, String prenom, String adresse) { super();
 * this.cin = cin; this.nom = nom; this.prenom = prenom; this.adresse=adresse; }
 * 
 * public Long getCin() { return cin; }
 * 
 * public void setCin(Long cin) { this.cin = cin; }
 * 
 * public String getNom() { return nom; }
 * 
 * public void setNom(String nom) { this.nom = nom; }
 * 
 * public String getAdresse() { return adresse; }
 * 
 * public void setAdresse(String adresse) { this.adresse = adresse; }
 * 
 * public String getPrenom() { return prenom; }
 * 
 * public void setPrenom(String prenom) { this.prenom = prenom; }
 * 
 * @Override public int hashCode() { return Objects.hash(cin); }
 * 
 * @Override public boolean equals(Object obj) { if (this == obj) { return true;
 * } if (obj == null) { return false; } if (getClass() != obj.getClass()) {
 * return false; } Client other = (Client) obj; return Objects.equals(cin,
 * other.cin); }
 * 
 * @Override public String toString() { return "Client [cin=" + cin + ", nom=" +
 * nom + ", prenom=" + prenom + ", adresse=" + adresse + "]"; }
 * 
 * 
 * 
 * }
 */