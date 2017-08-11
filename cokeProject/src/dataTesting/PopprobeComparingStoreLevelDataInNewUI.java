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

public class PopprobeComparingStoreLevelDataInNewUI {
	public static void main(String[] args)
			throws InterruptedException, BiffException, IOException, WriteException, AWTException {
		String[] countriesFromUI = { "BARBADOS"};//,"BAHAMAS","FRENCH GUIANA","GUYANA","GUADELOUPE","JAMAICA","MARTINIQUE","SURINAME","TRINIDAD Y TOBAGO" }; 
		String[] countriesFromExcel = {"Barbados"};//,"Bahamas","French Guiana","Guyana","Guadeloupe","Jamaica","Martinique","Suriname","Trinidad & Tobago" };
		String date = "2017 - 6";
		String channelFromXL = "premise";
		String channel = "ON PREMISE";
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Caribbean ICE Results June 2017.xls";
		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Data_of_Popprobe/All_Countries_Premise_Data_June.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			for (int i = 0; i < countriesFromUI.length; i++) {
			PopprobeNewLogin login = new PopprobeNewLogin();
			login.logIn(driver);
			ReadingDataFromNewUI namesAndTotal = new ReadingDataFromNewUI();
			UIData dataUI = namesAndTotal.readingDataFromUI(driver,date, countriesFromUI[0], channel);
			ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
			XLData xldata = storeAndIce.readingDataFromXL(readFilePath, countriesFromExcel[i], channelFromXL);
			ComparingStoreLevelDataAndWritingXL compare = new ComparingStoreLevelDataAndWritingXL();
			compare.comparingAndWritingData(writeFilePath, writeWorkBook, dataUI, xldata, countriesFromUI[i], channel,i);
			//login.logout(driver);
}
			writeWorkBook.write();
			writeWorkBook.close();
}
}