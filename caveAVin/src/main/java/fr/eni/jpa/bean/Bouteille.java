package fr.eni.jpa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bouteille")
public class Bouteille {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private boolean petillant;
	private String millesime;
	private int quantite;
	
	
	
	public Bouteille() {
		super();
	}

	public Bouteille(int id, String nom, boolean petillant, String millesime, int quantite) {
		super();
		this.id = id;
		this.nom = nom;
		this.petillant = petillant;
		this.millesime = millesime;
		this.quantite = quantite;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isPetillant() {
		return petillant;
	}

	public void setPetillant(boolean petillant) {
		this.petillant = petillant;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
	
	@Override
	public String toString() {
		return "Bouteille [id=" + id + ", nom=" + nom + ", petillant=" + petillant + ", millesime=" + millesime
				+ ", quantite=" + quantite + "]";
	}
	
	
	

}
