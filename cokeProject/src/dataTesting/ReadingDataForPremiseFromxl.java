package dataTesting;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadingDataForPremiseFromxl {
	public XLData readingDataFromXL(String readingFile, String countryFromXL, String channelFromXL, String mpaChannelXL,String  soviChannelXL,String refregiratioChannelXL,String commuNionChannelXL,String priCeChannelXL,String freshNESsChannelXL)
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
						dataFromXL = new String[20];
						xlData.setICEvalues(storeName, dataFromXL);

					}

					Cell collr = sh.getCell(8, rwXL);
					String kpis = collr.getContents();
					

					if (kpis.equals(mpaChannelXL)) {
						Cell icXL = sh.getCell(9, rwXL);
						String iceMPAXL = icXL.getContents();
						String iceMPAValue = iceMPAXL.replace('%', 'f');
						dataFromXL[4] = iceMPAValue;
					} else if (kpis.equals(soviChannelXL)) {
						Cell icXL = sh.getCell(9, rwXL);
						String iceSOVIXL = icXL.getContents();
						String iceSOVIValue = iceSOVIXL.replace('%', 'f');
						dataFromXL[5] = iceSOVIValue;
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
					} else if (kpis.equals(priCeChannelXL)) {
						Cell icXL = sh.getCell(9, rwXL);
						String icePRICXL = icXL.getContents();
						String icePRICValue = icePRICXL.replace('%', 'f');
						dataFromXL[8] = icePRICValue;
					} else if (kpis.equals(freshNESsChannelXL)) {
						Cell icXL = sh.getCell(9, rwXL);
						String iceFRESHXL = icXL.getContents();
						String iceFRESHValue = iceFRESHXL.replace('%', 'f');
						dataFromXL[9] = iceFRESHValue;
					} else if (kpis.contains(channelFromXL)) {
						if (kpis.contains(S)) {
							kpisAfterConverting = "no";
						} else {
							kpisAfterConverting = "yes";
						}
      					dataFromXL[1] = country;
						dataFromXL[2] = channelXL;
						dataFromXL[3] = storeName;
						dataFromXL[10] = kpisAfterConverting;
						Cell survyNo = sh.getCell(0, rwXL);
						String survyNO = survyNo.getContents();
						dataFromXL[16] = survyNO;
						Cell icXL = sh.getCell(9, rwXL);
						String iceValueFromXL = icXL.getContents();
						String iceValue = iceValueFromXL.replace('%', 'f');
						dataFromXL[14] = iceValue;
						Cell dtXL = sh.getCell(5, rwXL);
						dataFromXL[11] = dtXL.getContents();
						//Cell subChXL = sh.getCell(28, rwXL);
						Cell subChXL = sh.getCell(26, rwXL);
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

		// System.out.println("Reading data from XL");
		System.out.println(xlData);

		return xlData;

	}
}
