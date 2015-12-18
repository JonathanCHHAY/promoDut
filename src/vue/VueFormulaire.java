package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Controleur;

public class VueFormulaire extends JInternalFrame {

    private JLabel lbTitreAjEtu, lbTitreSupprEtu, lbNumEtuAj, lbNumEtuSuppr, lbPrenom, lbNom, lbBac, lbDpt ;
	private ArrayList<String> donnees;
    private JTextField tfNumAj, tfNumSuppr, tfPrenom, tfNom  ;
    private JButton btAjout, btSuppr ;
    private JComboBox<String> listeBac, listeDpt ;
    
    private GridBagConstraints cont;
    private JPanel pano;
    
    private Controleur controlAj;
    private Controleur controlSuppr;

	public VueFormulaire() {

		this.controlAj = null;
		this.controlSuppr = null;
		
        this.setTitle("Saisie d'étudiants");
        
		cont = new GridBagConstraints();
		init();
		
		btAjout.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				donnees.clear();
				
				// On récupère les données des champs
				// On met le numéro de l'étudiant sous la forme d'un nombre à trois chiffre (001 ou 011 ou 111)
				if (Integer.valueOf(tfNumAj.getText() ) < 10 && tfNumAj.getText().length() == 1) {
					
					donnees.add( "00" + tfNumAj.getText() );
				}
				
				else if (Integer.valueOf(tfNumAj.getText() ) < 100 && tfNumAj.getText().length() == 2) {
					
					donnees.add( "0" + tfNumAj.getText() );
				}
				
				else {
					
					// Si le nombre fait plus de 3 chiffres il y aura des problèmes lors de la suppression
					// mais cela est géré par le contrôlleur
					donnees.add( tfNumAj.getText() );
				}
				
				donnees.add( tfPrenom.getText() );
				donnees.add( tfNom.getText() );
				donnees.add(listeBac.getSelectedItem().toString());
				donnees.add(listeDpt.getSelectedItem().toString());
				
				// On controle les données avant d'actualiser le modèle et la vue
				controlAj.control(donnees);
			}
		});
		
		btSuppr.addActionListener( new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				donnees.clear();
				
				donnees.add( tfNumSuppr.getText() );
				controlSuppr.control(donnees);
			}
		});
	}
	
	public void init() {
		
		// Création d'un nouveau panneau et des éléments
		pano = new JPanel();
		pano.setLayout(new GridBagLayout());
		
		donnees = new ArrayList<String>();
		
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
		
		String[] bacs = { "S", "ES", "STI", "STG", "Etr", "Autre" };
		listeBac = new JComboBox<String>( bacs );
		
		listeDpt = new JComboBox<String>();
		
		// Ajout des départements à la combobox
		for ( int i = 1 ; i <= 95 ; i++ ) {
			
			// Pour la Corse
			if ( i == 20 ) {			
				listeDpt.addItem("2A");
				listeDpt.addItem("2B");
			}
			else {
				
				// Pour les nombres < à 10 on rajoute un 0 au début
				if( i < 10 ) {
					listeDpt.addItem( "0" + Integer.toString(i));
				}
				
				else {
					listeDpt.addItem(Integer.toString(i));
				}
			}
		}
		
		// Dpt d'outre-mer
		listeDpt.addItem(Integer.toString(971));
		listeDpt.addItem(Integer.toString(972));
		listeDpt.addItem(Integer.toString(973));
		listeDpt.addItem(Integer.toString(974));
		listeDpt.addItem(Integer.toString(976));
				
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
	
	public void setControl( Controleur controlAj, Controleur controlSuppr ) {
		
		this.controlAj = controlAj;
		this.controlSuppr = controlSuppr;
	}
}
