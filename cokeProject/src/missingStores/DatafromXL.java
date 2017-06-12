package missingStores;

import java.util.HashMap;

public class DatafromXL {

	private HashMap <String,String[]> mapXLData = new HashMap<String,String[]>();
	public String toString() {
		return mapXLData.toString();
	}

	public void setSurveySK(String storeNameXL, String[] surveyXL) {
		storeNameXL = storeNameXL.replaceAll("[ ,.&()/']", "");
		mapXLData.put(storeNameXL.toLowerCase(), surveyXL);
	}

	public String[] getSurveySK(String storenameXL) {
		System.out.println("XL data");
		return mapXLData.get(storenameXL);
	}
}
	

