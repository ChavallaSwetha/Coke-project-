package dataTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;



	/*
	 * Using function readingDataFromXL() read data from XL (Storenames,country,date,ICE,channel,subchannel and cooler values)
	 */
	

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
				String[] iceValueReplacingWithf = new String[9];
				Cell conTryXL = sh.getCell(20, rwXL);
				iceValueReplacingWithf[1] = conTryXL.getContents();

				if (iceValueReplacingWithf[1].equals(countryFromXL)) {

					String S = " sin ";
					Cell collr = sh.getCell(8, rwXL);
					String channelXLbeforeconverting = collr.getContents();
					String channelXL = channelXLbeforeconverting.toLowerCase();
					String channelXLAfterconverting = null;
					if (channelXL.endsWith(channelFromXL)) {
						System.out.println("excel row chaneel "+channelXL);
						if (channelXLbeforeconverting.contains(S)) {
							channelXLAfterconverting = "No";
						} else {
							channelXLAfterconverting = "Yes";
						}

						Cell survyNo = sh.getCell(0, rwXL);
						String survyNO = survyNo.getContents();
						Cell strNameXL = sh.getCell(2, rwXL);
						String storeName = strNameXL.getContents();
						Cell icXL = sh.getCell(9, rwXL);
						String iceValueFromXL = icXL.getContents();
						String iceValue = iceValueFromXL.replace('%', 'f');
						iceValueReplacingWithf[0] = channelXLAfterconverting;
						Cell dtXL = sh.getCell(5, rwXL);
						iceValueReplacingWithf[2] = dtXL.getContents();
						Cell chanlXL = sh.getCell(26, rwXL);
						iceValueReplacingWithf[3] = chanlXL.getContents();
						Cell subChXL = sh.getCell(28, rwXL);
						iceValueReplacingWithf[4] = subChXL.getContents();
						iceValueReplacingWithf[5] = iceValue;
						iceValueReplacingWithf[6] = storeName;
						iceValueReplacingWithf[7] = survyNO;
						iceValueReplacingWithf[8] = channelXLbeforeconverting;
						System.out.println("storesfromXL" + "      " + iceValueReplacingWithf[6]);
						xlData.setICEvalues(storeName, iceValueReplacingWithf);
					}
				}
			}

			System.out.println("Reading data from XL");
			System.out.println(xlData);

			return xlData;
		}

	}