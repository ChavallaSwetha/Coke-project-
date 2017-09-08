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
		TOTAL, MPA, SOVI, REF, COMM, PRICE, FRESH};

	public HashMap<TraditionalKPIs, Integer[]> traditionalProperties = new HashMap<TraditionalKPIs, Integer[]>();

	{
		traditionalProperties.put(TraditionalKPIs.TOTAL, new Integer[] { 5, 6, 7, 14 });
		traditionalProperties.put(TraditionalKPIs.MPA, new Integer[] { 15, 16, 17, 4 });
		traditionalProperties.put(TraditionalKPIs.SOVI, new Integer[]{ 18, 19, 20, 5});
		traditionalProperties.put(TraditionalKPIs.REF, new Integer[]{ 21, 22, 23, 6});
		traditionalProperties.put(TraditionalKPIs.COMM, new Integer[]{ 24, 25, 26, 7});
		traditionalProperties.put(TraditionalKPIs.PRICE, new Integer[]{ 27, 28, 29, 8});
		traditionalProperties.put(TraditionalKPIs.FRESH, new Integer[]{ 30, 31, 32, 9});
		 
	}

	public void comparingAndWritingData(String writeFilePath, WritableWorkbook writeWorkBook, UIData dataUI,
			XLData xldata, String countryUI, String channelUI, int sh) throws IOException, WriteException {

		WritableSheet writeSheet = writeWorkBook.createSheet(countryUI, sh);
		int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7, i = 8, j = 9, k = 10, l = 11, m = 12, n = 13,
				o = 14, p = 15, q = 16, r = 17, s = 18, t = 19, u = 20, v = 21, w = 22, x = 23, y = 24, z = 25, aa = 26,
				ab = 27, ac = 28, ad = 29, ae = 30, af = 31, ag = 32;

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
		/*Label resultmpa = null;
		Label resultsovi = null;
		Label resultref = null;
		Label resultcomm = null;
		Label resultprice = null;
		Label resultfresh = null;*/
		for (int z1 = 0; z1 < storesFromUI.length; z1++) {

			String storeName = storesFromUI[z1];

			/*
			 * for (kPIs kpi : kPIs.values()) { Float kpiUI = dataUI.getKPI(kpi,
			 * namesUI); System.out.println(kpi+" value in UI" + "   " + kpiUI);
			 * Label kpiFromUI = new Label(f, z1 + 1, Float.toString(kpiUI));
			 * writeSheet.addCell(kpiFromUI); }
			 */
			
			

			for (TraditionalKPIs kpiEnum : TraditionalKPIs.values()){

				compareAndWriteForKPI(storeName, kpiEnum, z1, dataUI, xldata, writeSheet);

			//compareAndWriteForKPI(storeName, TraditionalKPIs.MPA, z1, dataUI, xldata, writeSheet);
			}
			/*
			 * Float totalUI = dataUI.getTotalUI(storeName); System.out.println(
			 * "total value in UI" + "   " + totalUI); Label totalFromUI = new
			 * Label(f, z1 + 1, Float.toString(totalUI));
			 * writeSheet.addCell(totalFromUI);
			 */

			/*
			 * Float mpaUI = dataUI.getMPAUI(storeName); System.out.println(
			 * "MPA from UI" + "  " + mpaUI); Label mpaofUI = new Label(p, z1 +
			 * 1,Float.toString(mpaUI)); writeSheet.addCell(mpaofUI);
			 */
			/*Float soviUI = dataUI.getSOVIUI(storeName);
			System.out.println("SOVI from UI" + "  " + soviUI);
			Label soviofUI = new Label(s, z1 + 1, Float.toString(soviUI));
			writeSheet.addCell(soviofUI);

			Float refUI = dataUI.getREFUI(storeName);
			System.out.println("REF from UI" + "  " + refUI);
			Label refofUI = new Label(v, z1 + 1, Float.toString(refUI));
			writeSheet.addCell(refofUI);

			Float commUI = dataUI.getCOMMUI(storeName);
			System.out.println("COMM from UI" + "  " + commUI);
			String comm = Float.toString(commUI);
			Label commofUI = new Label(y, z1 + 1, comm);
			writeSheet.addCell(commofUI);

			Float priceUI = dataUI.getPRICEUI(storeName);
			System.out.println("PRICE from UI" + "  " + priceUI);
			String price = Float.toString(priceUI);
			Label priceofUI = new Label(ab, z1 + 1, price);
			writeSheet.addCell(priceofUI);

			Float freshUI = dataUI.getFRESHUI(storeName);
			System.out.println("FRESH from UI" + "  " + freshUI);
			String fresh = Float.toString(freshUI);
			Label freshofUI = new Label(ae, z1 + 1, fresh);
			writeSheet.addCell(freshofUI);
*/
			String[] xlValues = xldata.getICEvalues(storeName);
			if (xlValues == null) {
				Label storeNameFromUI = new Label(c, z1 + 1, storeName);
				writeSheet.addCell(storeNameFromUI);
				result = new Label(h, z1 + 1, "Missing in XL");
			} else {
				// String iceFromXl = xlValues[15];
				// String mpaValueXL = xlValues[17];
				/*String soviValueXL = xlValues[18];
				String refValueXL = xlValues[19];
				String commValueXL = xlValues[20];
				String priceValueXL = xlValues[21];
				String freshValueXL = xlValues[22];*/

				/*
				 * Label iceFromXL = new Label(g, z1 + 1, iceFromXl);
				 * writeSheet.addCell(iceFromXL);
				 */
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
				Label railXL = new Label(m, z1 + 1, xlValues[14].toLowerCase());
				writeSheet.addCell(railXL);
				Label coolUI = new Label(k, z1 + 1, dataUI.getCoolUI(storeName));
				writeSheet.addCell(coolUI);

				/*
				 * Label mPAUI = new Label(q, z1 + 1, mpaValueXL);
				 * writeSheet.addCell(mPAUI);
				 */

				/*Label sovUI = new Label(t, z1 + 1, soviValueXL);
				writeSheet.addCell(sovUI);

				Label refreUI = new Label(w, z1 + 1, refValueXL);
				writeSheet.addCell(refreUI);

				Label commuUI = new Label(z, z1 + 1, commValueXL);
				writeSheet.addCell(commuUI);

				Label pricUI = new Label(ac, z1 + 1, priceValueXL);
				writeSheet.addCell(pricUI);

				Label fresUI = new Label(af, z1 + 1, freshValueXL);
				writeSheet.addCell(fresUI);*/

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
				String railingXL = xlValues[14];
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

				// float diffBetweentotalUIAndIceValueXL = Math.abs(totalUI -
				// Float.parseFloat(iceFromXl));

				/*
				 * String endResult =
				 * String.valueOf(diffBetweentotalUIAndIceValueXL); Label
				 * scoreDiff = new Label(i, z1 + 1, endResult);
				 * writeSheet.addCell(scoreDiff); if
				 * (diffBetweentotalUIAndIceValueXL >= 0.5) { result = new
				 * Label(h, z1 + 1, "Mismatch");
				 * 
				 * } else { result = new Label(h, z1 + 1, "Match"); }
				 * writeSheet.addCell(result);
				 */

				/*
				 * System.out.println( "MPA Total UI" + "  " + mpaUI + "," +
				 * "XL Total MPA" + "  " + Float.parseFloat(mpaValueXL));
				 * 
				 * if (mpaValueXL == null) { resultmpa = new Label(r, z1 + 1,
				 * "Missing Data in XL"); } else { float
				 * diffBetweenmpaUIAndmpaXL = Math.abs(mpaUI -
				 * Float.parseFloat(mpaValueXL)); if (diffBetweenmpaUIAndmpaXL
				 * >= 0.5) { resultmpa = new Label(r, z1 + 1, "Mismatch"); }
				 * else { resultmpa = new Label(r, z1 + 1, "Match"); } }
				 * writeSheet.addCell(resultmpa);
				 */

				/*if (soviValueXL == null) {
					resultsovi = new Label(u, z1 + 1, "Data Missing in XL");
				} else {
					float diffBetweenmpaUIAndsoviXL = Math.abs(soviUI - Float.parseFloat(soviValueXL));
					if (diffBetweenmpaUIAndsoviXL >= 0.5) {
						resultsovi = new Label(u, z1 + 1, "Mismatch");

					} else {
						resultsovi = new Label(u, z1 + 1, "Match");
					}
				}
				writeSheet.addCell(resultsovi);

				if (refValueXL == null) {
					resultref = new Label(x, z1 + 1, "Missing Data in XL");
				} else {
					float diffBetweenmpaUIAndrefXL = Math.abs(refUI - Float.parseFloat(refValueXL));
					if (diffBetweenmpaUIAndrefXL >= 0.5) {
						resultref = new Label(x, z1 + 1, "Mismatch");
					} else {
						resultref = new Label(x, z1 + 1, "Match");
					}
				}
				writeSheet.addCell(resultref);

				if (commValueXL == null) {
					resultcomm = new Label(aa, z1 + 1, "Missing Data in XL");
				} else {
					float diffBetweenmpaUIAndcommXL = Math.abs(commUI - Float.parseFloat(commValueXL));
					if (diffBetweenmpaUIAndcommXL >= 0.5) {
						resultcomm = new Label(aa, z1 + 1, "Mismatch");
					} else {
						resultcomm = new Label(aa, z1 + 1, "Match");
					}
				}
				writeSheet.addCell(resultcomm);

				if (priceValueXL == null) {
					resultprice = new Label(ad, z1 + 1, "Missing Data in XL");
				} else {
					float diffBetweenmpaUIAndpriceXL = Math.abs(priceUI - Float.parseFloat(priceValueXL));
					if (diffBetweenmpaUIAndpriceXL >= 0.5) {
						resultprice = new Label(ad, z1 + 1, "Mismatch");

					} else {
						resultprice = new Label(ad, z1 + 1, "Match");
					}
				}
				writeSheet.addCell(resultprice);

				if (freshValueXL == null) {
					resultfresh = new Label(ag, z1 + 1, "Missing Data In XL");
				} else {
					float diffBetweenmpaUIAndfreshXL = Math.abs(freshUI - Float.parseFloat(freshValueXL));
					if (diffBetweenmpaUIAndfreshXL >= 0.5) {
						resultfresh = new Label(ag, z1 + 1, "Mismatch");
					} else {
						resultfresh = new Label(ag, z1 + 1, "Match");
					}
				}
				writeSheet.addCell(resultfresh);
*/
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
		Float valueFromUI  = dataUI.getKPI(kpi, storeName);
		
		String[] xlValues = xldata.getICEvalues(storeName);
		
		String valueFromXl = xlValues[traditionalProperties.get(kpi)[3]];
		valueFromUI = dataUI.getKPI(kpi, storeName);
		System.out.println("valueFromXl"+" "+valueFromXl);
		System.out.println("valueFromUI"+" "+valueFromUI);
		
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