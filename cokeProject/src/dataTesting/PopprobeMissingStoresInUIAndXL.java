package dataTesting;

import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeMissingStoresInUIAndXL {

	public static void main(String[] args)
			throws InterruptedException, BiffException, IOException, WriteException, AWTException {

		/*
		 * String[] countriesFromUI = { "BARBADOS","BAHAMAS","FRENCH GUIANA"
		 * ,"GUADELOUPE","GUYANA","JAMAICA","MARTINIQUE","SURINAME",
		 * "TRINIDAD Y TOBAGO" }; String[] countriesFromExcel = {
		 * "Barbados","Bahamas","French Guiana"
		 * ,"Guadeloupe","Guyana","Jamaica","Martinique","Suriname",
		 * "Trinidad & Tobago" };
		 */
		String[] countriesFromUI = { "BELIZE", "HAITI" };
		String[] countriesFromExcel = { "Belize", "Haiti" };
		String date = "2017 - 6";
		String channelFromXL = "tradicional";
		String channel = "HOME MARKET TRADITIONAL";
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Caribbean ICE Results June 2017.xls";
		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Data_of_Popprobe/Belize_Haiti_Missing_Store_List_June.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		for (int i = 0; i < countriesFromUI.length; i++) {
			PopprobeLogin login = new PopprobeLogin();
			login.logIn(driver);

			login.selectDropDowns(driver, date, countriesFromUI[i], channel);
			// login.selectDropDowns(driver,date, countriesFromUI[i]);
			ComparingMissingStores missingStores = new ComparingMissingStores();
			ReadingDataFromUI namesAndTotal = new ReadingDataFromUI();
			UIData dataUI = namesAndTotal.readingDataFromUI(driver);
			ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
			XLData xldata = storeAndIce.readingDataFromXL(readFilePath, countriesFromExcel[i], channelFromXL);
			missingStores.comparingAndWritingData(writeFilePath, writeWorkBook, dataUI, xldata, countriesFromUI[i],
					channel, i);
			login.logout(driver);

		}
		writeWorkBook.write();
		writeWorkBook.close();

	}

}
