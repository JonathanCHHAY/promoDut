package vue;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JInternalFrame;

import modele.Etudiant;
import modele.Promotion;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class VueHistogramme extends JInternalFrame {

	private Promotion promo;
	
	public VueHistogramme(Promotion promo) {

		this.promo = promo;
		Histogramme histo = new Histogramme(promo);
		this.setTitle("Bacs d'origine");
		
	}
	
	private class Histogramme extends ChartPanel {

		private Promotion promo;
		
		private CategoryDataset dataset;
		private ChartPanel chartpano;
		private JFreeChart barChart ;
		
		public Histogramme(Promotion promo ) {

			super(null);
			init();
		}
	}
	
	public void init() {
		
		
	}
	
	public void genereData() {
		
		 = new DefaultPieDataset();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		ArrayList<Etudiant> list = promo.getListeEtudiants();
		
		for( int i = 0 ; i < list.size() ; i++ ) {
			
			if ( map.get(list.get(i).getDpt()) != null) {
				
				map.put(list.get(i).getDpt(), map.get(list.get(i).getDpt()) + 1);
			}
			
			else {
				
				map.put(list.get(i).getDpt(), 1);
			}
			
		}
		
		Object t[] = map.keySet().toArray();
		//Arrays.sort(i);
		
		for( int i = 0 ; i < t.length ; i++ ) {
			
			pieDataset.setValue((String) t[i], map.get((String) t[i]));
		}
	}
}
