package dataTesting;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PopprobeComparingCountryLevelData {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException {
		System.setProperty("webdriver.chrome.driver","C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		float mpaUI = 0 ;
		float sOVI = 0;
		float rEF = 0;
		float coMMEX = 0;
		float prICE =0;
		float freshNess = 0;
        PopprobeLogin login  = new PopprobeLogin();
        login.logIn(driver);
        Thread.sleep(9000);
        driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click(); // Date
		// dropdown
		Thread.sleep(6000);
		driver.findElement(By.linkText("2016 - 12")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText("BAHAMAS")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[4]/div/button")).click(); // Channel
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText("HOME MARKET TRADITIONAL")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath(".//*[@id='dashboard-container']/div[1]/div[4]/div[1]/div[1]/div[1]/div/div[1]")).getText());
		WebElement kpiTable = driver.findElement(By.xpath(".//*[@id='dashboard-container']/div[1]/div[4]/div[1]/div[2]/div/table/tbody"));
		List<WebElement> rowsInTable = kpiTable.findElements(By.tagName("tr"));
		int rowsCountUI= rowsInTable.size();
		System.out.println(rowsCountUI);
		List<WebElement> columns = rowsInTable.get(1).findElements(By.tagName("td"));
			
			String mPA = columns.get(1).getText();
			mpaUI = Float.parseFloat(mPA);
			String soVI = columns.get(2).getText();
			sOVI = Float.parseFloat(soVI);
			String refrigiration  = columns.get(3).getText();
			rEF = Float.parseFloat(refrigiration);
			String communion = columns.get(4).getText();
			coMMEX = Float.parseFloat(communion);
			String price = columns.get(5).getText();
			prICE = Float.parseFloat(price);
			String freshNEss = columns.get(6).getText();
			freshNess = Float.parseFloat(freshNEss);
			
			
	File readFile = new File("C:/Users/Mona Lisa/Desktop/Datafor countrylevel testing.xls");	
	Workbook readWbk = Workbook.getWorkbook(readFile);
	Sheet sh = readWbk.getSheet(0);
	int rowsCountXl = sh.getRows();
	System.out.println("No. of rows in XL"+"         "+rowsCountXl);
	String mpa = "Portafolio Prioritario";
	String[] kPI = new String[rowsCountXl];
	for (int mainKPI=0; mainKPI<rowsCountXl; mainKPI++){
	Cell some = sh.getCell(5, mainKPI);
		kPI[mainKPI] = some.getContents();
		System.out.println(kPI[mainKPI]);
		if ((kPI[mainKPI]).equals(mpa)){
			Cell pid = sh.getCell(4,mainKPI);
			String pID = pid.getContents();
			System.out.println(pID);
			String cooler = "1";
			if (pID.equals(cooler)){
				Cell iCE = sh.getCell(6, mainKPI);
				String icevalue = iCE.getContents();
				System.out.println(icevalue);
				String icereplacewithf = icevalue.replaceAll("%","f");
				float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
				System.out.println("UI MPA"+"          "+mpaUI);
				System.out.println("XL MPA"+"          "+afterconvertingtofloat);
				float difference = Math.abs(mpaUI - afterconvertingtofloat);
				if (difference == 0){
					System.out.println("swetha");
				}
				
			}
		}
	}
	}
}


