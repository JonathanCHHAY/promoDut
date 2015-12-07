package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class VuePrincipale extends JFrame {
	
	public static void main(String[] args) {
		
		VuePrincipale fen = new VuePrincipale();
		
		fen.setVisible(true);
		//fen.setResizable(false);
	}
	
    private JDesktopPane pano;
	private GridBagConstraints cont;
	
	private VueFormulaire form;
	private VueListe liste;
	
	public VuePrincipale() {

		// Titre fenêtre et fermeture la fenêtre
        this.setTitle("Promo 2A G3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		cont = new GridBagConstraints();
        init();
        
	}
	
	public void init() {
		
		// Création 
		pano = new JDesktopPane();
        pano.setVisible(true);
        
		form = new VueFormulaire();        
        form.setVisible(true);
        
        liste = new VueListe();
        liste.setVisible(true);
        
        // Placement        
        this.setContentPane(pano);
        
        pano.add(form);
        form.setLocation(0,0);
        
        pano.add(liste);
        liste.setLocation(0, form.getHeight());
        
        // Réglage taille fenêtre
        this.setSize(1000, 600);
        //this.pack();
		
	}
}