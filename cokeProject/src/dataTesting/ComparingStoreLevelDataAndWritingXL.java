package dataTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

//WebDriver driver = new ChromeDriver();

public class ComparingStoreLevelDataAndWritingXL {
	public void comparingAndWritingData(String writeFilePath, WritableWorkbook writeWorkBook, UIData dataUI,
			XLData xldata, String countryUI, String channelUI, int sh) throws IOException, WriteException {
		/*
		 * DateFormat df = new SimpleDateFormat("MM/dd/YYYY  HH:MM"); Date dt =
		 * new Date(0); String time = df.format(dt);
		 */
		WritableSheet writeSheet = writeWorkBook.createSheet(countryUI, sh);
		int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7, j = 8, k = 9, l = 10, m = 11,n =12, o =13;
		
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
		for (int i = 0; i < namesFromUI.length; i++) {
			Label result = null;
			Label coolResult = null;
			Label railResult = null;
			String namesUI = namesFromUI[i];
			Float totalUI = dataUI.getTotalUI(namesUI);
			System.out.println("total value in UI" + "   " + totalUI);
			String totalUIasString = Float.toString(totalUI);
			Label totalFromUI = new Label(f, i + 1, totalUIasString);
			writeSheet.addCell(totalFromUI);



			String[] xlValues = xldata.getICEvalues(namesUI);

			System.out.println(xlValues);



			if (xlValues == null) {
				Label storeNameFromUI = new Label(c, i + 1, namesUI);
				writeSheet.addCell(storeNameFromUI);
				result = new Label(h, i + 1, "Missing in XL");
			} else {
				String iceFromXl = xlValues[5];
				Label iceFromXL = new Label(g, i + 1, iceFromXl);
				writeSheet.addCell(iceFromXL);
				Label countryFromXL = new Label(a, i + 1, xlValues[1]);
				writeSheet.addCell(countryFromXL);
				Label dateFromXL = new Label(b, i + 1, xlValues[2]);
				writeSheet.addCell(dateFromXL);
				Label storeNameFromUI = new Label(c, i + 1, xlValues[6]);
				writeSheet.addCell(storeNameFromUI);
				Label channelFromXL = new Label(d, i + 1, xlValues[3]);
				writeSheet.addCell(channelFromXL);
				Label subChannelFromXL = new Label(e, i + 1, xlValues[4]);
				writeSheet.addCell(subChannelFromXL);
				Label cooleRXL = new Label(j, i + 1, xlValues[0]);
				writeSheet.addCell(cooleRXL);
				Label railUI = new Label(n, i+1, dataUI.getRailUI(namesUI));
				writeSheet.addCell(railUI);
				Label railXL = new Label(m, i+1, xlValues[9]);
				writeSheet.addCell(railXL);
				String coolerFromUI = dataUI.getCoolUI(namesUI);
				Label coolUI = new Label(k, i+1, dataUI.getCoolUI(namesUI));
				writeSheet.addCell(coolUI);
				
				if (cooleRXL.equals(coolerFromUI)){
					coolResult = new Label(l, i+1, "True");
					
					}
				else {
					coolResult = new Label(l, i+1, "False");
				}
				String railFromUI = dataUI.getRailUI(namesUI);
				if (railXL.equals(railFromUI)){
					railResult = new Label(o, i+1, "True");
					}
				else {
					railResult = new Label(o, i+1, "False");
				}
				float diffBetweentotalUIAndIceValueXL = Math.abs(totalUI - Float.parseFloat(iceFromXl));
				if (diffBetweentotalUIAndIceValueXL >= 0.5) {
					result = new Label(h, i + 1, "Mismatch");

				} else {
					result = new Label(h, i + 1, "Match");

				}
			}
			writeSheet.addCell(result);
			writeSheet.addCell(coolResult);
			writeSheet.addCell(railResult);
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
}