package dataTesting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UIData {

	/*private int rowsCountUI;
	
	
	private String namesUI;
	private Float totalUI;
	private String totalBeforeConvertingUI;
	
	 HashMap<String, Float> map = new HashMap<String, Float>();

	public int getRowsCountUI() {
		return rowsCountUI;
	}

	public void setRowsCountUI(int rowsCountUI) {
		this.rowsCountUI = rowsCountUI;
	}

	public String getTotalBeforeConvertingUI() {
		return totalBeforeConvertingUI;
	}

	public void setTotalBeforeConvertingUI(String totalBeforeConvertingUI) {
		this.totalBeforeConvertingUI = totalBeforeConvertingUI;
	}

	public void setTotalUI(String storeName, Float totalUI) {
		map.put(storeName, totalUI);
		//return storeName;
	}

	public String getNamesUI() {
		map.getOrDefault(namesUI, totalUI);
	}
	public void setStoreNames(String storeName){
		this.storeName = storeName;
	}
    public String getStoreNames(String storeName){
        	return storeName;
    }
	public Float getTotalUI(String storeName) {
		Float totalUI = map.get(storeName);
		return totalUI;
	}

	public void setTotalUI(Float[] totalUI) {
		this.totalUI = totalUI;
	}

}*/
	
	private int rowsCountUI;
	//private String[] namesUI;
	
	/*private Float[] totalUI ;
	private String[] totalBeforeConvertingUI;*/
	
	
	public int getRowsCountUI() {
		return rowsCountUI;
	}

	public void setRowsCountUI(int rowscountUI) {
		this.rowsCountUI = rowscountUI;
	}

	/*
	public void setNamesUI(String[] namesUI) {
		this.namesUI = namesUI;

	}
*/
	public String[] getNamesUI() {
		Set<String> keys = mapUIdata.keySet();
		return keys.toArray(new String[0]);
	}

		
	private HashMap<String, Float> mapUIdata = new HashMap<String,Float>();
	//Set set = mapUIdata.entrySet();
	
	public void setTotalUI(String namesUI, Float totalUI){
		namesUI = namesUI.replaceAll("[ ,.&']", "");
		mapUIdata.put(namesUI.toLowerCase(), totalUI);
		
	}
		public Float getTotalUI(String namesUI){
		Float uITotal= mapUIdata.get(namesUI);
		return uITotal;
		}
		
		public String toString(){
			return mapUIdata.toString();
		}
	
		
		/*public Float[] getTotalUI() {
		return totalUI;
	}
	public void setTotalUI(Float[] toTalUI) {
		this.totalUI = toTalUI;
	}*/


	/*public String[] getTotalBeforeConvertingUI() {
		return totalBeforeConvertingUI;
	}
	public void setTotalBeforeConvertingUI(String[] totalBeforeconvertingUI) {
		this.totalBeforeConvertingUI = totalBeforeconvertingUI;
	}*/
}
