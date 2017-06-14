package dataTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ComparingMissingStores {
	public void comparingAndWritingData(String writeFilePath,WritableWorkbook writeWorkBook, UIData dataUI, XLData xldata,String countryUI, String channelUI,int sh)
			throws IOException, WriteException {
		
		WritableSheet writableSheet = writeWorkBook.createSheet(countryUI, sh);
		System.out.println("countryUI"+"   "+countryUI);
		System.out.println("SheetNo"+"   "+sh);
		
		int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5;
		Label strName = new Label(a, 0, "STORENAME");
		writableSheet.addCell(strName);
		Label cnTry = new Label(b, 0, "COUNTRY");
		writableSheet.addCell(cnTry);
		Label chNel = new Label(c, 0, "CHANNEL");
		writableSheet.addCell(chNel);
		Label survY = new Label(d, 0, "SURVEY_SK");
		writableSheet.addCell(survY);
		Label custSk = new Label(e, 0, "CUST_SK");
		writableSheet.addCell(custSk);
		Label resuLT = new Label(f, 0, "RESULT");
		writableSheet.addCell(resuLT);
		/*Label Name = new Label(a, 0, "STORENAME");
		writableSheet1.addCell(Name);
		Label str = new Label(a, 0, "STORENAME");
		writableSheet2.addCell(str);*/
		

		String[] namesFromUI = dataUI.getNamesUI();
		int j=1;
		for (int i = 0; i < namesFromUI.length; i++) {
			String namesUI = namesFromUI[i];
			System.out.println("storesnamefromUI"+"      "+namesUI);
			String[] xlValues = xldata.getICEvalues(namesUI);
			System.out.println("xlValues"+"      "+xlValues);
			
			if (xlValues == null) {
				
				Label storeNameFromUI = new Label(a, j, namesUI);
				writableSheet.addCell(storeNameFromUI);
				Label result = new Label(f, j, "Missing in XL");
				writableSheet.addCell(result);
				Label custiD = new Label(e, j, dataUI.getCustUI(namesUI));
				writableSheet.addCell(custiD);
				Label uICountry = new Label(b, j,countryUI);
				writableSheet.addCell(uICountry);
				Label uIChannel = new Label(c, j, channelUI);
				writableSheet.addCell(uIChannel);
				j++;
			}
			
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
			if(!found){
				Label result = new Label(f, j, "Missing in UI");
				writableSheet.addCell(result);
				Label xlStores = new Label(a, j, namesFromXL);
				writableSheet.addCell(xlStores);
				String[] dataFromXL = xldata.getICEvalues(namesFromXL);
				String writeCountry = dataFromXL[1];
				Label xlcountry = new Label(b, j, writeCountry);
				writableSheet.addCell(xlcountry);
				String channelXL = dataFromXL[8];
				Label xlchannel = new Label(c, j, channelXL);
				writableSheet.addCell(xlchannel);
				String xlSurvy = dataFromXL[7];
				Label xlsurvey = new Label(d, j, xlSurvy);
				writableSheet.addCell(xlsurvey);
				j++;
			}

		}

		
		System.out.println("Comparing store level data and writing to XL");
		}
		   
}