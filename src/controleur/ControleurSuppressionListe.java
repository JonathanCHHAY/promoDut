package controleur;

import java.util.ArrayList;

import modele.Promotion;

public class ControleurSuppressionListe extends Controleur{

	public ControleurSuppressionListe(Promotion promo) {
	
		super.promo = promo;
	}
	
	@Override
	public void control(ArrayList<String> donnees) {
		
		System.out.println("Suppr de l'étu n°" + donnees.get(0) );
		
		promo.removeEtudiant( promo.searchEtudiant( donnees.get(0) ) );
		promo.notifyObservateurs();
	}

}
