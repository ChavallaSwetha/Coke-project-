package dataTesting;

import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
public class PopprobeComparingPremiseCountryLevelData {
      
	public static void main(String[] args)
			throws InterruptedException, BiffException, IOException, WriteException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Swetha/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String readFilePath = "C:/Users/Swetha/Downloads/Caribbean ICE Results June 2017.xls";
		
		String[] country = {"BARBADOS","BAHAMAS","FRENCH GUIANA","GUADELOUPE","JAMAICA","MARTINIQUE","SURINAME","TRINIDAD Y TOBAGO"  };
		String[] compareCountry = {"Barbados","Bahamas","French Guiana","Guadeloupe","Jamaica","Martinique","Suriname","Trinidad & Tobago" };
		/*String[] country = { "FRENCH GUIANA","GUADELOUPE"}; String[]
				  compareCountry = { "French Guiana","Guadeloupe"};*/
		
		String channelUI = "ON PREMISE";
		String channelXL = "On Premise";
		String cooler = "4";
		String coolerYes = "5";
		String coolerNo = "6";
		String withAndWithOutCooler = "NULL";
		String withCooler = "YES";
		String withOutCooler = "NO";

		String writeFilePath = "C:/Users/Swetha/Downloads/Data_Of_Popprobe/All_Countries_Premise_Country_Level_June.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		String date = "2017 - 6";

		PremiseWithAndWithOutCooler test = new PremiseWithAndWithOutCooler();
		PremiseWithCooler yes = new PremiseWithCooler();
		PremiseWithOutCooler no = new PremiseWithOutCooler();
        String data = "DATA FOR SELECTED FILTER DOES NOT EXIST";
		
		for (int i = 0; i < country.length; i++) {
			
			WritableSheet writeSheet = writeWorkBook.createSheet(country[i], i);

			PopprobeLogin login = new PopprobeLogin();
			login.logIn(driver);
			login.selectDropDowns(driver, date, country[i], channelUI);
			WebElement element = driver.findElement(
					By.xpath("html/body/div[1]/div[2]/div/section/div[2]/section/section/div/div[2]/div[4]/div[2]/div/h3"));
			                
			if (element.isDisplayed()) {
				System.out.println(data);
			} else {
				ReadingCountryLevelDataFromUI dashboardData = new ReadingCountryLevelDataFromUI();
				UIAndXLCountryLevelData uidata = dashboardData.readingDashBoardData(driver);
				ReadingCountryLevelPremiseXLData dataFromXL = new ReadingCountryLevelPremiseXLData();
				UIAndXLCountryLevelData xldata = dataFromXL.readingCountryLevelXLData(readFilePath, compareCountry[i],
						channelXL, cooler, withAndWithOutCooler);

				test.compareCountryLevelCoolerData(writeSheet, readFilePath, date, i, uidata, xldata);
			}
			login.coolerDropDown(driver);
			
			if (element.isDisplayed()) {
				System.out.println(data);
			} else {
				ReadingCountryLevelDataFromUI dashboardDataYes = new ReadingCountryLevelDataFromUI();
				UIAndXLCountryLevelData uidataYes = dashboardDataYes.readingDashBoardData(driver);
				ReadingCountryLevelPremiseXLData dataFromXLYes = new ReadingCountryLevelPremiseXLData();
				UIAndXLCountryLevelData xldataYes = dataFromXLYes.readingCountryLevelXLData(readFilePath,
						compareCountry[i], channelXL, coolerYes, withCooler);

				yes.compareCountryLevelCoolerData(writeSheet, readFilePath, date, i, uidataYes, xldataYes);
			}
			login.coolerDropDownNo(driver);
			if (element.isDisplayed()) {
				System.out.println(data);
			} else {
			ReadingCountryLevelDataFromUI dashboardDataNo = new ReadingCountryLevelDataFromUI();
			UIAndXLCountryLevelData uidataNo = dashboardDataNo.readingDashBoardData(driver);
			ReadingCountryLevelPremiseXLData dataFromXLNo = new ReadingCountryLevelPremiseXLData();
			UIAndXLCountryLevelData xldataNo = dataFromXLNo.readingCountryLevelXLData(readFilePath, compareCountry[i],
					channelXL, coolerNo, withOutCooler);

			no.compareCountryLevelCoolerData(writeSheet, readFilePath, date, i, uidataNo, xldataNo);
			login.logout(driver);
			}
		}

		writeWorkBook.write();
		writeWorkBook.close();

	}

}




