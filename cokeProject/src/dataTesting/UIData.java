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

	private HashMap<String, Float> mapUIdata = new HashMap<String, Float>();

	public void setTotalUI(String namesUI, Float totalUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapUIdata.put(namesUI.toLowerCase(), totalUI);

	}

	public Float getTotalUI(String namesUI) {
		Float uITotal = mapUIdata.get(namesUI);
		return uITotal;

		}
		
		public String toString(){
			System.out.println("UI data");
			return mapUIdata.toString();
			
		}
		private HashMap<String, String> mapdataUI = new HashMap<String,String>();
		public void setCustUI(String namesUI, String custUI){
			namesUI = namesUI.replaceAll("[ ,.&()/']", "");
			mapdataUI.put(namesUI.toLowerCase(), custUI);
			
		}
			public String getCustUI(String namesUI){
			String uICust= mapdataUI.get(namesUI);
			return uICust;
			}

			private HashMap<String, String> mapdataFromUI = new HashMap<String,String>();
			public void setRailUI(String namesUI, String railUI){
				namesUI = namesUI.replaceAll("[ ,.&()/']", "");
				mapdataFromUI.put(namesUI.toLowerCase(), railUI);
				
			}
				public String getRailUI(String namesUI){
				String uIRail= mapdataFromUI.get(namesUI);
				return uIRail;
				}
     
				private HashMap<String, String> mapCoolFromUI = new HashMap<String,String>();
				public void setCoolUI(String namesUI, String coolUI){
					namesUI = namesUI.replaceAll("[ ,.&()/']", "");
					mapCoolFromUI.put(namesUI.toLowerCase(), coolUI);
					
				}
					public String getCoolUI(String namesUI){
					String uICool= mapCoolFromUI.get(namesUI);
					return uICool;
					}
			
			
			


}
