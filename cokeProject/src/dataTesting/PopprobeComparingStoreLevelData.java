package dataTesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class PopprobeComparingStoreLevelData {

	 //static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		String date = "2016 - 12";
		String country = "BAHAMAS";
		String channel = "ON PREMISE";
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Reading file.xls";
		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Writing file.xls";
		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		login.selectDropDowns(driver, date, country, channel);
		ComparingStoreLevelDataAndWritingXL  compare = new ComparingStoreLevelDataAndWritingXL();
		ReadingDataFromUI namesAndTotal = new ReadingDataFromUI();
		UIData dataUI =namesAndTotal.readingDataFromUI(driver);
		ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
	     XLData xldata =	storeAndIce.readingDataFromXL(readFilePath);
		compare.comparingAndWritingData(writeFilePath,dataUI, xldata);
		

	}

}
