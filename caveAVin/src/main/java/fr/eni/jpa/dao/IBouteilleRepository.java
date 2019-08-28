package fr.eni.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.jpa.bean.Bouteille;



public interface IBouteilleRepository extends JpaRepository<Bouteille, Integer> {
	
	// Find by name
	List<Bouteille> findByNom(String nom);
	
	// Find by vintage
	List<Bouteille> findByMillesime(String millesime);
		
	// Find by sparkling vine = "oui" (yes in french)
	List<Bouteille> findByPetillant(String petillant);

	// Find by color
	List<Bouteille> findByCouleur(String couleur);

	// Find by country
	List<Bouteille> findByRegion(String region);
}
