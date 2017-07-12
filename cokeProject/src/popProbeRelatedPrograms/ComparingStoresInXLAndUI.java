package popProbeRelatedPrograms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataTesting.PopprobeLogin;
import dataTesting.UIData;
import dataTesting.XLData;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ComparingStoresInXLAndUI {

	public void comparingAndWritingData(String writeFilePath, DataFromUI uIData, DatafromXL xLData)
			throws IOException, WriteException {
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		WritableSheet writeSheet = writeWorkBook.createSheet("Haiti", 2);
		int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5;
		Label strName = new Label(a, 0, "STORENAME");
		writeSheet.addCell(strName);
		Label country = new Label(b, 0, "COUNTRY");
		writeSheet.addCell(country);
		Label channel = new Label(c, 0, "CHANNEL");
		writeSheet.addCell(channel);
		Label survey = new Label(d, 0, "SURVEY_SK");
		writeSheet.addCell(survey);
		Label cust = new Label(e, 0, "CUST_SK");
		writeSheet.addCell(cust);
		Label resultclmname = new Label(f, 0, "RESULT");
		writeSheet.addCell(resultclmname);
		String[] namesFromUI = uIData.getNamesUI();
		for (int i = 0; i < namesFromUI.length; i++) {
			Label result = null;
			String namesUI = namesFromUI[i];
			/*String[] namesFromXL = xLData.getSurveySK(storenameXL);
			
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
		System.out.println("Comparing store level data and writing to XL");
	}
}*/
		}}		
}



