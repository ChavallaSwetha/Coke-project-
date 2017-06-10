package dataTesting;

import java.util.HashMap;
import java.util.Set;

public class XLData {

	private HashMap<String, String[]> xlMap = new HashMap<String, String[]>();
	
	//Storing values in XLData using Hashmap, in Hashmap we have key and value, here key is storename and value is an array 
	// contains country, channel, icevalue, date and subchannel.
	public String toString() {
		return xlMap.toString();
	}
   
	public void setICEvalues(String storeNameXL, String[] IceXL) {
		storeNameXL = storeNameXL.replaceAll("[ ,.&()/'-]", "");
		xlMap.put(storeNameXL.toLowerCase(), IceXL);
	}

	public String[] getICEvalues(String storenameXL) {
		//System.out.println("XL data");
		return xlMap.get(storenameXL);
	}
	
	public String[] getXLStore(){
		Set<String> store = xlMap.keySet();
		return store.toArray(new String[0]);
		
	}

}