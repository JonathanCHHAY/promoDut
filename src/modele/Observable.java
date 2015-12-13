package modele;

import vue.Observateur;

public interface Observable {

	public void addObservateur( Observateur obs ) ;
	public void removeObservateur( Observateur obs);
	public void notifyObservateurs();
}
