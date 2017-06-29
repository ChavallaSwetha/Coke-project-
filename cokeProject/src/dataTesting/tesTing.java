package dataTesting;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class tesTing {
	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException, AWTException {
	System.setProperty("webdriver.chrome.driver",
			"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	String readFilePath ="C:/Users/Mona Lisa/Downloads/Caribbean ICE Results February 2017.xls";
	String country = "BAHAMAS";
	String compareCountry = "Bahamas";
	String channelUI ="HOME MARKET TRADITIONAL";
	String channelXL = "Tradicional";
	String piD ="1";
	String piD2 = "2";
	String piD3 = "3";
	String writeFilePath = "C:/Users/Mona Lisa/Downloads/Reading file.xls ";
	String date ="2017 - 2";
	
	WithAndWithOutCooler test = new WithAndWithOutCooler();
	PopprobeLogin login = new PopprobeLogin();
	login.logIn(driver);
	login.selectDropDowns(driver, date, country, channelUI);
	ReadingCountryLevelDataFromUI dashboardData = new ReadingCountryLevelDataFromUI();
	UICountryLevelData data = dashboardData.readingDashBoardData(driver);
	test.compareCountryLevelCoolerData(driver,  readFilePath, compareCountry, channelXL, piD,  writeFilePath, data);
	
	WithCooler yes = new WithCooler();
	yes.compareCountryLevelCoolerData(driver, readFilePath, compareCountry, channelXL, piD2, writeFilePath, data);
	
	WithOutCooler no = new WithOutCooler();
	no.compareCountryLevelCoolerData(driver, readFilePath, compareCountry, channelXL, piD3, writeFilePath, data);
}
}