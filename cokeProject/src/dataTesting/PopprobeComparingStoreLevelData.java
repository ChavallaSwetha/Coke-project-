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

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException {
		
		
		String[] countriesFromUI = {"BAHAMAS"};//,"BARBADOS","FRENCH GUIANA","GUYANA","GUADELOUPE","JAMAICA","MARTINIQUE","SURINAME","TRINIDAD Y TOBAGO"};
		String[] countriesFromExcel = {"Bahamas"};//,"Barbados","French Guiana","Guyana","Guadeloupe","Jamaica","Martinique","Suriname","Trinidad & Tobago"};
		String date = "2017 - 1";
		String channelFromXL ="Tradicional";
		String channel = "HOME MARKET TRADITIONAL";
		String mpaChannelXL = "Portafolio Prioritario";
		String soviChannelXL = "SOVI";
		String refregiratioChannelXL = "Refrigeración";
		String commuNionChannelXL = "Comunicación y exhibición";
		String priCeChannelXL = "Respeto a Precio";
		String freshNESsChannelXL = "Frescura de Producto";
		String readFilePath = "C:/Users/Swetha/Downloads/Caribbean ICE Results January 2017 (1).xls";
		String writeFilePath = "C:/Users/Swetha/Downloads/Data_Of_Popprobe/All_Countries_Traditional_Data_Jan.xls";
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		System.setProperty("webdriver.chrome.driver",
					"C:/Users/Swetha/Downloads/chromedriver_win32/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		for(int i=0; i<countriesFromUI.length; i++){
		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		
			login.selectDropDowns(driver,date, countriesFromUI[i], channel);
			//login.selectDropDowns(driver,date, countriesFromUI[i]);
			ComparingStoreLevelDataAndWritingXL compare = new ComparingStoreLevelDataAndWritingXL();
			ReadingDataFromUI namesAndTotal = new ReadingDataFromUI();
			UIData dataUI = namesAndTotal.readingDataFromUI(driver);
			ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
			XLData xldata = storeAndIce.readingDataFromXL(readFilePath, countriesFromExcel[i], channelFromXL,  mpaChannelXL, soviChannelXL,refregiratioChannelXL, commuNionChannelXL, priCeChannelXL, freshNESsChannelXL );
			compare.comparingAndWritingData(writeFilePath,writeWorkBook,dataUI, xldata,countriesFromUI[i],channel,i);
			login.logout(driver);
		}
		writeWorkBook.write();
		writeWorkBook.close();	
	}
}
	
			
