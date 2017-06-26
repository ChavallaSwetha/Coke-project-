package popProbeRelatedPrograms;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadingFromXL {

	public DatafromXL readingFromXL(String readingFile,String countryFromXL, String channelFromXL) throws BiffException, IOException{
		DatafromXL xLData = new DatafromXL();
		File fs = new File(readingFile);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet("Stores");
		int row = sh.getRows();
		int rowsCountXL = row;
		System.out.println("No of rows in XL" + "     " + rowsCountXL);
		for (int rwXL = 1; rwXL < rowsCountXL; rwXL++) {
			
			Cell conTryXL = sh.getCell(20, rwXL);
			String country = conTryXL.getContents();
			
			if (country.equals(countryFromXL)){
			String S = " sin ";
			Cell collr = sh.getCell(8, rwXL);
			String channelXLbeforeconverting = collr.getContents();
			String channelXL = channelFromXL.toLowerCase();
			if (channelXLbeforeconverting.endsWith(channelFromXL)){
			String channelXLAfterconverting = null;
			
		if (channelXLbeforeconverting.contains(S)) {
				channelXLAfterconverting = "No";
			} else {
				channelXLAfterconverting = "Yes";
			}
		String channel=channelXLbeforeconverting;
		System.out.println("channel" + "   "+ channel);
	     	Cell strNameXL = sh.getCell(2, rwXL);
		   String storeXL = strNameXL.getContents();
		    System.out.println("Stores" + "   "+ storeXL);
		    Cell suryNo = sh.getCell(0, rwXL);
		    String surveyXL = suryNo.getContents();
		    System.out.println("Survey No"+"   "+ surveyXL);
		 //   xLData.setSurveySK(storeXL, surveyXL[]);

	}
			
			}
		}
	
	return xLData;
	}
}
