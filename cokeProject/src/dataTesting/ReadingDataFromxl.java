/*package dataTesting;


import java.io.File;

import java.io.IOException;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;


 * Using function readingDataFromXL() read data from XL (Storenames,country,date,ICE,channel,subchannel and cooler values)
 

public class ReadingDataFromxl {
	public XLData readingDataFromXL(String readingFile, String countryFromXL, String channelFromXL)
			throws BiffException, IOException {
		XLData xlData = new XLData();
		File fs = new File(readingFile);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet("Stores");
		int row = sh.getRows();
		int rowsCountXL = row;
		System.out.println("No of rows in XL" + "     " + rowsCountXL);
		for (int rwXL = 1; rwXL < rowsCountXL; rwXL++) {
			String[] xlDataArray = new String[10];
			Cell conTryXL = sh.getCell(20, rwXL);
			xlDataArray[1] = conTryXL.getContents();

			if (xlDataArray[1].equals(countryFromXL)) {

				String S = " sin ";
				Cell collr = sh.getCell(8, rwXL);
				String channelXLbeforeconverting = collr.getContents();
				String channelXL = channelXLbeforeconverting.toLowerCase();
				String channelXLAfterconverting = null;
				if (channelXL.endsWith(channelFromXL)) {
					System.out.println("excel row chaneel " + channelXL);
					if (channelXLbeforeconverting.contains(S)) {
						channelXLAfterconverting = "no";
					} else {
						channelXLAfterconverting = "yes";
					}

					Cell survyNo = sh.getCell(0, rwXL);
					String survyNO = survyNo.getContents();
					Cell strNameXL = sh.getCell(2, rwXL);
					String storeName = strNameXL.getContents();
					Cell icXL = sh.getCell(9, rwXL);
					String iceValueFromXL = icXL.getContents();
					String iceValue = iceValueFromXL.replace('%', 'f');
					xlDataArray[0] = channelXLAfterconverting;
					Cell dtXL = sh.getCell(5, rwXL);
					xlDataArray[2] = dtXL.getContents();
					Cell chanlXL = sh.getCell(26, rwXL);
					xlDataArray[3] = chanlXL.getContents();
					Cell subChXL = sh.getCell(28, rwXL);
					xlDataArray[4] = subChXL.getContents();
					Cell railXL = sh.getCell(4, rwXL);
					String railFromXL = railXL.getContents();
					String remove = "Enrejado";
					String railAfterConvert = railFromXL.replace(remove, "");
					String railAfterConverting = railAfterConvert.replaceAll(" ", "");
					//xlDataArray[9] = railAfterConverting;
					xlDataArray[9] = railAfterConverting.toUpperCase();
					xlDataArray[5] = iceValue;
					xlDataArray[6] = storeName;
					xlDataArray[7] = survyNO;
					xlDataArray[8] = channelXLbeforeconverting;
					System.out.println("storesfromXL" + "      " + xlDataArray[6]);
					xlData.setICEvalues(storeName, xlDataArray);
				}
			}
		}

		System.out.println("Reading data from XL");
		System.out.println(xlData);

		return xlData;
	}

}*/

package dataTesting;

import java.io.File;

import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

/*
 * Using function readingDataFromXL() read data from XL (Storenames,country,date,ICE,channel,subchannel and cooler values)
 */

