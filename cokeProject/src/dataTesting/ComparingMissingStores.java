package dataTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ComparingMissingStores {
	public void comparingAndWritingData(String writeFilePath, UIData dataUI, XLData xldata,String countryUI, String channelUI)
			throws IOException, WriteException {
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		WritableSheet writeSheet = writeWorkBook.createSheet("Bahamas Traditional data", 2);
		int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5;
		Label strName = new Label(a, 0, "STORENAME");
		writeSheet.addCell(strName);
		Label cnTry = new Label(b, 0, "COUNTRY");
		writeSheet.addCell(cnTry);
		Label chNel = new Label(c, 0, "CHANNEL");
		writeSheet.addCell(chNel);
		Label survY = new Label(d, 0, "SURVEY_SK");
		writeSheet.addCell(survY);
		Label custSk = new Label(e, 0, "CUST_SK");
		writeSheet.addCell(custSk);
		Label resuLT = new Label(f, 0, "RESULT");
		writeSheet.addCell(resuLT);
		

		String[] namesFromUI = dataUI.getNamesUI();
		int j=1;
		for (int i = 0; i < namesFromUI.length; i++) {
			String namesUI = namesFromUI[i];
			System.out.println("storesnamefromUI"+"      "+namesUI);
			String[] xlValues = xldata.getICEvalues(namesUI);
			System.out.println("xlValues"+"      "+xlValues);
			
			if (xlValues == null) {
				
				Label storeNameFromUI = new Label(a, j, namesUI);
				writeSheet.addCell(storeNameFromUI);
				Label result = new Label(f, j, "Missing in XL");
				writeSheet.addCell(result);
				Label custiD = new Label(e, j, dataUI.getCustID(namesUI));
				writeSheet.addCell(custiD);
				Label uICountry = new Label(b, j,countryUI);
				writeSheet.addCell(uICountry);
				Label uIChannel = new Label(c, j, channelUI);
				writeSheet.addCell(uIChannel);
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
				writeSheet.addCell(result);
				Label xlStores = new Label(a, j, namesFromXL);
				writeSheet.addCell(xlStores);
				String[] dataFromXL = xldata.getICEvalues(namesFromXL);
				String writeCountry = dataFromXL[1];
				Label xlcountry = new Label(b, j, writeCountry);
				writeSheet.addCell(xlcountry);
				String channelXL = dataFromXL[8];
				Label xlchannel = new Label(c, j, channelXL);
				writeSheet.addCell(xlchannel);
				String xlSurvy = dataFromXL[7];
				Label xlsurvey = new Label(d, j, xlSurvy);
				writeSheet.addCell(xlsurvey);
				j++;
			}

		}

		writeWorkBook.write();
		writeWorkBook.close();
		System.out.println("Comparing store level data and writing to XL");
	}

}
