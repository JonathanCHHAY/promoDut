package controleur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modele.Etudiant;
import modele.Promotion;

public class ControleurAjoutFormulaire extends Controleur {

	public ControleurAjoutFormulaire(Promotion promo) {
	
		super.promo = promo;
	}
	
	@Override
	public void control(ArrayList<String> donnees) {
 
		// On vérifie si les champs sont remplis pour faire l'insertion
		if ( donnees.get(0).isEmpty()
				 || donnees.get(1).isEmpty()
				 || donnees.get(2).isEmpty() 
				 || donnees.get(3).isEmpty()
				 || donnees.get(4).isEmpty() ) {
			System.out.println("Erreur un champ est vide");
			
			// On créer une boite de dialogue avec seulement un bouton de fermeture
			JOptionPane.showConfirmDialog(null, "Erreur un champ est vide", null, JOptionPane.CLOSED_OPTION);
		}

		// On vérifie si l'étudiant n'existe pas déjà dans la base
		else if ( promo.searchEtudiant(donnees.get(0) ) != null ){

			JOptionPane.showConfirmDialog(null, "Erreur un étudiant de n°" + donnees.get(0) + " existe déjà.", null, JOptionPane.CLOSED_OPTION);
		}
		
		// Erreur si le numéro de l'étudiant > 999 ou < 0.
		else if ( Integer.valueOf(donnees.get(0)) > 999 || Integer.valueOf(donnees.get(0)) < 0 ) {
			
			JOptionPane.showConfirmDialog(null, "Erreur, le numéro d'étudiant doit être compris entre 0 et 999", null, JOptionPane.CLOSED_OPTION);
		}
		
		// Erreur si le numéro de l'étudiant n'est pas un nombre à 3 chiffres
		else if ( donnees.get(0).length() > 3 ) {
			
			JOptionPane.showConfirmDialog(null, "Erreur, votre numéro doit être un numéro à 3 chiffres.", null, JOptionPane.CLOSED_OPTION);
		}
		
		else {
						
			// On met à jour le modèle
			System.out.println("Aj de l'étu : " +
					donnees.get(0) + " " +
					donnees.get(1) + " " +
					donnees.get(2) + " " +
					"Bac " + donnees.get(3) + " " +
					"Dpt " + donnees.get(4)
			);
			
				
			promo.addEtudiant( new Etudiant(donnees.get(0), 
					donnees.get(1).toUpperCase(), 
					donnees.get(2).toUpperCase(), 
					donnees.get(3), 
					donnees.get(4)) 
			);
			
			// On met à jour les vues
			promo.notifyObservateurs();
		}
		
	}

}
