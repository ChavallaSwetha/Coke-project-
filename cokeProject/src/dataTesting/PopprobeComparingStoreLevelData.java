package dataTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.HashMap;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class PopprobeComparingStoreLevelData {

	// static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String date = "2017 - 2";
		String country = "BARBADOS";
		String channel = "ON PREMISE";
		String countryFromXL ="Barbados";
		String channelFromXL ="Premise";

		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Data_of_Popprobe/Jamaica_On_Premise_Data.xls.xls";

		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		login.selectDropDowns(driver,date, country, channel);
		 //login.selectDropDowns(driver,date, country);
		//ComparingStoreLevelDataAndWritingXL compare = new ComparingStoreLevelDataAndWritingXL();
		ComparingStores missingStores = new ComparingStores();
		ReadingDataFromUI namesAndTotal = new ReadingDataFromUI();
		UIData dataUI = namesAndTotal.readingDataFromUI(driver);
		ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Caribbean ICE Results February 2017.xls";
		XLData xldata = storeAndIce.readingDataFromXL(readFilePath,countryFromXL,channelFromXL);
		//compare.comparingAndWritingData(writeFilePath, dataUI, xldata);
		missingStores.comparingAndWritingData(writeFilePath, dataUI, xldata);
		
		

	}

}
