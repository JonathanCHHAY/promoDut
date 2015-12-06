package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueFormulaire extends JInternalFrame {

    private JLabel lbTitreAjEtu, lbTitreSupprEtu, lbNumEtuAj, lbNumEtuSuppr, lbPrenom, lbNom, lbBac, lbDpt ;
	private String numEtu, prenom, nom ;
    private JTextField tfNumAj, tfNumSuppr, tfPrenom, tfNom  ;
    private JButton btAjout, btSuppr ;
    private JComboBox<String> listeBac, listeDpt ;
    
    private GridBagConstraints cont;
    private JPanel pano;

	public VueFormulaire() {

        this.setTitle("Saisie d'étudiants");
        
		cont = new GridBagConstraints();
		init();
	}
	
	public void init() {
		
		// Création d'un nouveau panneau et des éléments
		pano = new JPanel();
		pano.setLayout(new GridBagLayout());
		
		lbTitreAjEtu = new JLabel("Ajout d'un étudiant :");
		lbTitreSupprEtu = new JLabel("Supression d'un étudiant :");
		lbNumEtuAj = new JLabel("Numero :");
		lbNumEtuSuppr = new JLabel("Numero :");
		lbPrenom = new JLabel("Prénom :");
		lbNom = new JLabel("Nom :");
		lbBac = new JLabel("Bac :");
		lbDpt = new JLabel("Dpt :");
		

		tfPrenom = new JTextField();
		tfNom = new JTextField();
		tfNumAj = new JTextField();
		tfNumSuppr = new JTextField();
		
		tfPrenom.setColumns(10);
		tfNom.setColumns(10);
		tfNumAj.setColumns(10);
		tfNumSuppr.setColumns(10);
		
		String[] bacs = { "S", "STI", "ES" };
		listeBac = new JComboBox<String>( bacs );
		
		String[] dpt = { "Informatique", "GEA", "Biologie", "GTE" };
		listeDpt = new JComboBox<String>( dpt );
		
		btAjout = new JButton("Ajout");
		btSuppr = new JButton("Supprimer");
		
		// Placement des éléments
        cont.fill = GridBagConstraints.BOTH ;
        
        // Titre ajouter etu
        cont.gridwidth = 10;
        cont.gridx = 0;
        cont.gridy = 0;
        pano.add(lbTitreAjEtu, cont);
        cont.gridwidth = 1;
        
        // Ligne ajouter etu
        cont.gridy = 1;
        
        	cont.gridx = 0;
        	pano.add(lbNumEtuAj, cont);
        	cont.gridx = 1;
        	pano.add(tfNumAj, cont);
        
        	
        	// Prenom
	        cont.gridx = 2;
	        pano.add(lbPrenom, cont);
	        cont.gridx = 3;
	        pano.add(tfPrenom, cont);
	        
	        // Nom
	        cont.gridx = 4;
	        pano.add(lbNom, cont);
	        cont.gridx = 5;
	        pano.add(tfNom, cont);
		        
	        // Bac
	        cont.gridx = 6;
	        pano.add(lbBac, cont);
	        cont.gridx = 7;
	        pano.add(listeBac, cont);
	        
	        // Département
	        cont.gridx = 8;
	        pano.add(lbDpt, cont);
	        cont.gridx = 9;
	        pano.add(listeDpt, cont);
	        
	        
	    // Bouton ajouter étudiant
        cont.gridx = 10;
        cont.gridy = 2;
        pano.add(btAjout, cont);
        
        // Titre suppr etu
        cont.gridwidth = 10;
        cont.gridx = 0;
        cont.gridy = 3;
        pano.add(lbTitreSupprEtu, cont);
        cont.gridwidth = 1;
	        
        // Ligne supprimmer étudiant
        cont.gridx = 0;
        cont.gridy = 4;
        pano.add(lbNumEtuSuppr, cont);
        cont.gridx = 1;
        cont.gridy = 4;
        pano.add(tfNumSuppr, cont);
	        
        // Bouton Supprimmer étu	        
        cont.gridx = 10;
        cont.gridy = 5;
        pano.add(btSuppr, cont);

        //pano.setPreferredSize(new Dimension(800, 100));
        this.setContentPane(pano);
        this.pack(); // redim auto
        
	}
}
