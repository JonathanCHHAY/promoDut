package vue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import modele.Etudiant;

import org.jfree.data.general.DefaultPieDataset;

public class VueCamembertChart {
	
	public DefaultPieDataset pieDataset;
	
	public void genereData() {
		
		//pieDataSet = new DefaultPieDataset();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		/*
		ArrayList<Etudiant> list = promo.getListeEtudiant();
		
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
			
			//pieDataSet.setValue((String) t[i], map.get((String) t[i]));
		}
		*/
	}
}
