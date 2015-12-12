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

import modele.Etudiant;
import modele.Promotion;

public class VueListe extends JInternalFrame {

	private JList jListe;
	private ArrayList<String> listeEtu;
	private JButton btSuppr;
	//private String[] listeEtu ;
	private Promotion promo;
	
    //private GridBagConstraints cont;
    private JPanel pano;
		
	public VueListe(Promotion promo) {
		
		this.promo = promo;
		init();
		
		btSuppr.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("Suppr d'un étu (depuis liste)");
			}
		});
	}
	
	public void init() {
		
		listeEtu = new ArrayList<String>();
		btSuppr = new JButton("Supprimer");
		loadListe();
		
		jListe = new JList(listeEtu.toArray());
		
		jListe.setLayoutOrientation(JList.VERTICAL);
		jListe.setVisibleRowCount(25);
		
		JScrollPane scrollPane = new JScrollPane(jListe);
		jListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints cont = new GridBagConstraints();
		cont.fill = GridBagConstraints.BOTH;
		cont.gridx = 0;
		cont.gridy = 0;
		
		this.add(scrollPane, cont);
		
		cont.gridx = 0;
		cont.gridy = 1;
		this.add(btSuppr, cont);
		
		this.pack();
	}
	
	/** Permet d'enregistrer les infos des étudiants dans une liste de string*/
	public void loadListe() {
		
		ArrayList<Etudiant> etus = promo.getListeEtudiants();
		Etudiant etu;
		
		// On récup les infos des étudiant dans un liste de String
		for (int i = 0 ; i < etus.size() ; i++ ) {
			
			 etu = etus.get(i); // curseur sur la liste d'étudiant à l'indice i
			listeEtu.add(etu.getId() + " - " + etu.getNom() + " " + etu.getPrenom() + " (" + etu.getDpt() +  " )");
			//listeEtu[i] = etu.getId() + " - " + etu.getNom() + " " + etu.getPrenom() + " (" + etu.getDpt() +  " )";
		}
		
		
	}
}
