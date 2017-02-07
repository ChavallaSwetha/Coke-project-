package dataTesting;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeComparingStoreLevelData {

	static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException {
		String date = "2016 - 12";
		String country = "BAHAMAS";
		String channel = "ON PREMISE";
		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		login.selectDropDowns(driver, date, country, channel);
		ReadingdatafromUI namesAndTotal = new ReadingdatafromUI();
		namesAndTotal.readingDataFromUI(driver);
		String[] namesUi = ReadingdatafromUI.namesUI;
		String[] namesUIwrite = ReadingdatafromUI.namesUI;
		int rowsCountUi = ReadingdatafromUI.rowsCountUI;
		Float[] totalUi = ReadingdatafromUI.totalUI;
		String[] totalBeforeConvertingUi = ReadingdatafromUI.totalBeforeConvertingUI;
		Readingdatafromxl storeAndIce = new Readingdatafromxl();
		storeAndIce.readingDataFromXL();
		int rowsXl = Readingdatafromxl.rowsXL;
		String[] countryXL = Readingdatafromxl.counTryXL;
		String[] dateXL = Readingdatafromxl.daTeXL;
		String[] channelXL = Readingdatafromxl.chaNnelXL;
		String[] subChannelXL = Readingdatafromxl.subChanneLXL;
		String[] coolerXL = Readingdatafromxl.cooLerXL;
		String[] storeNameXl = Readingdatafromxl.storeNameXL;
		String[] iceXl = Readingdatafromxl.iceXL;
		Float[] iceValueXl = Readingdatafromxl.icevaLueXL;
		login.comparingAndWritingData(rowsCountUi, totalBeforeConvertingUi, rowsXl, namesUi, storeNameXl, iceXl,
				countryXL, dateXL, namesUIwrite, channelXL, subChannelXL, coolerXL, totalUi, iceValueXl);

	}

}
