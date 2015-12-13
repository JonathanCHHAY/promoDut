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

		System.out.println("Aj d'un étu : " +
				donnees.get(0) + " " +
				donnees.get(1) + " " +
				donnees.get(2) + " " +
				"Bac " + donnees.get(3) + " " +
				"Dpt " + donnees.get(4)
		);
		
		promo.addEtudiant( new Etudiant(donnees.get(0), 
				donnees.get(1), 
				donnees.get(2), 
				donnees.get(3), 
				donnees.get(4)) 
		);
		
		promo.notifyObservateurs();
		
	}

}