public class ReadingDataFromxl {
	public XLData readingDataFromXL(String readingFile, String countryFromXL, String channelFromXL, String mpaChannelXL,String  soviChannelXL,String refregiratioChannelXL,String commuNionChannelXL,String colDAChannelXL,String comBOChannelXL)
			throws BiffException, IOException {
		
		String kpisAfterConverting = null;
		XLData xlData = new XLData();
		File fs = new File(readingFile);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet("Stores");
		int row = sh.getRows();
		int rowsCountXL = row;
		String S = " sin ";
		// System.out.println("No of rows in XL" + " " + rowsCountXL);
		for (int rwXL = 1; rwXL < rowsCountXL; rwXL++) {

			//Cell conTryXL = sh.getCell(20, rwXL);
			Cell conTryXL = sh.getCell(18, rwXL); // For Jan Data
			String country = conTryXL.getContents();

			if (country.equals(countryFromXL)) {
				//Cell chanelXL = sh.getCell(26, rwXL);
				Cell chanelXL = sh.getCell(24, rwXL); // For Jan Data
				String channelXL = chanelXL.getContents();

				// channelXL = tradicional or premise, channelFromXL = channel
				// which we have to give traditional or premise.
				if (channelXL.contains(channelFromXL)) {

					Cell strXL = sh.getCell(2, rwXL);
					String storeName = strXL.getContents();

					String[] dataFromXL = xlData.getICEvalues(storeName);

					if (dataFromXL == null) {
						dataFromXL = new String[23];
						xlData.setICEvalues(storeName, dataFromXL);

					}

					Cell collr = sh.getCell(8, rwXL);
					String kpis = collr.getContents();
					// String kpis = kpi.toLowerCase();

					if (kpis.equals(mpaChannelXL)) {
						// System.out.println("Channel mpa"+" "+xlDataArray[4]);
						Cell icXL = sh.getCell(9, rwXL);
						String iceMPAXL = icXL.getContents();
						String iceMPAValue = iceMPAXL.replace('%', 'f');
						dataFromXL[4] = iceMPAValue;
						//System.out.println("iceMPAValue"+" "+iceMPAValue);

					} else if (kpis.equals(soviChannelXL)) {
						
						Cell icXL = sh.getCell(9, rwXL);
						String iceSOVIXL = icXL.getContents();
						String iceSOVIValue = iceSOVIXL.replace('%', 'f');
						dataFromXL[5] = iceSOVIValue;
						//System.out.println("iceSOVIValue"+" "+iceSOVIValue);
					} else if (kpis.equals(refregiratioChannelXL)) {
						
						Cell icXL = sh.getCell(9, rwXL);
						String iceREFXL = icXL.getContents();
						String iceREFValue = iceREFXL.replace('%', 'f');
						dataFromXL[6] = iceREFValue;
					} else if (kpis.equals(commuNionChannelXL)) {
						
						Cell icXL = sh.getCell(9, rwXL);
						String iceCOMMXL = icXL.getContents();
						String iceCOMMValue = iceCOMMXL.replace('%', 'f');
						dataFromXL[7] = iceCOMMValue;
					} else if (kpis.equals(colDAChannelXL)) {
						
						Cell icXL = sh.getCell(9, rwXL);
						String icePRICXL = icXL.getContents();
						String icePRICValue = icePRICXL.replace('%', 'f');
						dataFromXL[8] = icePRICValue;
					} else if (kpis.equals(comBOChannelXL)) {
						
						Cell icXL = sh.getCell(9, rwXL);
						String iceFRESHXL = icXL.getContents();
						String iceFRESHValue = iceFRESHXL.replace('%', 'f');
						dataFromXL[9] = iceFRESHValue;
					} else if (kpis.contains(channelFromXL)) {
						
						if (kpis.contains(S)) {
							//System.out.println("excel row chaneel " + kpis);
							kpisAfterConverting = "no";
						} else {
							kpisAfterConverting = "yes";
						}

						dataFromXL[1] = country;
						dataFromXL[2] = channelXL;
						dataFromXL[3] = storeName;
						//dataFromXL[10] = kpis;
						dataFromXL[10] = kpisAfterConverting;
						Cell survyNo = sh.getCell(0, rwXL);
						String survyNO = survyNo.getContents();
						dataFromXL[16] = survyNO;
						Cell icXL = sh.getCell(9, rwXL);
						String iceValueFromXL = icXL.getContents();
						String iceValue = iceValueFromXL.replace('%', 'f');
						dataFromXL[14] = iceValue;
						System.out.println("iceValue"+" "+iceValue);
						Cell dtXL = sh.getCell(5, rwXL);
						dataFromXL[11] = dtXL.getContents();
						//Cell subChXL = sh.getCell(28, rwXL);
						Cell subChXL = sh.getCell(26, rwXL); // For Jan Data
						dataFromXL[12] = subChXL.getContents();
						Cell railXL = sh.getCell(4, rwXL);
						String railFromXL = railXL.getContents();
						String remove = "Enrejado";
						String railAfterConvert = railFromXL.replace(remove, "");
						String railAfterConverting = railAfterConvert.replaceAll(" ", "");
						dataFromXL[13] = railAfterConverting.toUpperCase();

					}

					//xlData.setICEvalues(storeName, dataFromXL);
				}
			}
		}

		System.out.println("Reading data from XL");
		//System.out.println(xlData);

		return xlData;

	}
}