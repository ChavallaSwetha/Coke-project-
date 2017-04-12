package dataTesting;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;



	/*
	 * Using function readingDataFromXL() read data from XL (Storenames,country,date,ICE,channel,subchannel and cooler values)
	 */
	

	public class ReadingDataFromxl {

		/*
		 * Using function readingDataFromXL() read data from XL
		 * (Storenames,country,date,ICE,channel,subchannel and cooler values)
		 */

		/*
		 * public XLData readingDataFromXL(String readingFile) throws BiffException,
		 * IOException { String[] storeNameXL; Float[] iceValueXL; String[]
		 * channelXLbeforeconverting; String[] coolerXL; String[] countryXL;
		 * String[] dateXL; String[] channelXL; String[] subChannelXL; File fs = new
		 * File(readingFile); Workbook wb = Workbook.getWorkbook(fs); Sheet sh =
		 * wb.getSheet("Bahamas Onpremise data"); int row = sh.getRows(); int
		 * rowsCountXL = row; System.out.println("No of rows in XL" + "     " +
		 * rowsCountXL); countryXL = new String[rowsCountXL];
		 * channelXLbeforeconverting = new String[rowsCountXL]; coolerXL = new
		 * String[rowsCountXL]; dateXL = new String[rowsCountXL]; channelXL = new
		 * String[rowsCountXL]; subChannelXL = new String[rowsCountXL]; storeNameXL
		 * = new String[rowsCountXL]; iceValueXL = new Float[rowsCountXL]; String[]
		 * ice = new String[rowsCountXL]; String[] iceValueReplacingWithf = new
		 * String[rowsCountXL]; XLData xlData1 = new XLData(); for (int rwXL = 1;
		 * rwXL < rowsCountXL; rwXL++) { for (int str = 0; str < 1; str++) { Cell
		 * strNameXL = sh.getCell(str, rwXL); storeNameXL[rwXL] =
		 * strNameXL.getContents(); for (int clr = 1; clr < 2; clr++) { String S =
		 * "sin"; String C = "con"; Cell collr = sh.getCell(clr, rwXL);
		 * channelXLbeforeconverting[rwXL] = collr.getContents(); String[] chanNelXL
		 * = channelXLbeforeconverting[rwXL].split("\\s"); if
		 * (chanNelXL[1].contains(S)) { coolerXL[rwXL] = chanNelXL[1].replaceAll(S,
		 * "Yes"); } else { coolerXL[rwXL] = chanNelXL[1].replaceAll(C, "No"); } for
		 * (int iceclmn = 2; iceclmn < 3; iceclmn++) { Cell icXL =
		 * sh.getCell(iceclmn, rwXL); ice[rwXL] = icXL.getContents();
		 * iceValueReplacingWithf[rwXL] = ice[rwXL].replace('%', 'f');
		 * iceValueXL[rwXL] = Float.parseFloat(iceValueReplacingWithf[rwXL]); for
		 * (int co = 3; co < 4; co++) { Cell conTryXL = sh.getCell(co, rwXL);
		 * countryXL[rwXL] = conTryXL.getContents(); for (int dt = 4; dt < 5; dt++)
		 * { Cell dtXL = sh.getCell(dt, rwXL); dateXL[rwXL] = dtXL.getContents();
		 * for (int ch = 5; ch < 6; ch++) { Cell chanlXL = sh.getCell(ch, rwXL);
		 * channelXL[rwXL] = chanlXL.getContents(); for (int subch = 6; subch < 7;
		 * subch++) { Cell subChXL = sh.getCell(subch, rwXL); subChannelXL[rwXL] =
		 * subChXL.getContents(); } } } } } } }
		 * 
		 * } xlData1.setRowsXL(rowsCountXL); xlData1.setStoreNameXL(storeNameXL);
		 * xlData1.setIceXL(ice); xlData1.setCoolerXL(coolerXL);
		 * xlData1.setIcevalueXL(iceValueXL); xlData1.setCountryXL(countryXL);
		 * xlData1.setDateXL(dateXL); xlData1.setChannelXL(channelXL);
		 * xlData1.setSubchannelXL(subChannelXL); return xlData1; } }
		 */

		public XLData readingDataFromXL(String readingFile) throws BiffException, IOException {

			/*
			 * String[] storeNameXL; Float iceValueXL; String storeNameFromXL = null
			 * ; String iceValueFromXL; String[] channelXLbeforeconverting; String[]
			 * coolerXL; String[] countryXL; String[] dateXL; String[] channelXL;
			 * String[] subChannelXL;
			 */

			XLData xlData = new XLData();
			File fs = new File(readingFile);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Bahamas Traditional data");
			int row = sh.getRows();
			int rowsCountXL = row;
			System.out.println("No of rows in XL" + "     " + rowsCountXL);

			/*
			 * countryXL = new String[rowsCountXL]; channelXLbeforeconverting = new
			 * String[rowsCountXL]; coolerXL = new String[rowsCountXL]; dateXL = new
			 * String[rowsCountXL]; channelXL = new String[rowsCountXL];
			 * subChannelXL = new String[rowsCountXL]; storeNameXL = new
			 * String[rowsCountXL];
			 */

			// iceValueXL = new Float[rowsCountXL];
			// String[] ice = new String[rowsCountXL];
			
			// iceValueReplacingWithf[] =
			// HashMap<String, String> mapXL = new HashMap<String,String>();
			for (int rwXL = 1; rwXL < rowsCountXL; rwXL++) {
				String[] iceValueReplacingWithf = new String[7];
				// for (int str = 0; str < 1; str++) {
				Cell strNameXL = sh.getCell(0, rwXL);
				String storeName = strNameXL.getContents();
				// for (int clr = 1; clr < 2; clr++) {
				String S = " sin ";
				//String C = " con ";
				Cell collr = sh.getCell(1, rwXL);
				String channelXLbeforeconverting = collr.getContents();
				String channelXLAfterconverting = null;
				// String[] chanNelXL =
				// channelXLbeforeconverting[rwXL].split("\\s");
				if (channelXLbeforeconverting.contains(S)) {
					channelXLAfterconverting = "No";
				} else {
					channelXLAfterconverting = "Yes";
				}
				// for (int iceclmn = 2; iceclmn < 3; iceclmn++) {
				Cell icXL = sh.getCell(2, rwXL);
				String iceValueFromXL = icXL.getContents();
				// storeNameFromXL = strNameXL.getContents();
				String iceValue = iceValueFromXL.replace('%', 'f');
				// iceValueXL[rwXL] =
				// Float.parseFloat(iceValueReplacingWithf[rwXL]);*/
				// xlData.setICEvalues(storeNameFromXL,iceValueReplacingWithf);

				/*
				 * for (int co = 3; co < 4; co++) { Cell conTryXL = sh.getCell(co,
				 * rwXL); countryXL[rwXL] = conTryXL.getContents(); for (int dt = 4;
				 * dt < 5; dt++) { Cell dtXL = sh.getCell(dt, rwXL); dateXL[rwXL] =
				 * dtXL.getContents(); for (int ch = 5; ch < 6; ch++) { Cell chanlXL
				 * = sh.getCell(ch, rwXL); channelXL[rwXL] = chanlXL.getContents();
				 * for (int subch = 6; subch < 7; subch++) { Cell subChXL =
				 * sh.getCell(subch, rwXL); subChannelXL[rwXL] =
				 * subChXL.getContents(); } } } }
				 */
				// }
				// }
				// }
				iceValueReplacingWithf[0] = channelXLAfterconverting;

				Cell conTryXL = sh.getCell(3, rwXL);
				iceValueReplacingWithf[1] = conTryXL.getContents();

				Cell dtXL = sh.getCell(4, rwXL);
				iceValueReplacingWithf[2] = dtXL.getContents();

				Cell chanlXL = sh.getCell(5, rwXL);
				iceValueReplacingWithf[3] = chanlXL.getContents();

				Cell subChXL = sh.getCell(6, rwXL);
				iceValueReplacingWithf[4] = subChXL.getContents();

				iceValueReplacingWithf[5] = iceValue;

				iceValueReplacingWithf[6] = storeName;

				xlData.setICEvalues(storeName, iceValueReplacingWithf);

			}
			// xlData.setRowsXL(rowsCountXL);
			// xlData.setStoreNameXL(storeNameXL);
			// xlData.setIcevalueXL(ice);
			// xlData.setCoolerXL(coolerXL);
			// xlData.setIcevalueXL(iceValueXL);
			// xlData.getICEvalues(storeNameFromXL);
			// xlData.setCountryXL(countryXL);
			// xlData.setDateXL(dateXL);
			// xlData.setChannelXL(channelXL);
			// xlData.setSubchannelXL(subChannelXL);

			System.out.println(xlData);

			return xlData;
		}

	}
