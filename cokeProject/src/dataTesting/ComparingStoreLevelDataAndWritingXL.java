/*package dataTesting;

import java.io.IOException;


import com.google.common.base.Objects;


import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

//WebDriver driver = new ChromeDriver();

public class ComparingStoreLevelDataAndWritingXL {
	public void comparingAndWritingData(String writeFilePath, WritableWorkbook writeWorkBook, UIData dataUI,
			XLData xldata, String countryUI, String channelUI, int sh) throws IOException, WriteException {
		
		 * DateFormat df = new SimpleDateFormat("MM/dd/YYYY  HH:MM"); Date dt =
		 * new Date(0); String time = df.format(dt);
		 
		WritableSheet writeSheet = writeWorkBook.createSheet(countryUI, sh);
		int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7,i = 8, j = 9, k = 10, l = 11, m = 12,n =13, o =14;
		
		Label country = new Label(a, 0, "COUNTRY");
		writeSheet.addCell(country);
		Label date = new Label(b, 0, "DATE");
		writeSheet.addCell(date);
		Label storeNameUI = new Label(c, 0, "STORE_NAME_UI");
		writeSheet.addCell(storeNameUI);
		Label channel = new Label(d, 0, "CHANNEL");
		writeSheet.addCell(channel);
		Label subChannel = new Label(e, 0, "SUB_CHANNEL");
		writeSheet.addCell(subChannel);
		Label cooler = new Label(f, 0, "TOTAL_UI");
		writeSheet.addCell(cooler);
		Label toTalUI = new Label(g, 0, "ICE_XL");
		writeSheet.addCell(toTalUI);
		Label ice = new Label(h, 0, "RESULT");
		writeSheet.addCell(ice);
		Label iceResult = new Label(i, 0, "DIFFERENCE");
		writeSheet.addCell(iceResult);
		Label resultColumnName = new Label(j, 0, "COOLER_XL");
		writeSheet.addCell(resultColumnName);
		Label railing = new Label(k, 0, "COOLER_UI");
		writeSheet.addCell(railing);
		Label coolerRes = new Label(l, 0, "COOLER_RESULT");
		writeSheet.addCell(coolerRes);
		Label railingUI = new Label(m, 0, "RAILING_XL");
		writeSheet.addCell(railingUI);
		Label coolerUI = new Label(n, 0, "RAILING_UI");
		writeSheet.addCell(coolerUI);
		Label Railingresul = new Label(o, 0, "RAILING_RESULT");
		writeSheet.addCell(Railingresul);
		
		String[] namesFromUI = dataUI.getNamesUI();
		for (int z = 0; z < namesFromUI.length; z++) {
			Label result = null;
			
			String namesUI = namesFromUI[z];
			Float totalUI = dataUI.getTotalUI(namesUI);
			System.out.println("total value in UI" + "   " + totalUI);
			String totalUIasString = Float.toString(totalUI);
			Label totalFromUI = new Label(f, z + 1, totalUIasString);
			writeSheet.addCell(totalFromUI);



			String[] xlValues = xldata.getICEvalues(namesUI);

			//System.out.println(xlValues);



			if (xlValues == null) {
				Label storeNameFromUI = new Label(c, z + 1, namesUI);
				writeSheet.addCell(storeNameFromUI);
				result = new Label(h, z + 1, "Missing in XL");
			} else {
				String iceFromXl = xlValues[5];
				Label iceFromXL = new Label(g, z + 1, iceFromXl);
				writeSheet.addCell(iceFromXL);
				Label countryFromXL = new Label(a, z + 1, xlValues[1]);
				writeSheet.addCell(countryFromXL);
				Label dateFromXL = new Label(b, z + 1, xlValues[2]);
				writeSheet.addCell(dateFromXL);
				Label storeNameFromUI = new Label(c, z + 1, xlValues[6]);
				writeSheet.addCell(storeNameFromUI);
				Label channelFromXL = new Label(d, z + 1, xlValues[3]);
				writeSheet.addCell(channelFromXL);
				Label subChannelFromXL = new Label(e, z + 1, xlValues[4]);
				writeSheet.addCell(subChannelFromXL);
				Label cooleRXL = new Label(j, z + 1, xlValues[0]);
				writeSheet.addCell(cooleRXL);
				Label railUI = new Label(n, z+1, dataUI.getRailUI(namesUI).toLowerCase());
				writeSheet.addCell(railUI);
				Label railXL = new Label(m, z+1, xlValues[9].toLowerCase());
				writeSheet.addCell(railXL);
				Label coolUI = new Label(k, z+1, dataUI.getCoolUI(namesUI));
				writeSheet.addCell(coolUI);
				
				String coolerFromUI = dataUI.getCoolUI(namesUI);
				String coolerFromXL = xlValues[0];
							
				Boolean resultOfCooler = Objects.equal(coolerFromXL, coolerFromUI);
				String coolerResult;
				if (resultOfCooler){
					coolerResult = "Match";
				}
				else {
					coolerResult = "Mismatch";
				}
				//String coolerResult = String.valueOf(resultOfCooler);
					Label coolResult = new Label(l, z+1, coolerResult);
					writeSheet.addCell(coolResult);
				String railFromUI = dataUI.getRailUI(namesUI);
				System.out.println("Store Name"+"    "+namesUI);
				System.out.println("Railing From UI"+"    "+railFromUI);
				String railingXL = xlValues[9];
				//String railInVisible = "Inv"; 
				String railInVisible = "INV"; 
				if (railFromUI.contains(railInVisible)){
				//	railFromUI =  railFromUI.replaceAll(railInVisible, "NoV");
					railFromUI =  railFromUI.replaceAll(railInVisible, "NOV");
				
				}
				Boolean resultOfRail = Objects.equal(railingXL, railFromUI);
				String railResult;
				if (resultOfRail){
					railResult = "Match";
				}
				else {
					railResult = "Mismatch";
				}
				//String railResult = String.valueOf(resultOfRail);
				Label railingResult = new Label(o, z+1, railResult);
				writeSheet.addCell(railingResult);
				
				float diffBetweentotalUIAndIceValueXL = Math.abs(totalUI - Float.parseFloat(iceFromXl));
				String endResult = String.valueOf(diffBetweentotalUIAndIceValueXL);
				Label scoreDiff = new Label(i, z+1, endResult);
				writeSheet.addCell(scoreDiff);
				if (diffBetweentotalUIAndIceValueXL >= 0.5) {
					result = new Label(h, z + 1, "Mismatch");

				} else {
					result = new Label(h, z + 1, "Match");

				}
			}
			writeSheet.addCell(result);
			
		}

		
		String[] storesXL = xldata.getXLStore();
		for (int x = 0; x < storesXL.length; x++) {
			String namesFromXL = storesXL[x];
			boolean found = false;
			for (int y = 0; y < namesFromUI.length; y++) {
				if (namesFromXL.equals(namesFromUI[y])) {
					found = true;
				}
			}
			if (!found) {
				System.out.println("Write To Excel" + namesFromXL);
			}

		}

		System.out.println("Comparing store level data and writing to XL");
	}
}*/

