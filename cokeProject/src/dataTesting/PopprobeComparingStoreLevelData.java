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
		//String date = "2017 - 2";
		/*String country = "BARBADOS";
		String channel = "ON PREMISE";*/
		/*String countryFromXL ="Barbados";
		String channelFromXL ="Premise";*/

		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Data_of_Popprobe/Bahamas Traditional data.xls.xls";

		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		login.selectDropDowns(driver);
		// login.selectDropDowns(driver);
		ComparingStoreLevelDataAndWritingXL compare = new ComparingStoreLevelDataAndWritingXL();
		ReadingDataFromUI namesAndTotal = new ReadingDataFromUI();
		UIData dataUI = namesAndTotal.readingDataFromUI(driver);
		ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Caribbean ICE Results February 2017.xls";
		XLData xldata = storeAndIce.readingDataFromXL(readFilePath);
		compare.comparingAndWritingData(writeFilePath, dataUI, xldata);
		System.out.println("Swetha testing coke project in workspace1");

	}

}
