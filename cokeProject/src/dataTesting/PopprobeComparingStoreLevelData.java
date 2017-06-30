package dataTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeComparingStoreLevelData {

	// static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException {
		
		
		String[] countriesFromUI = {"MARTINIQUE","SURINAME","TRINIDAD Y TOBAGO"};
		String[] countriesFromExcel = {"Martinique","Suriname","Trinidad & Tobago"};
		String date = "2017 - 2";
		String channelFromXL ="premise";
		String channel = "ON PREMISE";
		String readFilePath = "C:/Users/Swetha/Downloads/Caribbean ICE Results February 2017 (3).xls";
		String writeFilePath = "C:/Users/Swetha/Downloads/Data_Of_Popprobe/Missing_Stores_Data.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		
		for(int i=0; i<countriesFromUI.length; i++){
			
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Swetha/Downloads/chromedriver_win32/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		
			login.selectDropDowns(driver,date, countriesFromUI[i], channel);
			//login.selectDropDowns(driver,date, countriesFromUI[i]);
			//ComparingStoreLevelDataAndWritingXL compare = new ComparingStoreLevelDataAndWritingXL();
			ComparingMissingStores missingStores = new ComparingMissingStores();
			ReadingDataFromUI namesAndTotal = new ReadingDataFromUI();
			UIData dataUI = namesAndTotal.readingDataFromUI(driver);
			ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
			XLData xldata = storeAndIce.readingDataFromXL(readFilePath,countriesFromExcel[i],channelFromXL);
			//compare.comparingAndWritingData(writeFilePath,writeWorkBook,dataUI, xldata,countriesFromUI[i],channel,i);
			missingStores.comparingAndWritingData(writeFilePath,writeWorkBook,dataUI, xldata,countriesFromUI[i],channel,i);
			
		}
		writeWorkBook.write();
		writeWorkBook.close();
	}

}