package dataTesting;

import java.io.IOException;
import java.util.HashMap;

import com.google.common.base.Objects;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

//WebDriver driver = new ChromeDriver();

public class ComparingStoreLevelDataAndWritingXL {

	public enum TraditionalKPIs {
		TOTAL, MPA, SOVI, REF, COMM, PRICE, FRESH
	};

	public HashMap<TraditionalKPIs, Integer[]> traditionalProperties = new HashMap<TraditionalKPIs, Integer[]>();

	{
		traditionalProperties.put(TraditionalKPIs.TOTAL, new Integer[] { 5, 6, 7, 14 });
		traditionalProperties.put(TraditionalKPIs.MPA, new Integer[] { 15, 16, 17, 4 });
		traditionalProperties.put(TraditionalKPIs.SOVI, new Integer[] { 18, 19, 20, 5 });
		traditionalProperties.put(TraditionalKPIs.REF, new Integer[] { 21, 22, 23, 6 });
		traditionalProperties.put(TraditionalKPIs.COMM, new Integer[] { 24, 25, 26, 7 });
		traditionalProperties.put(TraditionalKPIs.PRICE, new Integer[] { 27, 28, 29, 8 });
		traditionalProperties.put(TraditionalKPIs.FRESH, new Integer[] { 30, 31, 32, 9 });

	}

