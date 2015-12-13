package gestionnairePromo;

import java.util.ArrayList;

import modele.Promotion;
import vue.VuePrincipale;
import controleur.Controleur;
import controleur.ControleurAjoutFormulaire;
import controleur.ControleurSuppressionFormulaire;
import controleur.ControleurSuppressionListe;

public class GestionnairePromo {

	public static void main(String[] args) {
		
		Promotion promo = new Promotion();
		promo.loadFileCSV();
		
		ArrayList<Controleur> controlleurs = new ArrayList<Controleur>();
		controlleurs.add( new ControleurAjoutFormulaire(promo) );
		controlleurs.add( new ControleurSuppressionFormulaire(promo) );
		controlleurs.add( new ControleurSuppressionListe(promo) );
		
		VuePrincipale fen = new VuePrincipale(promo, controlleurs);
		fen.setVisible(true);
		//fen.setResizable(false);
	}
}
