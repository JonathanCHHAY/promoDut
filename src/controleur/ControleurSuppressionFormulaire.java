package controleur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modele.Promotion;

public class ControleurSuppressionFormulaire extends Controleur{

	public ControleurSuppressionFormulaire(Promotion promo) {
	
		super.promo = promo;
	}
	
	@Override
	public void control(ArrayList<String> donnees) {

		// Erreur si le champ est vide 
		if ( donnees.get(0).isEmpty() ) {
			
			JOptionPane.showConfirmDialog(null, "Erreur le champ est vide", null, JOptionPane.CLOSED_OPTION);
		}
		
		// On supprime l'étudiant s'il existe dans la base
		else if (promo.searchEtudiant( donnees.get(0) ) == null ){
			
			// On créer une boite de dialogue avec seulement un bouton de fermeture
			JOptionPane.showConfirmDialog(null, "Erreur l'étudiant N°" + donnees.get(0) + " n'existe pas dans la base", null, JOptionPane.CLOSED_OPTION);
		}
		
		else {
		
			System.out.println("Suppr de l'étu n°" + donnees.get(0) );
			
			promo.removeEtudiant( promo.searchEtudiant( donnees.get(0) ) );
			promo.notifyObservateurs();
		}
		
	}

}
