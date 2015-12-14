package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controleur.Controleur;

import modele.Etudiant;
import modele.Promotion;

public class VueListe extends JInternalFrame implements Observateur {

	private JList jListe;
	private ArrayList<String> listeEtu;
	private JButton btSuppr;
	
	ArrayList<String> donnees;
	//private String[] listeEtu ;
	private Promotion promo;
	
    //private GridBagConstraints cont;
    private JPanel pano;
    private Controleur SupprListe;
		
	public VueListe(Promotion promo) {
		
		this.promo = promo;
		donnees = new ArrayList<String>();
		btSuppr = new JButton("Supprimer"); // On créer le bouton ici sinon il sera supprimé dans l'update
		
		init();
		
		btSuppr.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				donnees.clear();
				// On récupère le numéro de l'étudiant
				donnees.add(jListe.getSelectedValue().toString().substring(0, 3));

				System.out.println("Suppr de l'étu n°" + donnees.get(0) );
				
				SupprListe.control(donnees);
				
			}
		});
		
		promo.addObservateur(this);
	}
	
	public void init() {
				
		pano = new JPanel();
		listeEtu = new ArrayList<String>();
		loadListe();
		
		jListe = new JList(listeEtu.toArray());
		
		jListe.setLayoutOrientation(JList.VERTICAL);
		jListe.setVisibleRowCount(25);
		
		JScrollPane scrollPane = new JScrollPane(jListe);
		jListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		pano.setLayout(new GridBagLayout());
		GridBagConstraints cont = new GridBagConstraints();
		cont.fill = GridBagConstraints.BOTH;
		cont.gridx = 0;
		cont.gridy = 0;
		
		pano.add(scrollPane, cont);
		
		cont.gridx = 0;
		cont.gridy = 1;
		pano.add(btSuppr, cont);
		
		this.setContentPane(pano);
		this.pack();
	}

	@Override
	public void update() {
		
		this.pano.removeAll();
		init();
	}
	
	public void setControl( Controleur SupprListe ) {
		
		this.SupprListe = SupprListe;
	}
	
	/** Permet d'enregistrer les infos des étudiants dans une liste de string*/
	public void loadListe() {
		
		ArrayList<Etudiant> etus = promo.getListeEtudiants();
		Etudiant etu;
		
		// On récup les infos des étudiant dans un liste de String
		for (int i = 0 ; i < etus.size() ; i++ ) {
			
			 etu = etus.get(i); // curseur sur la liste d'étudiant à l'indice i
			listeEtu.add(etu.getId() + " - " + etu.getNom() + " " + etu.getPrenom() + " (" + etu.getDpt() +  ")");
			//listeEtu[i] = etu.getId() + " - " + etu.getNom() + " " + etu.getPrenom() + " (" + etu.getDpt() +  " )";
		}
		
		
	}

}
