package controleur;

import java.util.ArrayList;

import modele.Promotion;

public abstract class Controleur {
	
	protected Promotion promo;
	
	public abstract void control( ArrayList<String> donnes );
}
