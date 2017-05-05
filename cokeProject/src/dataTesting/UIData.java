package dataTesting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UIData {

	
	private int rowsCountUI;
	public int getRowsCountUI() {
		return rowsCountUI;
	}

	public void setRowsCountUI(int rowscountUI) {
		this.rowsCountUI = rowscountUI;
	}

	public String[] getNamesUI() {
		Set<String> keys = mapUIdata.keySet();
		return keys.toArray(new String[0]);
	}

		
	private HashMap<String, Float> mapUIdata = new HashMap<String,Float>();
	public void setTotalUI(String namesUI, Float totalUI){
		namesUI = namesUI.replaceAll("[ ,.&()/']", "");
		mapUIdata.put(namesUI.toLowerCase(), totalUI);
		
	}
		public Float getTotalUI(String namesUI){
		Float uITotal= mapUIdata.get(namesUI);
		return uITotal;
		}
		
		public String toString(){
			System.out.println("UI data");
			return mapUIdata.toString();
			
		}
	}
