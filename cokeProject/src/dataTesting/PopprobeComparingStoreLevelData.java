package dataTesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class PopprobeComparingStoreLevelData {

	static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException {
		String date = "2016 - 12";
		String country = "BAHAMAS";
		String channel = "ON PREMISE";
		String readFilePath = "C:/Users/Mona Lisa/Downloads/Reading file.xls";
		String writeFilePath = "C:/Users/Mona Lisa/Downloads/Writing file.xls";
		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		login.selectDropDowns(driver, date, country, channel);
		ComparingStoreLevelDataAndWritingXL  compare = new ComparingStoreLevelDataAndWritingXL();
		UIData dataFromUI = new UIData();
		ReadingdatafromUI namesAndTotal = new ReadingdatafromUI();
		ReadingdatafromUI dataUI =namesAndTotal.readingDataFromUI(driver);
		ReadingDataFromxl storeAndIce = new ReadingDataFromxl();
	     ReadingDataFromxl xldata =	storeAndIce.readingDataFromXL(readFilePath);
		compare.comparingAndWritingData(writeFilePath,dataUI.getrowsCount(), dataUI.getTotalstringUI(), xldata.getRowsXL(), dataUI.getnamesUI(), xldata.getStoreNameXL(), xldata.getIceXL(),
				xldata.getCounTryXL(), xldata.getDaTeXL(),dataUI.getnamesUI(),xldata.getChaNnelXL(), xldata.getSubChanneLXL(),xldata.getCooLerXL(), 
				dataUI.getTotalUI(), xldata.getIcevaLueXL());
		

	}

}
