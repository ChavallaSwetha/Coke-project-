package dataTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;


import jxl.Workbook;
import jxl.read.biff.BiffException;

import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeComparingStoreLevelData {

	// static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException, AWTException {
		
		
		String[] countriesFromUI = {"HAITI","BELIZE"};
		String[] countriesFromExcel = {"Haiti","Belize"};
		String date = "2017 - 2";
		String channelFromXL ="tradicional";
		String channel = "HOME MARKET TRADITIONAL";
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Caribbean ICE Results February 2017.xls";
		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Data_of_Popprobe/All_Countries_Traditional_Data.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		for(int i=0; i<countriesFromUI.length; i++){
		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		
			//login.selectDropDowns(driver,date, country, channel);
			login.selectDropDowns(driver,date, countriesFromUI[i]);
			//ComparingStoreLevelDataAndWritingXL compare = new ComparingStoreLevelDataAndWritingXL();
			ComparingMissingStores missingStores = new ComparingMissingStores();
			ReadingDataFromUI namesAndTotal = new ReadingDataFromUI();
			UIData dataUI = namesAndTotal.readingDataFromUI(driver);
			ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
			XLData xldata = storeAndIce.readingDataFromXL(readFilePath,countriesFromExcel[i],channelFromXL);
			//compare.comparingAndWritingData(writeFilePath,writeWorkBook,dataUI, xldata,countriesFromUI[i],channel,i);
			missingStores.comparingAndWritingData(writeFilePath,writeWorkBook,dataUI, xldata,countriesFromUI[i],channel,i);
			login.logout(driver);
			login.newTab(driver);
			
			}
		writeWorkBook.write();
		writeWorkBook.close();
		
	}

}