package dataTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeComparingStoreLevelPremiseData {
	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException {

		String[] countriesFromUI = { "BAHAMAS"  ,"BARBADOS","FRENCH GUIANA","GUYANA","GUADELOUPE","JAMAICA","MARTINIQUE","SURINAME","TRINIDAD Y TOBAGO"};
		String[] countriesFromExcel = { "Bahamas" ,"Barbados","French Guiana","Guyana","Guadeloupe","Jamaica","Martinique","Suriname","Trinidad & Tobago"};
		String date = "2017 - 1";
		String channelFromXL = "On Premise";
		String channel = "ON PREMISE";

		String mpaChannelXL = "Portafolio Prioritario";
		String soviChannelXL = "SOVI";
		String refregiratioChannelXL = "Refrigeración";
		String commuNionChannelXL = "Comunicación";
		String colDAvChannelXL = "Disponibilidad en Frío";
		String comBoChannelXL = "Combos";

		String readFilePath = "C:/Users/Swetha/Downloads/Caribbean ICE Results January 2017 (1).xls";
		String writeFilePath = "C:/Users/Swetha/Downloads/Data_Of_Popprobe/All_Countries_Premise_Data.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		System.setProperty("webdriver.chrome.driver", "C:/Users/Swetha/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		for (int i = 0; i < countriesFromUI.length; i++) {
			PopprobeLogin login = new PopprobeLogin();
			login.logIn(driver);

			login.selectDropDowns(driver, date, countriesFromUI[i], channel);
			ComparingStoreLevelPremiseDataAndWritingXL compare = new ComparingStoreLevelPremiseDataAndWritingXL();
			ReadingDataFromUI namesAndTotal = new ReadingDataFromUI();
			UIData dataUI = namesAndTotal.readingDataFromUI(driver);
			ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
			XLData xldata = storeAndIce.readingDataFromXL(readFilePath, countriesFromExcel[i], channelFromXL,
					mpaChannelXL, soviChannelXL, refregiratioChannelXL, commuNionChannelXL, colDAvChannelXL, comBoChannelXL
					);
			compare.comparingAndWritingData(writeFilePath, writeWorkBook, dataUI, xldata, countriesFromUI[i], channel,
					i);
			login.logout(driver);
		}
		writeWorkBook.write();
		writeWorkBook.close();
	}
}
