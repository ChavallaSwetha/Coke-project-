package dataTesting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UIData {

	

	private int rowsCountUI;
	private String[] namesUI;
	/*private Float[] totalUI ;
	private String[] totalBeforeConvertingUI;*/
	
	
	public int getRowsCountUI() {
		return rowsCountUI;
	}

	public void setRowsCountUI(int rowscountUI) {
		this.rowsCountUI = rowscountUI;
	}

	public void setNamesUI(String[] namesUI) {
		this.namesUI = namesUI;

	}

	public String[] getNamesUI() {
		return namesUI;
	}

		
	HashMap<String, Float> mapUIdata = new HashMap<String,Float>();
	Set set = mapUIdata.entrySet();
	
	public void setTotalUI(String namesUI, Float totalUI){
		mapUIdata.put(namesUI, totalUI);
		
	}
		public Float getTotalUI(String namesUI){
		Float uITotal= mapUIdata.get(namesUI);
		return uITotal;
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