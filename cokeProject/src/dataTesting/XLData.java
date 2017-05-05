package dataTesting;

import java.util.HashMap;

public class XLData {

	private HashMap<String, String[]> xlMap = new HashMap<String, String[]>();

	public String toString() {
		return xlMap.toString();
	}

	public void setICEvalues(String storeNameXL, String[] IceXL) {
		storeNameXL = storeNameXL.replaceAll("[ ,.&()/']", "");
		xlMap.put(storeNameXL.toLowerCase(), IceXL);
	}

	public String[] getICEvalues(String storenameXL) {
		System.out.println("XL data");
		return xlMap.get(storenameXL);
	}
}