package dataTesting;

import java.io.IOException;
import java.util.HashMap;

import com.google.common.base.Objects;

import dataTesting.ComparingStoreLevelDataAndWritingXL.TraditionalKPIs;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ComparingStoreLevelPremiseDataAndWritingXL {
	public enum PremiseKPIs {
		TOTAL, MPA, SOVI, REF, COMM, COLDA, COMBO
	};

	public static HashMap<PremiseKPIs, Integer[]> premiseProperties = new HashMap<PremiseKPIs, Integer[]>();

	{
		premiseProperties.put(PremiseKPIs.TOTAL, new Integer[] { 5, 6, 7, 14, 7, 8 });
		premiseProperties.put(PremiseKPIs.MPA, new Integer[] { 15, 16, 17, 4, 8, 0 });
		premiseProperties.put(PremiseKPIs.SOVI, new Integer[] { 18, 19, 20, 5, 9, 0 });
		premiseProperties.put(PremiseKPIs.REF, new Integer[] { 21, 22, 23, 6, 10, 0 });
		premiseProperties.put(PremiseKPIs.COMM, new Integer[] { 24, 25, 26, 7, 14, 0 });
		premiseProperties.put(PremiseKPIs.COLDA, new Integer[] { 27, 28, 29, 8, 15, 0 });
		premiseProperties.put(PremiseKPIs.COMBO, new Integer[] { 30, 31, 32, 9, 16, 0 });

	}

	public void comparingAndWritingData(String writeFilePath, WritableWorkbook writeWorkBook, UIData dataUI,
			XLData xldata, String countryUI, String channelUI, int sh) throws IOException, WriteException {

		WritableSheet writeSheet = writeWorkBook.createSheet(countryUI, sh);
		int a = 0, b = 1, c = 2, d = 3, e = 4, h = 7, j = 9, k = 10, l = 11, m = 12, n = 13, o = 14;

		String[] headings = { "COUNTRY", "DATE", "STORE_NAME_UI", "CHANNEL", "SUB_CHANNEL", "TOTAL_UI", "ICE_XL",
				"RESULT", "DIFFERENCE", "COOLER_XL", "COOLER_UI", "COOLER_RESULT", "RAILING_XL", "RAILING_UI",
				"RAILING_RESULT", "MPA_UI", "MPA_XL", "MPA_RESULT", "SOVI_UI", "SOVI_XL", "SOVI_RESULT", "REF_UI",
				"REF_XL", "REF_RESULT", "COMM_UI", "COMM_XL", "COMM_RESULT", "COLDAVA_UI", "COLDAVA_XL",
				"COLDAVA_RESULT", "COMBO_UI", "COMBO_XL", "COMBO_RESULT" };

		for (int i1 = 0; i1 < headings.length; i1++) {
			Label country = new Label(i1, 0, headings[i1]);
			writeSheet.addCell(country);
		}

		String[] storesFromUI = dataUI.getNamesUI();
		System.out.println(storesFromUI.length);

		for (int z1 = 0; z1 < storesFromUI.length; z1++) {
			String storeName = storesFromUI[z1];

			System.out.println(storeName + " storeName");
			
			String[] xlValues = xldata.getICEvalues(storeName);

			if (xlValues == null) {
				Label storeNameFromUI = new Label(c, z1 + 1, storeName);
				writeSheet.addCell(storeNameFromUI);
				Label result = new Label(h, z1 + 1, "Missing in XL");
				writeSheet.addCell(result);
			} else {
				
				for (PremiseKPIs kpiEnum : PremiseKPIs.values()) {
					compareAndWriteForKPI(storeName, kpiEnum, z1, dataUI, xldata, writeSheet);
				}
				
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
				System.out.println("Railing"+" "+dataUI.getRailUI(storeName));
				Label railUI = new Label(n, z1 + 1, dataUI.getRailUI(storeName).toLowerCase());
				writeSheet.addCell(railUI);
				Label railXL = new Label(m, z1 + 1, xlValues[13].toLowerCase());
				writeSheet.addCell(railXL);
				Label coolUI = new Label(k, z1 + 1, dataUI.getCoolUI(storeName));
				writeSheet.addCell(coolUI);

				String coolerFromUI = dataUI.getCoolUI(storeName);
				String coolerFromXL = xlValues[10];
				System.out.println("coolerFromXL" + " " + coolerFromXL);
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
				System.out.println("Missing in UI" + namesFromXL);
			}
		}
		System.out.println("Comparing store level data and writing to XL");
	}

	private void compareAndWriteForKPI(String storeName, PremiseKPIs kpi, int z1, UIData dataUI, XLData xldata,
			WritableSheet writeSheet) throws RowsExceededException, WriteException {
		Label result;
		Float valueFromUI = null;

		String[] xlValues = xldata.getICEvalues(storeName);
		

		if (xlValues == null) {
			System.out.println("XLValues is null");
		} else {
			String valueFromXl = xlValues[premiseProperties.get(kpi)[3]];
			
			valueFromUI = dataUI.getPremiseKPI(kpi, storeName);
			
			String kPI = "TOTAL";

			if (kpi.toString().equals(kPI)) {
				Label totalFromUI = new Label(premiseProperties.get(kpi)[0], z1 + 1, Float.toString(valueFromUI));
				writeSheet.addCell(totalFromUI);

				Label iceFromXL = new Label(premiseProperties.get(kpi)[1], z1 + 1, valueFromXl);
				writeSheet.addCell(iceFromXL);
				
				float diffBetweentotalUIAndIceValueXL = Math.abs(valueFromUI - Float.parseFloat(valueFromXl));
				
				System.out.println("diffBetweentotalUIAndIceValueXL total" + " " + diffBetweentotalUIAndIceValueXL);
				
				Label diffResult = new Label(premiseProperties.get(kpi)[5], z1 + 1,
						String.valueOf(diffBetweentotalUIAndIceValueXL));
				writeSheet.addCell(diffResult);
				if (diffBetweentotalUIAndIceValueXL >= 0.5) {
					result = new Label(premiseProperties.get(kpi)[2], z1 + 1, "Mismatch");

				} else {
					result = new Label(premiseProperties.get(kpi)[2], z1 + 1, "Match");
				}
				writeSheet.addCell(result);
			} else {
			
			Label totalFromUI = new Label(premiseProperties.get(kpi)[0], z1 + 1, Float.toString(valueFromUI));
			writeSheet.addCell(totalFromUI);

			Label iceFromXL = new Label(premiseProperties.get(kpi)[1], z1 + 1, valueFromXl);
			writeSheet.addCell(iceFromXL);
			if (valueFromXl == null) {
				result = new Label(premiseProperties.get(kpi)[2], z1 + 1, "Missing Data in XL");
			} else {
				float diffBetweentotalUIAndIceValueXL = Math.abs(valueFromUI - Float.parseFloat(valueFromXl));

				if (diffBetweentotalUIAndIceValueXL >= 0.5) {
					result = new Label(premiseProperties.get(kpi)[2], z1 + 1, "Mismatch");

				} else {
					result = new Label(premiseProperties.get(kpi)[2], z1 + 1, "Match");
				}
			}
			writeSheet.addCell(result);
			}
		}

	}

}
