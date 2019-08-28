package fr.eni.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.dao.IBouteilleRepository;


@Service(value="gestionBouteille")
public class GestionBouteille {
	
	
	@Autowired
	IBouteilleRepository bouteilleDao;
	
	public List<Bouteille> listeBouteille(){
		return bouteilleDao.findAll();
	}
	public Bouteille trouverBouteille(int id) {
		return bouteilleDao.findOne(id);
	}
	public void ajoutBouteille(Bouteille b){
		bouteilleDao.save(b);
	}
	public void modifierBouteille(Bouteille b) {
		bouteilleDao.save(b);
	}
	public void supprimerBouteille(Bouteille b) {
		bouteilleDao.delete(b);
	}
	public void supprimerBouteille(int id) {
		bouteilleDao.delete(id);
	}
	public long nombreDelements() {
		return bouteilleDao.count();
	}
	public List<Bouteille> rechercherVinParNom(String nom){
		return bouteilleDao.findByNom(nom);
	}
	public List<Bouteille> rechercherVinParMellesime(String millesime){
		return bouteilleDao.findByMillesime(millesime);
	}
	public List<Bouteille> rechercherVinPetillant(String petillant){
		return bouteilleDao.findByPetillant(petillant);
	}
	public List<Bouteille> rechercherVinParCouleur(String couleur){
		return bouteilleDao.findByCouleur(couleur);
	}
	public List<Bouteille> rechercherVinParRegion(String region){
		return bouteilleDao.findByRegion(region);
	}
	


}
