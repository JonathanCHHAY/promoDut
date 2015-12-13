package vue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.jar.JarException;

import javax.swing.JInternalFrame;

import modele.Etudiant;
import modele.Promotion;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xml.DatasetReader;

public class VueHistogramme extends JInternalFrame implements Observateur {

	private Promotion promo;
	Histogramme histo;
	
	public VueHistogramme(Promotion promo) {

		this.promo = promo;
		this.setTitle("Bacs d'origine");
		
		this.histo = new Histogramme(promo);
		this.add(histo);
		
		promo.addObservateur(this);
		
		this.pack();
		
	}
	
	private class Histogramme extends ChartPanel {
		
		private Promotion promo;
		
		private CategoryDataset dataset;
		private ChartPanel chartpano;
		private JFreeChart barChart ;
		
		public Histogramme(Promotion promo ) {

			super(null);
			this.promo = promo;
			genereData();
			init();
			this.setChart(barChart);
		}
		
		public void init() {
			
			barChart = ChartFactory.createBarChart3D(
		            "Séries de bac",      // chart title
		            "Bacs",               // domain axis label
		            "Nombre",                  // range axis label
		            dataset,                  // data
		            PlotOrientation.VERTICAL, // orientation
		            true,                     // include legend
		            true,                     // tooltips
		            false                     // urls
		        );
		}
		
		public void genereData() {
			
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			ArrayList<Etudiant> list = promo.getListeEtudiants();
			
			map.put("S", 0);
			map.put("ES", 0);
			map.put("STI", 0);
			map.put("Etr", 0);
			map.put("Autre", 0);
			
			for( int i = 0 ; i < list.size() ; i++ ) {
				
				if ( map.get(list.get(i).getSerieBac()) != null) {
					
					map.put(list.get(i).getSerieBac(), map.get(list.get(i).getSerieBac()) + 1);
				}
				
				else {
					
					map.put(list.get(i).getSerieBac(), 1);
				}
				
			}
			
			Object t[] = map.values().toArray();
			Arrays.sort(t);
			
			try {
				String bacs[] = {"S", "ES", "STI", "STG", "Etr", "Autre"};
				String serie[] = {""};
				
				double datas[][] = new double[6][1];
				datas[0][0] = map.get("S");
				//System.out.println(map.get("S"));
				//System.out.println(datas[0][0]);
				datas[1][0] = map.get("ES");
				datas[2][0] = map.get("STI");
				datas[3][0] = map.get("Etr");
				datas[4][0] = map.get("Autre");
				//datas[2][0] = map.get("STL");

				dataset = DatasetUtilities.createCategoryDataset(bacs, serie, datas);
			}
			
			catch (java.lang.NullPointerException e) {
				
				System.out.println("Pb récup étus d'un bac");
			}
			
	}
	
	
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
