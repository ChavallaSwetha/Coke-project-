package dataTesting;

import java.util.HashMap;
import java.util.Set;

public class UIData {

	private int rowsCountUI;
	private int storeCount;

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
			namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
			/*StringBuilder formedstring = new StringBuilder();
			char[] store = namesUI.toCharArray();
			String uiStore = null;
			
			for (int i=0; i< store.length; i++){
				boolean seggre = Character.isLetter(store[i]);
				if (seggre){
					  formedstring.append(uiStore);
				}
			}
			char[] storeonlyalphas = uiStore.toCharArray();
			for (int j=0; j< storeonlyalphas.length; j++){
				boolean stores = Character.isDigit(storeonlyalphas[j]);
				if (stores){
					formedstring.append(formedstring.append(uiStore));
				}
				
			}*/
			mapdataUI.put(namesUI.toLowerCase(), custUI);
			
		}
			public String getCustUI(String namesUI){
			String uICust= mapdataUI.get(namesUI);
			return uICust;
			}

			/*private HashMap<String, String> mapdataFromUI = new HashMap<String,String>();
			public void setRailUI(String namesUI, String railUI){
				namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
				mapdataFromUI.put(namesUI.toLowerCase(), railUI);
				
			}*/ // for old app.
			private HashMap<String, String> mapdataFromUI = new HashMap<String,String>();
			public void setRailUI(String namesUI, String railUI){
				namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
				mapdataFromUI.put(namesUI.toLowerCase(), railUI.toUpperCase());
				
			}
				public String getRailUI(String namesUI){
				String uIRail= mapdataFromUI.get(namesUI);
				return uIRail;
				}
     
				private HashMap<String, String> mapCoolFromUI = new HashMap<String,String>();
				public void setCoolUI(String namesUI, String coolUI){
					namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
					mapCoolFromUI.put(namesUI.toLowerCase(), coolUI.toLowerCase());
					
				}
					public String getCoolUI(String namesUI){
					String uICool= mapCoolFromUI.get(namesUI);
					return uICool;
					}
			
			public void setStoreCount(int strCount){
				this.storeCount = strCount;
			}
			public int getStoreCount(){
				return storeCount;
			}

			
}
