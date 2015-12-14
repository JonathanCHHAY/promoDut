package controleur;

import java.util.ArrayList;

import modele.Etudiant;
import modele.Promotion;

public class ControleurAjoutFormulaire extends Controleur {

	public ControleurAjoutFormulaire(Promotion promo) {
	
		super.promo = promo;
	}
	
	@Override
	public void control(ArrayList<String> donnees) {

		// On met à jour le modèle
		System.out.println("Aj d'un étu : " +
				donnees.get(0) + " " +
				donnees.get(1) + " " +
				donnees.get(2) + " " +
				"Bac " + donnees.get(3) + " " +
				"Dpt " + donnees.get(4)
		);
		
		// On vérifie si l'étudiant n'existe pas déjà dans la base
		if ( promo.searchEtudiant(donnees.get(0) ) == null ) {
			
			promo.addEtudiant( new Etudiant(donnees.get(0), 
					donnees.get(1), 
					donnees.get(2), 
					donnees.get(3), 
					donnees.get(4)) 
			);
		}
		
		// On met à jour les vues
		promo.notifyObservateurs();
		
	}

}
