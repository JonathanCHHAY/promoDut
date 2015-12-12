package vue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import modele.Etudiant;
import modele.Promotion;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class VueCamembertChart extends ChartPanel{

	private Promotion promo;
	
	private ChartPanel chartpano;
	private JFreeChart piechart ;
	public DefaultPieDataset pieDataset;
	
	public VueCamembertChart(Promotion promo) {
		
		super
		this.promo = promo;
	}
	
	public void genereData() {
		
		pieDataset = new DefaultPieDataset();
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
