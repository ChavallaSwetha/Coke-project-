package popProbeRelatedPrograms;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataTesting.PopprobeLogin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PopprobeComparingCountryLevelDat {

	public static void main(String[] args)
			throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		WebDriver driver = new FirefoxDriver();
		PopprobeLogin login = new PopprobeLogin();
		PopprobeComparingCountryLevelDataWithAndWithOutCooler cooler = new PopprobeComparingCountryLevelDataWithAndWithOutCooler();
		String date = "2016 - 12";
		String country = "BAHAMAS";
		String channel = "HOME MARKET TRADITIONAL";
		String readFilePath = "C:/Users/Mona Lisa/Desktop/Datafor countrylevel testing.xls" ;
		String writeFilePath = "C:/Users/Mona Lisa/Downloads/country data.xls"; 
		login.logIn(driver);
		Thread.sleep(8000);
		FilterBasedOnCriteria filter = new FilterBasedOnCriteria();
		filter.selectDropDowns(driver, date, country, channel);
		cooler.compareCountryLevelCoolerData(driver,readFilePath,writeFilePath);
		PopprobeComparingCountryLevelDataWithCooler yes = new PopprobeComparingCountryLevelDataWithCooler();
		yes.comparingCountryLevelDataWithCooler(driver,readFilePath,writeFilePath);
		PopprobeComparingCountryLevelDataWithOutCooler no = new PopprobeComparingCountryLevelDataWithOutCooler();
		no.comparingCountryLevelDataWithOutCooler(driver,readFilePath,writeFilePath);
		System.out.println("Comparing country level data");
	}

}
