package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import modele.Promotion;

public class VuePrincipale extends JFrame {
	
	public static void main(String[] args) {
		
		Promotion promo = new Promotion();
		promo.loadFileCSV();
		
		VuePrincipale fen = new VuePrincipale(promo);
		fen.setVisible(true);
		//fen.setResizable(false);
	}
	
    private JDesktopPane pano;
	private GridBagConstraints cont;
	private Promotion promo;
	
	private VueFormulaire form;
	private VueListe liste;
	private VueCamembert camembert;
	private VueHistogramme histogramme;
	
	public VuePrincipale( Promotion promo) {

		this.promo = promo;
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
        
        liste = new VueListe(promo);
        liste.setVisible(true);
        
        camembert = new VueCamembert(promo);
        camembert.setVisible(true);
        
        histogramme = new VueHistogramme(promo);
        histogramme.setVisible(true);
        
        // Placement        
        this.setContentPane(pano);
        
        pano.add(form);
        form.setLocation(0,0);
        
        pano.add(camembert);
        camembert.setLocation(0, form.getHeight());
        
        pano.add(histogramme);
        histogramme.setLocation(camembert.getWidth(), form.getHeight());
        
        pano.add(liste);
        liste.setLocation(camembert.getWidth(), 0);
        
        // Réglage taille fenêtre
        this.setSize(1500, 650);
		
	}
}