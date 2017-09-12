package dataTesting;

import java.util.HashMap;
import java.util.Set;

public class XLData {

	private HashMap<String, String[]> xlMap = new HashMap<String, String[]>();

	public String toString() {
		Set<String> keys = xlMap.keySet();
		StringBuilder str = new StringBuilder(" ");
		for (String key : keys) {
			String[] vaues = xlMap.get(key);
			str.append("{key:");
			str.append(key);
			str.append("[");
			for (String value : vaues) {
				str.append("'");
				str.append(value);
				str.append("'");
			}
			str.append("]");
			str.append("\n");
		}
		return str.toString();
	}
   // For the method
	public void setICEvalues(String storeNameXL, String[] IceXL) {
		storeNameXL = storeNameXL.replaceAll("[ ,.&()/'-]", "").toLowerCase();
		xlMap.put(storeNameXL, IceXL);
	}

	public String[] getICEvalues(String storenameXL) {
		storenameXL = storenameXL.replaceAll("[ ,.&()/'-]", "").toLowerCase();
		return xlMap.get(storenameXL);
	}
	
	public String[] getXLStore(){
		Set<String> store = xlMap.keySet();
		return store.toArray(new String[0]);
		
	}

}