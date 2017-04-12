package dataTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


	
	//WebDriver driver = new ChromeDriver();
	
		
	public class ComparingStoreLevelDataAndWritingXL {
		
		//WebDriver driver = new FirefoxDriver();
		//ReadingDataFromUI data = new ReadingDataFromUI();
		
		
			/*public void comparingAndWritingData(String writeFilePath,UIData dataUI,XLData xlData)
						throws IOException, WriteException {
					FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
					WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
					WritableSheet writeSheet = writeWorkBook.createSheet("BAHAMAS ON PREMISE", 2);
					String storeName = null;
					int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7, j = 8;
					Label country = new Label(a, 0, "COUNTRY");
					writeSheet.addCell(country);
					Label date = new Label(b, 0, "DATE");
					writeSheet.addCell(date);
					Label storeNameUI = new Label(c, 0, "STORE_NAME_UI");
					writeSheet.addCell(storeNameUI);
					Label channel = new Label(d, 0, "CHANNEL");
					writeSheet.addCell(channel);
					Label subChannel = new Label(e, 0, "SUB_CHANNEL");
					writeSheet.addCell(subChannel);
					Label cooler = new Label(f, 0, "COOLER");
					writeSheet.addCell(cooler);
					Label toTalUI = new Label(g, 0, "TOTAL_UI");
					writeSheet.addCell(toTalUI);
					Label ice = new Label(h, 0, "ICE");
					writeSheet.addCell(ice);
					Label resultColumnName = new Label(j, 0, "RESULT");
					writeSheet.addCell(resultColumnName);
					for (int i = 0; i < dataUI.getRowsCountUI(); i++) {
						Label result = null;
						//Label totalFromUI = new Label(g, i + 1, dataUI.getTotalBeforeConvertingUI()[i]);
						Float total = dataUI.getTotalUI(storeName);
						String totalFromUIString = Float.toString(total);
						Label totalFromUI = new Label(g, i + 1, totalFromUIString);
						writeSheet.addCell(totalFromUI);
						System.out.println("total of UI");
						for (int r = 1; r < xlData.rowCountXL; r++) {
							//if ((dataUI.getNamesUI()[i].replaceAll("[ ,]", "")).equalsIgnoreCase(xlData.getStoreNameXL()[r].replaceAll("[ ,]", ""))) {
								if (dataUI.getTotalUI(storeName).equals(xlData)){
							Label iceFromXL = new Label(h, i + 1, xlData.getIceXL()[r]);
								writeSheet.addCell(iceFromXL);
								Label countryFromXL = new Label(a, i + 1, xlData.getCountryXL()[r]);
								writeSheet.addCell(countryFromXL);
								Label dateFromXL = new Label(b, i + 1, xlData.getDateXL()[r]);
								writeSheet.addCell(dateFromXL);
								//Label storeNameFromUI = new Label(c, i + 1,dataUI.getNamesUI()[i] );
								Label storeNameFromUI = new Label(c, i + 1,dataUI.setTotalUI(storeName,total));
								writeSheet.addCell(storeNameFromUI);
								Label channelFromXL = new Label(d, i + 1, xlData.getChannelXL()[r]);
								writeSheet.addCell(channelFromXL);
								Label subChannelFromXL = new Label(e, i + 1, xlData.getSubchannelXL()[r]);
								writeSheet.addCell(subChannelFromXL);
								Label cooleRXL = new Label(f, i + 1, xlData.getCoolerXL()[r]);
								writeSheet.addCell(cooleRXL);
								//float diffBetweentotalUIAndIceValueXL = Math.abs(dataUI.getTotalUI()[i] - xlData.getIcevalueXL()[r]);
								float diffBetweentotalUIAndIceValueXL = Math.abs(dataUI.getTotalUI(storeName) - xlData.getIcevalueXL()[r]);
								if (diffBetweentotalUIAndIceValueXL >= 0.5) {
									result = new Label(j, i + 1, "Mismatch");

								} else {
									result = new Label(j, i + 1, "Match");

								}
							}
						}
						if (result == null) {
							result = new Label(j, i + 1, "Missing");

						}
						writeSheet.addCell(result);
					}
					writeWorkBook.write();
					writeWorkBook.close();
				}
	}*/
		public void comparingAndWritingData(String writeFilePath,UIData dataUI, XLData  xldata)
				throws IOException, WriteException {
			FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
			WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
			WritableSheet writeSheet = writeWorkBook.createSheet("Bahamas Traditional data", 2);
			int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7, j = 8;
			Label country = new Label(a, 0, "COUNTRY");
			writeSheet.addCell(country);
			Label date = new Label(b, 0, "DATE");
			writeSheet.addCell(date);
			Label storeNameUI = new Label(c, 0, "STORE_NAME_UI");
			writeSheet.addCell(storeNameUI);
			Label channel = new Label(d, 0, "CHANNEL");
			writeSheet.addCell(channel);
			Label subChannel = new Label(e, 0, "SUB_CHANNEL");
			writeSheet.addCell(subChannel);
			Label cooler = new Label(f, 0, "COOLER");
			writeSheet.addCell(cooler);
			Label toTalUI = new Label(g, 0, "TOTAL_UI");
			writeSheet.addCell(toTalUI);
			Label ice = new Label(h, 0, "ICE");
			writeSheet.addCell(ice);
			Label resultColumnName = new Label(j, 0, "RESULT");
			writeSheet.addCell(resultColumnName);
			
			String[] namesFromUI = dataUI.getNamesUI();
			
			for (int i = 0; i < namesFromUI.length; i++) {
				Label result = null;
				String namesUI = namesFromUI[i];
				Float totalUI = dataUI.getTotalUI(namesUI);
				System.out.println("total value in UI"+"   "+totalUI);
				String totalUIasString = Float.toString(totalUI);
				Label totalFromUI = new Label(g, i + 1,totalUIasString);
				writeSheet.addCell(totalFromUI);
				// System.out.println("total of UI");
				String[] xlValues = xldata.getICEvalues(namesUI);
				
				if (xlValues == null) {
					Label storeNameFromUI = new Label(c, i + 1, namesUI );
					writeSheet.addCell(storeNameFromUI);
					
					result = new Label(j, i + 1, "Missing in XL");

				} else {
				    String iceFromXl = xlValues[5];
					Label iceFromXL = new Label(h, i + 1, iceFromXl);
					writeSheet.addCell(iceFromXL);
					
					Label countryFromXL = new Label(a, i + 1, xlValues[1]);
					writeSheet.addCell(countryFromXL);
					Label dateFromXL = new Label(b, i + 1, xlValues[2]);
					writeSheet.addCell(dateFromXL);
					Label storeNameFromUI = new Label(c, i + 1,xlValues[6] );
					writeSheet.addCell(storeNameFromUI);
					Label channelFromXL = new Label(d, i + 1, xlValues[3]);
					writeSheet.addCell(channelFromXL);
					Label subChannelFromXL = new Label(e, i + 1, xlValues[4]);
					writeSheet.addCell(subChannelFromXL);
					Label cooleRXL = new Label(f, i + 1, xlValues[0]);
					writeSheet.addCell(cooleRXL);
					float diffBetweentotalUIAndIceValueXL = Math.abs(totalUI - Float.parseFloat(iceFromXl));
					if (diffBetweentotalUIAndIceValueXL >= 0.5) {
						result = new Label(j, i + 1, "Mismatch");

					} else {
						result = new Label(j, i + 1, "Match");

					}
				}
				
				/*
				for (int r = 1; r < xldata.getRowXL(); r++) {
					if ((dataUI.getNamesUI()[i].replaceAll("[ ,]", "")).equalsIgnoreCase(xldata.getStoreNameXL()[r].replaceAll("[ ,]", ""))) {
						String storenameXL[] = xldata.getStoreNameXL();
						String storesFromXL = storenameXL[r];
					Float iceValueXl = xldata.getICEvalues(storesFromXL);
					    String iceFromXl = String.valueOf(iceValueXl);
						Label iceFromXL = new Label(h, i + 1, iceFromXl);
						writeSheet.addCell(iceFromXL);
						Label countryFromXL = new Label(a, i + 1, xldata.getCountryXL()[r]);
						writeSheet.addCell(countryFromXL);
						Label dateFromXL = new Label(b, i + 1, xldata.getDateXL()[r]);
						writeSheet.addCell(dateFromXL);
						Label storeNameFromUI = new Label(c, i + 1,dataUI.getNamesUI()[i] );
						writeSheet.addCell(storeNameFromUI);
						Label channelFromXL = new Label(d, i + 1, xldata.getChannelXL()[r]);
						writeSheet.addCell(channelFromXL);
						Label subChannelFromXL = new Label(e, i + 1, xldata.getSubchannelXL()[r]);
						writeSheet.addCell(subChannelFromXL);
						Label cooleRXL = new Label(f, i + 1, xldata.getCoolerXL()[r]);
						writeSheet.addCell(cooleRXL);
						float diffBetweentotalUIAndIceValueXL = Math.abs(totalUI - iceValueXl);
						if (diffBetweentotalUIAndIceValueXL >= 0.5) {
							result = new Label(j, i + 1, "Mismatch");

						} else {
							result = new Label(j, i + 1, "Match");

						}
					}
				}
				if (result == null) {
					result = new Label(j, i + 1, "Missing");

				}
				*/
				writeSheet.addCell(result);
			}
			writeWorkBook.write();
			writeWorkBook.close();
		}
	}

