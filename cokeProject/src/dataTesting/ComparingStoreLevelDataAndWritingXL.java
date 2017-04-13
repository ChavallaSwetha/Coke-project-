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
	public void comparingAndWritingData(String writeFilePath, UIData dataUI, XLData xldata)
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
			System.out.println("total value in UI" + "   " + totalUI);
			String totalUIasString = Float.toString(totalUI);
			Label totalFromUI = new Label(g, i + 1, totalUIasString);
			writeSheet.addCell(totalFromUI);
			String[] xlValues = xldata.getICEvalues(namesUI);
			if (xlValues == null) {
				Label storeNameFromUI = new Label(c, i + 1, namesUI);
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
				Label storeNameFromUI = new Label(c, i + 1, xlValues[6]);
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
			writeSheet.addCell(result);
		}
		writeWorkBook.write();
		writeWorkBook.close();
	}
}
