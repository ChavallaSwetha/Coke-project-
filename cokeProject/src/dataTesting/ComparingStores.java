package dataTesting;



import java.io.FileOutputStream;
import java.io.IOException;





import jxl.Workbook;


import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;



public class ComparingStores {

	
		public void comparingAndWritingData(String writeFilePath, UIData dataUI, XLData xldata)
				throws IOException, WriteException {
			FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
			WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
			WritableSheet writeSheet = writeWorkBook.createSheet("Haiti", 2);
			int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5;
			Label strName = new Label(a, 0, "STORENAME");
			writeSheet.addCell(strName);
			Label couunTry = new Label(b, 0, "COUNTRY");
			writeSheet.addCell(couunTry);
			Label channel = new Label(c, 0, "CHANNEL");
			writeSheet.addCell(channel);
			Label survySK = new Label(d, 0, "SURVEY_SK");
			writeSheet.addCell(survySK);
			Label custSK = new Label(e, 0, "CUST_SK");
			writeSheet.addCell(custSK);
			Label resulT = new Label(f, 0, "RESULT");
			writeSheet.addCell(resulT);
			
			String[] namesFromUI = dataUI.getNamesUI();
			String[] storesXL1 = xldata.getNamesXL();
			for (int i = 0; i < namesFromUI.length; i++) {
				Label result = null;
				boolean found1 = false;
				String namesUI = namesFromUI[i];
				
				//String[] xlValues = xldata.getNamesXL();
				
				for (int z=0; z<storesXL1.length; z++){
				if (storesXL1[i].equals(namesFromUI[z])) {
					found1 = true;
				}
			}
			if (!found1){
					Label storeNameFromUI = new Label(a, i + 1, namesUI);
					writeSheet.addCell(storeNameFromUI);
					result = new Label(f, i + 1, "Missing in XL");
					writeSheet.addCell(result);
					/*Label countryFromXL = new Label(b, i + 1, xlValues[1]);
					writeSheet.addCell(countryFromXL);
					Label channelFromXL = new Label(c, i + 1, xlValues[3]);
					writeSheet.addCell(channelFromXL);
					Label survyNo = new Label(d, i+1, xlValues[7]);
					writeSheet.addCell(survyNo);*/
				} 
			
			}
				
				String[] storesXL = xldata.getNamesXL();
				String[] namesofUI = dataUI.getNamesUI();
				String uIStores = null;
				for (int x=0; x<storesXL.length; x++){
					boolean found = false;
					String storeFromXL = storesXL[x];
					for (int y=0; y<namesFromUI.length; y++){
						String storesOfUI = namesofUI[y];
						uIStores = storesOfUI;
					  if (storeFromXL.equals(storesOfUI)){
							found = true;
						}
					}
					System.out.println(uIStores);
					if (!found){
						String custUI = dataUI.getCustUI(uIStores);
						Label storeNameFromUI = new Label(a, x + 1, uIStores);
						writeSheet.addCell(storeNameFromUI);
						Label result1 = new Label(f, x + 1, "Missing in UI");
						writeSheet.addCell(result1);
						/*Label countryFromXL = new Label(b, x + 1, xlValues[1]);
						writeSheet.addCell(countryFromXL);
						Label channelFromXL = new Label(c, x + 1, xlValues[3]);
						writeSheet.addCell(channelFromXL);*/
						Label custNO = new Label(e, x + 1, custUI);
						writeSheet.addCell(custNO);
					}
				}
			

			writeWorkBook.write();
			writeWorkBook.close();
			System.out.println("Comparing store level data and writing to XL");
			}
	}