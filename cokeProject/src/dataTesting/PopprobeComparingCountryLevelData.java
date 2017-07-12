package dataTesting;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class tesTing {
	public static void main(String[] args)
			throws InterruptedException, BiffException, IOException, WriteException, AWTException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Caribbean ICE Results February 2017.xls";
		String country = "BAHAMAS";
		String compareCountry = "Bahamas";
		String channelUI = "HOME MARKET TRADITIONAL";
		String channelXL = "Tradicional";
		String cooler = "1";
		String coolerYes = "2";
		
		String piD3 = "3";
		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Reading file.xls ";
		String date = "2017 - 2";
		
		
		
		WithAndWithOutCooler test = new WithAndWithOutCooler();
		WithCooler yes = new WithCooler();
		WithOutCooler no = new WithOutCooler();
		
		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		
		login.selectDropDowns(driver, date, country, channelUI);
		ReadingCountryLevelDataFromUI dashboardData = new ReadingCountryLevelDataFromUI();
		UIAndXLCountryLevelData uidata = dashboardData.readingDashBoardData(driver);
		ReadingCountryLevelXLData dataFromXL = new ReadingCountryLevelXLData();
		UIAndXLCountryLevelData xldata = dataFromXL.readingCountryLevelXLData(readFilePath, compareCountry, channelXL, cooler);
		
		
		test.compareCountryLevelCoolerData(driver, readFilePath, date, writeFilePath, uidata, xldata);
		
		login.coolerDropDown(driver);
		ReadingCountryLevelDataFromUI dashboardDataYes = new ReadingCountryLevelDataFromUI();
		UIAndXLCountryLevelData uidataYes = dashboardDataYes.readingDashBoardData(driver);
		ReadingCountryLevelXLData dataFromXLYes = new ReadingCountryLevelXLData();
		UIAndXLCountryLevelData xldataYes = dataFromXLYes.readingCountryLevelXLData(readFilePath, compareCountry, channelXL, coolerYes);
		        		
		yes.compareCountryLevelCoolerData(driver, readFilePath,  date, writeFilePath, uidataYes, xldataYes);
		
		/*login.coolerDropDownNo(driver);
		ReadingCountryLevelDataFromUI dashboardData2 = new ReadingCountryLevelDataFromUI();
		UICountryLevelData data2 = dashboardData2.readingDashBoardData(driver);

		no.compareCountryLevelCoolerData(driver, readFilePath, compareCountry, channelXL, piD3, writeFilePath,data2);*/
		
	
}
}