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
		/*public XLData readingDataFromXL(String readingFile) throws BiffException, IOException {
			XLData xlData = new XLData();
			File fs = new File(readingFile);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Bahamas Traditional data");
			int row = sh.getRows();
			int rowsCountXL = row;
			System.out.println("No of rows in XL" + "     " + rowsCountXL);
			for (int rwXL = 1; rwXL < rowsCountXL; rwXL++) {
				String[] iceValueReplacingWithf = new String[7];
				Cell strNameXL = sh.getCell(0, rwXL);
				String storeName = strNameXL.getContents();
				String S = " sin ";
				Cell collr = sh.getCell(1, rwXL);
				String channelXLbeforeconverting = collr.getContents();
				String channelXLAfterconverting = null;
			if (channelXLbeforeconverting.contains(S)) {
					channelXLAfterconverting = "No";
				} else {
					channelXLAfterconverting = "Yes";
				}
				Cell icXL = sh.getCell(2, rwXL);
				String iceValueFromXL = icXL.getContents();
				String iceValue = iceValueFromXL.replace('%', 'f');
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
			System.out.println(xlData);
			return xlData;
		}*/
		
		public XLData readingDataFromXL(String readingFile,String countryFromXL,String channelFromXL) throws BiffException, IOException {
			XLData xlData = new XLData();
			File fs = new File(readingFile);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Stores");
			int row = sh.getRows();
			int rowsCountXL = row;
			System.out.println("No of rows in XL" + "     " + rowsCountXL);
			/*String countryFromXL = "Barbados";
			String channel = "Tradicional";*/
			
			
			for (int rwXL = 1; rwXL < rowsCountXL; rwXL++) {
				String[] iceValueReplacingWithf = new String[7];
				Cell conTryXL = sh.getCell(20, rwXL);
				
				iceValueReplacingWithf[1] = conTryXL.getContents();
				if (iceValueReplacingWithf[1].equals(countryFromXL)){
				System.out.println(iceValueReplacingWithf[1]);
				String S = " sin ";
				Cell collr = sh.getCell(8, rwXL);
				String channelXLbeforeconverting = collr.getContents();
				if (channelXLbeforeconverting.endsWith(channelFromXL)){
				String channelXLAfterconverting = null;
			if (channelXLbeforeconverting.contains(S)) {
					channelXLAfterconverting = "No";
				} else {
					channelXLAfterconverting = "Yes";
				}
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
				xlData.setICEvalues(storeName, iceValueReplacingWithf);
			}
				}
			}
			System.out.println(xlData);
			return xlData;
		}
			
		
	}
