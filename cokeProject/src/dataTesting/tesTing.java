package dataTesting;

import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class tesTing {
	public static void main(String[] args)
			throws InterruptedException, BiffException, IOException, WriteException, AWTException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Swetha/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String readFilePath = "C:/Users/Swetha/Downloads/Caribbean ICE Results February 2017 (3).xls";
		String[] country = { "BAHAMAS", "BARBADOS" };
		String[] compareCountry = { "Bahamas", "Barbados" };
		String channelUI = "HOME MARKET TRADITIONAL";
		String channelXL = "Tradicional";
		String cooler = "1";
		String coolerYes = "2";
		String coolerNo = "3";
		String withAndWithOutCooler = "NULL";
		String withCooler = "YES";
		String withOutCooler = "NO";
		String writeFilePath = "C:/Users/Swetha/Downloads/Bahamas_missing_stores_Traditional.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		
		
		String date = "2017 - 2";

		WithAndWithOutCooler test = new WithAndWithOutCooler();
		WithCooler yes = new WithCooler();
		WithOutCooler no = new WithOutCooler();

		for (int i = 0; i < country.length; i++) {
			WritableSheet writeSheet = writeWorkBook.createSheet(country[i], i);
			
			PopprobeLogin login = new PopprobeLogin();
			login.logIn(driver);
			login.selectDropDowns(driver, date, country[i], channelUI);
			ReadingCountryLevelDataFromUI dashboardData = new ReadingCountryLevelDataFromUI();
			UIAndXLCountryLevelData uidata = dashboardData.readingDashBoardData(driver);
			ReadingCountryLevelXLData dataFromXL = new ReadingCountryLevelXLData();
			UIAndXLCountryLevelData xldata = dataFromXL.readingCountryLevelXLData(readFilePath, compareCountry[i],
					channelXL, cooler, withAndWithOutCooler);

			test.compareCountryLevelCoolerData(writeSheet, readFilePath, date,  i, uidata, xldata);

			login.coolerDropDown(driver);
			ReadingCountryLevelDataFromUI dashboardDataYes = new ReadingCountryLevelDataFromUI();
			UIAndXLCountryLevelData uidataYes = dashboardDataYes.readingDashBoardData(driver);
			ReadingCountryLevelXLData dataFromXLYes = new ReadingCountryLevelXLData();
			UIAndXLCountryLevelData xldataYes = dataFromXLYes.readingCountryLevelXLData(readFilePath, compareCountry[i],
					channelXL, coolerYes, withCooler);
			
			
   		  
		yes.compareCountryLevelCoolerData(writeSheet, readFilePath, date, i, uidataYes,	xldataYes);

			login.coolerDropDownNo(driver);
			ReadingCountryLevelDataFromUI dashboardDataNo = new ReadingCountryLevelDataFromUI();
			UIAndXLCountryLevelData uidataNo = dashboardDataNo.readingDashBoardData(driver);
			ReadingCountryLevelXLData dataFromXLNo = new ReadingCountryLevelXLData();
			UIAndXLCountryLevelData xldataNo = dataFromXLNo.readingCountryLevelXLData(readFilePath, compareCountry[i],
					channelXL, coolerNo, withOutCooler);
			
			no.compareCountryLevelCoolerData(writeSheet, readFilePath, date, i, uidataNo, xldataNo);
			login.logout(driver);
			

		}
		writeWorkBook.write();
		writeWorkBook.close();

	}
}