	public void comparingAndWritingData(String writeFilePath, WritableWorkbook writeWorkBook, UIData dataUI,
			XLData xldata, String countryUI, String channelUI, int sh) throws IOException, WriteException {

		WritableSheet writeSheet = writeWorkBook.createSheet(countryUI, sh);
		int a = 0, b = 1, c = 2, d = 3, e = 4, h = 7, j = 9, k = 10, l = 11, m = 12, n = 13, o = 14;

		String[] headings = { "COUNTRY", "DATE", "STORE_NAME_UI", "CHANNEL", "SUB_CHANNEL", "TOTAL_UI", "ICE_XL",
				"RESULT", "DIFFERENCE", "COOLER_XL", "COOLER_UI", "COOLER_RESULT", "RAILING_XL", "RAILING_UI",
				"RAILING_RESULT", "MPA_UI", "MPA_XL", "MPA_RESULT", "SOVI_UI", "SOVI_XL", "SOVI_RESULT", "REF_UI",
				"REF_XL", "REF_RESULT", "COMM_UI", "COMM_XL", "COMM_RESULT", "PRICE_UI", "PRICE_XL", "PRICE_RESULT",
				"FRESH_UI", "FRESH_XL", "FRESH_RESULT" };

		for (int i1 = 0; i1 < headings.length; i1++) {
			Label country = new Label(i1, 0, headings[i1]);
			writeSheet.addCell(country);
		}

		String[] storesFromUI = dataUI.getNamesUI();
		System.out.println(storesFromUI.length);
		Label result = null;

		for (int z1 = 0; z1 < storesFromUI.length; z1++) {

			String storeName = storesFromUI[z1];

			for (TraditionalKPIs kpiEnum : TraditionalKPIs.values()) {

				compareAndWriteForKPI(storeName, kpiEnum, z1, dataUI, xldata, writeSheet);

			}

			String[] xlValues = xldata.getICEvalues(storeName);
			if (xlValues == null) {
				Label storeNameFromUI = new Label(c, z1 + 1, storeName);
				writeSheet.addCell(storeNameFromUI);
				result = new Label(h, z1 + 1, "Missing in XL");
			} else {
				Label countryFromXL = new Label(a, z1 + 1, xlValues[1]);
				writeSheet.addCell(countryFromXL);
				Label dateFromXL = new Label(b, z1 + 1, xlValues[11]);
				writeSheet.addCell(dateFromXL);
				Label storeNameFromUI = new Label(c, z1 + 1, xlValues[3]);
				writeSheet.addCell(storeNameFromUI);
				Label channelFromXL = new Label(d, z1 + 1, xlValues[2]);
				writeSheet.addCell(channelFromXL);
				Label subChannelFromXL = new Label(e, z1 + 1, xlValues[12]);
				writeSheet.addCell(subChannelFromXL);
				Label cooleRXL = new Label(j, z1 + 1, xlValues[10]);
				writeSheet.addCell(cooleRXL);
				Label railUI = new Label(n, z1 + 1, dataUI.getRailUI(storeName).toLowerCase());
				writeSheet.addCell(railUI);
				Label railXL = new Label(m, z1 + 1, xlValues[13].toLowerCase());
				writeSheet.addCell(railXL);
				Label coolUI = new Label(k, z1 + 1, dataUI.getCoolUI(storeName));
				writeSheet.addCell(coolUI);

				String coolerFromUI = dataUI.getCoolUI(storeName);
				String coolerFromXL = xlValues[10];
				Boolean resultOfCooler = Objects.equal(coolerFromXL, coolerFromUI);
				String coolerResult;
				if (resultOfCooler) {
					coolerResult = "Match";
				} else {
					coolerResult = "Mismatch";
				}
				Label coolResult = new Label(l, z1 + 1, coolerResult);
				writeSheet.addCell(coolResult);

				String railFromUI = dataUI.getRailUI(storeName);
				String railingXL = xlValues[13];
				String railInVisible = "INV";
				if (railFromUI.contains(railInVisible)) {

					railFromUI = railFromUI.replaceAll(railInVisible, "NOV");
				}
				Boolean resultOfRail = Objects.equal(railingXL, railFromUI);
				String railResult;
				if (resultOfRail) {
					railResult = "Match";
				} else {
					railResult = "Mismatch";
				}
				Label railingResult = new Label(o, z1 + 1, railResult);
				writeSheet.addCell(railingResult);
			}
		}

		String[] storesXL = xldata.getXLStore();
		for (int x1 = 0; x1 < storesXL.length; x1++) {
			String namesFromXL = storesXL[x1];
			boolean found = false;
			for (int y1 = 0; y1 < storesFromUI.length; y1++) {
				if (namesFromXL.equals(storesFromUI[y1])) {
					found = true;
				}
			}
			if (!found) {
				System.out.println("Write To Excel" + namesFromXL);
			}
		}
		System.out.println("Comparing store level data and writing to XL");
	}

	private void compareAndWriteForKPI(String storeName, TraditionalKPIs kpi, int z1, UIData dataUI, XLData xldata,
			WritableSheet writeSheet) throws RowsExceededException, WriteException {
		Label result;
		Float valueFromUI = null;

		String[] xlValues = xldata.getICEvalues(storeName);

		String valueFromXl = xlValues[traditionalProperties.get(kpi)[3]];
		valueFromUI = dataUI.getKPI(kpi, storeName);

		Label totalFromUI = new Label(traditionalProperties.get(kpi)[0], z1 + 1, Float.toString(valueFromUI));
		writeSheet.addCell(totalFromUI);

		Label iceFromXL = new Label(traditionalProperties.get(kpi)[1], z1 + 1, valueFromXl);
		writeSheet.addCell(iceFromXL);
		
		if (valueFromXl == null) {
			result = new Label(traditionalProperties.get(kpi)[2], z1 + 1, "Missing Data in XL");
		} else {
			float diffBetweentotalUIAndIceValueXL = Math.abs(valueFromUI - Float.parseFloat(valueFromXl));

			if (diffBetweentotalUIAndIceValueXL >= 0.5) {
				result = new Label(traditionalProperties.get(kpi)[2], z1 + 1, "Mismatch");

			} else {
				result = new Label(traditionalProperties.get(kpi)[2], z1 + 1, "Match");
			}
		}
			writeSheet.addCell(result);
		

	}
}