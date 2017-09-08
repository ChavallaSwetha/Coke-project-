package dataTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadingDataFromCountriesNewUI {
	
	public UIData readingDataFromCountries(WebDriver driver,String country) throws InterruptedException{
		UIData dataFromUI = new UIData();
		driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/md-menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("COUNTRIES")).click();
		Thread.sleep(3000);
		
			
		
		WebElement countryData = driver.findElement(By.xpath("html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/section/md-content/div[2]"));
		WebElement countryTable = countryData.findElement(By.id("stores-table"));
		List<WebElement> storeData = countryTable.findElements(By.tagName("tbody"));
		for (int r=0;r<1;r++){
		List<WebElement> tableRows =  storeData.get(r).findElements(By.tagName("tr"));
		int rowscount = tableRows.size();
		System.out.println("No of rows"+"   "+rowscount);
		List<WebElement> columns = tableRows.get(0).findElements(By.tagName("td"));
		//String countryUI = columns.get(0).getText();
		int strCount;
		String count = columns.get(2).getText();
		System.out.println(count);
			int  storCount =Integer.parseInt(count);
			strCount = storCount;
			System.out.println("Store Count"+"  "+strCount);
			dataFromUI.setStoreCount(strCount);
		}
			dataFromUI.getStoreCount();
		return dataFromUI;
		
	}

	

	

}
