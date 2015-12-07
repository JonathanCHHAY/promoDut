package vue;

import java.awt.GridBagConstraints;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class VueListe extends JInternalFrame {

	private JList<String> listeEtu;
	
    //private GridBagConstraints cont;
    private JPanel pano;
		
	public VueListe() {
		
		//pano new JPanel()
		String[] li = {"a", "b"};
		listeEtu = new JList<String>(li);
		
		this.add(listeEtu);
		this.pack();
		
	}
}
