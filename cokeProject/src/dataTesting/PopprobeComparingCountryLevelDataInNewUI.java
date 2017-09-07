package dataTesting;
import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeComparingCountryLevelDataInNewUI {
       
	
	public static void main(String[] args)
			throws InterruptedException, BiffException, IOException, WriteException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Caribbean ICE Results June 2017.xls";
		
		  String[] country = {"BARBADOS","BAHAMAS","FRENCH GUIANA","GUYANA","JAMAICA","MARTINIQUE","SURINAME","TRINIDAD Y TOBAGO" }; 
		  String[] compareCountry = {"Barbados","Bahamas","French Guiana","Guyana","Jamaica","Martinique","Suriname","Trinidad & Tobago" };
		 
		
		/*String[] country = { "BELIZE", "HAITI" };
		String[] compareCountry = { "Belize", "Haiti" };*/

		String channelUI = "HOME MARKET TRADITIONAL";
		String channelXL = "Tradicional";
		String cooler = "1";
		String coolerYes = "2";
		String coolerNo = "3";
		String withAndWithOutCooler = "NULL";
		String withCooler = "YES";
		String withOutCooler = "NO";

		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Data_of_Popprobe/Belize_Haiti_Country_Level_June.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		String date = "2017 - 6";

		WithAndWithOutCooler test = new WithAndWithOutCooler();
		WithCooler yes = new WithCooler();
		WithOutCooler no = new WithOutCooler();
		PopprobeNewLogin filters = new PopprobeNewLogin();
		filters.logIn(driver);
		for (int i = 0; i < country.length; i++) {
			WritableSheet writeSheet = writeWorkBook.createSheet(country[i], i);

			
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/md-menu")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("STORES")).click();
			filters.selectDropDowns(driver, date, country[i], channelUI);
			driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[1]/md-menu")).click();
			ReadingCountryLevelDataFromNewUI dashboardData = new ReadingCountryLevelDataFromNewUI();
			UIAndXLCountryLevelData uidata = dashboardData.readingDashBoardData(driver);
			ReadingCountryLevelXLData dataFromXL = new ReadingCountryLevelXLData();
			UIAndXLCountryLevelData xldata = dataFromXL.readingCountryLevelXLData(readFilePath, compareCountry[i],
					channelXL, cooler, withAndWithOutCooler);

			test.compareCountryLevelCoolerData(writeSheet, readFilePath, date, i, uidata, xldata);

			filters.coolerDropDown(driver);
			ReadingCountryLevelDataFromNewUI dashboardDataYes = new ReadingCountryLevelDataFromNewUI();
			UIAndXLCountryLevelData uidataYes = dashboardDataYes.readingDashBoardData(driver);
			ReadingCountryLevelXLData dataFromXLYes = new ReadingCountryLevelXLData();
			UIAndXLCountryLevelData xldataYes = dataFromXLYes.readingCountryLevelXLData(readFilePath, compareCountry[i],
					channelXL, coolerYes, withCooler);

			yes.compareCountryLevelCoolerData(writeSheet, readFilePath, date, i, uidataYes, xldataYes);

			filters.coolerDropDownNo(driver);
			ReadingCountryLevelDataFromNewUI dashboardDataNo = new ReadingCountryLevelDataFromNewUI();
			UIAndXLCountryLevelData uidataNo = dashboardDataNo.readingDashBoardData(driver);
			ReadingCountryLevelXLData dataFromXLNo = new ReadingCountryLevelXLData();
			UIAndXLCountryLevelData xldataNo = dataFromXLNo.readingCountryLevelXLData(readFilePath, compareCountry[i],
					channelXL, coolerNo, withOutCooler);

			no.compareCountryLevelCoolerData(writeSheet, readFilePath, date, i, uidataNo, xldataNo);
			//filters.logout(driver);
			}
			writeWorkBook.write();
			writeWorkBook.close();

		}
}
