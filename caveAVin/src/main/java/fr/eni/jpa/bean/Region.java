package fr.eni.jpa.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="region")
public class Region {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany
	List<Bouteille> listeBouteille;
	
	
	public Region() {
		super();
	}
	
	public Region(String nom) {
		super();
		this.nom = nom;
	}

	public Region(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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

	
	
	@Override
	public String toString() {
		return "Region [id=" + id + ", nom=" + nom + "]";
	}

	

}
