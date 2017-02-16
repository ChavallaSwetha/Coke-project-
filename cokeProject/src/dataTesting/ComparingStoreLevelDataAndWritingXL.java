package dataTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ComparingStoreLevelDataAndWritingXL {
	
	WebDriver driver = new FirefoxDriver();
		
	public void comparingAndWritingData(String writeFilePath,UIData dataUI,XLData  xldata)
			throws IOException, WriteException {
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		WritableSheet writeSheet = writeWorkBook.createSheet("BAHAMAS ON PREMISE", 2);
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
		String[] totalString = dataUI.getTotalBeforeConvertingUI();
		String[] namesUI = dataUI.getNamesUI();
		Float[] totalUI = dataUI.getTotalUI();
		for (int i = 0; i < dataUI.getRowsCountUI(); i++) {
			Label result = null;
			Label totalFromUI = new Label(g, i + 1, totalString[i]);
			writeSheet.addCell(totalFromUI);
			System.out.println("total of UI");
			for (int r = 1; r < xldata.rowCountXL; r++) {
				if ((namesUI[i].replaceAll("[ ,]", "")).equalsIgnoreCase(xldata.getStoreNameXL()[r].replaceAll("[ ,]", ""))) {
					Label iceFromXL = new Label(h, i + 1, xldata.getIceXL()[r]);
					writeSheet.addCell(iceFromXL);
					Label countryFromXL = new Label(a, i + 1, xldata.getCountryXL()[r]);
					writeSheet.addCell(countryFromXL);
					Label dateFromXL = new Label(b, i + 1, xldata.getDateXL()[r]);
					writeSheet.addCell(dateFromXL);
					Label storeNameFromUI = new Label(c, i + 1,namesUI[i] );
					writeSheet.addCell(storeNameFromUI);
					Label channelFromXL = new Label(d, i + 1, xldata.getChannelXL()[r]);
					writeSheet.addCell(channelFromXL);
					Label subChannelFromXL = new Label(e, i + 1, xldata.getSubchannelXL()[r]);
					writeSheet.addCell(subChannelFromXL);
					Label cooleRXL = new Label(f, i + 1, xldata.getCoolerXL()[r]);
					writeSheet.addCell(cooleRXL);
					float diffBetweentotalUIAndIceValueXL = Math.abs(dataUI.getTotalUI()[i] - xldata.getIcevalueXL()[r]);
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
}
