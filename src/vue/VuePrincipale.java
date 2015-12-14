package vue;

import java.util.ArrayList;

import javax.jws.Oneway;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import controleur.Controleur;

import modele.Promotion;

@SuppressWarnings("serial")
public class VuePrincipale extends JFrame {
	
    private JDesktopPane pano;
	private Promotion promo;
	private ArrayList<Controleur> controleurs;
	
	private VueFormulaire form;
	private VueListe liste;
	private VueCamembert camembert;
	private VueHistogramme histogramme;
	
	public VuePrincipale( Promotion promo, ArrayList<Controleur> controleurs) {

		this.promo = promo;
		this.controleurs = controleurs;
		// Titre fenêtre et fermeture la fenêtre
        this.setTitle("Promo 2A G3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
        
	}
	
	public void init() {
		
		// Création 
		pano = new JDesktopPane();
        pano.setVisible(true);
        
		form = new VueFormulaire();
		form.setControl(controleurs.get(0), controleurs.get(1));
        form.setVisible(true);
        
        liste = new VueListe(promo);
        liste.setControl(controleurs.get(2));
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
        liste.setLocation(form.getWidth(), 0);
        
        // Réglage taille fenêtre
        this.setSize(1500, 650);
		
	}
}