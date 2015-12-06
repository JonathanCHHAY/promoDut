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
	
	public VuePrincipale() {

		// Titre fenêtre et fermeture la fenêtre
        this.setTitle("Promo 2A G3");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		cont = new GridBagConstraints();
        init();
        
	}
	
	public void init() {
		
		pano = new JDesktopPane();
        pano.setLayout(new GridBagLayout());
        cont = new GridBagConstraints();
        pano.setVisible(true);
        
		form = new VueFormulaire();        
        form.setVisible(true);
        
        cont.gridx = 0;
        cont.gridy = 0;
        this.setContentPane(pano);
        
        this.add(form, cont);
        form.setLocation(new Point(0, 0));
        this.setPreferredSize(new Dimension(1300, 600));
        this.pack();
		
	}
}