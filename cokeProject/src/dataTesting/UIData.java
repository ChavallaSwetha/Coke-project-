/*package dataTesting;

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
<<<<<<< HEAD

=======

>>>>>>> branch 'master' of https://github.com/ChavallaSwetha/Coke-project-.git
		}
		
		public String toString(){
			System.out.println("UI data");
			return mapUIdata.toString();
			
		}
		private HashMap<String, String> mapdataUI = new HashMap<String,String>();
		public void setCustUI(String namesUI, String custUI){
			namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
<<<<<<< HEAD
			StringBuilder formedstring = new StringBuilder();
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
				
			}
=======
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

	/*		mapdataUI.put(namesUI.toLowerCase(), custUI);
			
		
			public String getCustUI(String namesUI){
			String uICust= mapdataUI.get(namesUI);
			return uICust;
			}


			private HashMap<String, String> mapdataFromUI = new HashMap<String,String>();
			public void setRailUI(String namesUI, String railUI){
				namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
				mapdataFromUI.put(namesUI.toLowerCase(), railUI);
				
			} // for old app.

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

			
<<<<<<< HEAD
}*/

package dataTesting;

import java.util.HashMap;
import java.util.Set;

import dataTesting.ComparingStoreLevelDataAndWritingXL.TraditionalKPIs;
import dataTesting.ComparingStoreLevelPremiseDataAndWritingXL.PremiseKPIs;


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
	
	public String toString() {
		System.out.println("UI data");
		return mapUIdata.toString();

	}

	private HashMap<String, String> mapdataUI = new HashMap<String, String>();

	public void setCustUI(String namesUI, String custUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapdataUI.put(namesUI.toLowerCase(), custUI);

	}

	public String getCustUI(String namesUI) {
		String uICust = mapdataUI.get(namesUI);
		return uICust;
	}

	private HashMap<String, String> mapdataFromUI = new HashMap<String, String>();

	public void setRailUI(String namesUI, String railUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapdataFromUI.put(namesUI.toLowerCase(), railUI.toUpperCase());

	}

	public String getRailUI(String namesUI) {
		String uIRail = mapdataFromUI.get(namesUI);
		return uIRail;
	}

	private HashMap<String, String> mapCoolFromUI = new HashMap<String, String>();

	public void setCoolUI(String namesUI, String coolUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapCoolFromUI.put(namesUI.toLowerCase(), coolUI.toLowerCase());

	}

	public String getCoolUI(String namesUI) {
		String uICool = mapCoolFromUI.get(namesUI);
		return uICool;
	}

	public void setStoreCount(int strCount) {
		this.storeCount = strCount;
	}

	public int getStoreCount() {
		return storeCount;
	}

	private HashMap<String, Float> mapUIMPA = new HashMap<String, Float>();

	public void setMPAUI(String namesUI, Float mpaUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapUIMPA.put(namesUI.toLowerCase(), mpaUI);

	}

	private HashMap<String, Float> mapUISOVI = new HashMap<String, Float>();

	public void setSOVIUI(String namesUI, Float soviUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapUISOVI.put(namesUI.toLowerCase(), soviUI);

	}

	private HashMap<String, Float> mapUIREF = new HashMap<String, Float>();

	public void setREFUI(String namesUI, Float refUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapUIREF.put(namesUI.toLowerCase(), refUI);

	}

	private HashMap<String, Float> mapUICOMM = new HashMap<String, Float>();

	public void setCOMMUI(String namesUI, Float commUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapUICOMM.put(namesUI.toLowerCase(), commUI);

	}

	private HashMap<String, Float> mapUIPRICE = new HashMap<String, Float>();

	public void setPRICEUI(String namesUI, Float priceUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapUIPRICE.put(namesUI.toLowerCase(), priceUI);

	}

	private HashMap<String, Float> mapUIFRESH = new HashMap<String, Float>();

	public void setFRESHUI(String namesUI, Float freshUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapUIFRESH.put(namesUI.toLowerCase(), freshUI);

	}

	public Float getKPI(TraditionalKPIs kpi, String namesUI) {
		switch (kpi) {
		case TOTAL:
			Float uITotal = mapUIdata.get(namesUI);
			return uITotal;
		 case MPA:
		    Float uIMpa = mapUIMPA.get(namesUI);
		    return uIMpa;
		 case SOVI:
			 Float uISovi = mapUISOVI.get(namesUI);
				return uISovi;
		 case REF:
			 Float uIRef = mapUIREF.get(namesUI);
				return uIRef;
		 case COMM:
			 Float uIComm = mapUICOMM.get(namesUI);
				return uIComm;
		 case PRICE:
			 Float uIPrice = mapUIPRICE.get(namesUI);
				return uIPrice;
		 case FRESH:
			 Float uIFresh = mapUIFRESH.get(namesUI);
				return uIFresh;
		default:
			break;
		}		
		return null;
	}
	
	public Float getPremiseKPI(PremiseKPIs kpi, String namesUI) {
		switch (kpi) {
		case TOTAL:
			Float uITotal = mapUIdata.get(namesUI);
			return uITotal;
		 case MPA:
		    Float uIMpa = mapUIMPA.get(namesUI);
		    return uIMpa;
		 case SOVI:
			 Float uISovi = mapUISOVI.get(namesUI);
				return uISovi;
		 case REF:
			 Float uIRef = mapUIREF.get(namesUI);
				return uIRef;
		 case COMM:
			 Float uIComm = mapUICOMM.get(namesUI);
				return uIComm;
		 case COLDA:
		 	 Float uIPrice = mapUIPRICE.get(namesUI);
				return uIPrice;
		 case COMBO:
			 Float uIFresh = mapUIFRESH.get(namesUI);
				return uIFresh;
		default:
			break;
		}		
		return null;
	}

	

}



