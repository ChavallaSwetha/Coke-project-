package popProbeRelatedPrograms;

import java.util.HashMap;
import java.util.Set;

public class DataFromUI {
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

		
	private HashMap<String, String> mapUIdata = new HashMap<String,String>();
	public void setDataUI(String namesUI, String custID){
		namesUI = namesUI.replaceAll("[ ,.&()/']", "");
		mapUIdata.put(namesUI.toLowerCase(), custID);
		
	}
		public String getCustID(String namesUI){
		String custmID= mapUIdata.get(namesUI);
		return custmID;
		}
		
		public String toString(){
			System.out.println("UI data");
			return mapUIdata.toString();
			
		}
	}


