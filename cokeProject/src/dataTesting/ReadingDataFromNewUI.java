package dataTesting;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadingDataFromNewUI {

	
	public UIData readingDataFromUI(WebDriver driver,String date, String country, String channel) throws InterruptedException, IOException {
	
	UIData dataUI = new UIData();
	
	
	String storeName = null;
	Float totalUIAfterConvertingTofloat;
	Float totalUI = null;
	driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/md-menu")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("STORES")).click();
	PopprobeNewLogin filters = new PopprobeNewLogin();
	filters.selectDropDowns(driver, date, country, channel);
	//filters.selectDropDowns(driver, date, country); // For Belize
	ReadingDataFromCountriesNewUI strCount = new ReadingDataFromCountriesNewUI();
	UIData storesFromCountry = strCount.readingDataFromCountries(driver,country);
	driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/md-menu")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("STORES")).click();
	Thread.sleep(3000);
	int stores = 0;
	while(true){
	WebElement storeData = driver.findElement(By.xpath("html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/section/md-content/div[2]"));
	List<WebElement> customerData = storeData.findElements(By.tagName("tbody"));
	Thread.sleep(3000);
	List<WebElement> tableRows = customerData.get(0).findElements(By.tagName("tr"));
	int rowsCount = tableRows.size();
	System.out.println("No of rows in UI" + "      " + rowsCount);
	for (int i = 0; i < rowsCount; i++) {
		List<WebElement> columns = tableRows.get(i).findElements(By.tagName("td"));
		String rowData = columns.get(1).getText();
		System.out.println("Store name"+"    "+rowData);
		String totalInUI = columns.get(5).getText();
		System.out.println("Store total"+"    "+totalInUI);
		String total = totalInUI.replaceAll("[^\\d.]", "");
		totalUIAfterConvertingTofloat = Float.parseFloat(total);
		System.out.println("totalUIAfterConvertingTofloat"+"  "+totalUIAfterConvertingTofloat);
		storeName = rowData;
		totalUI = totalUIAfterConvertingTofloat;
		dataUI.setTotalUI(storeName, totalUI);
		String railing = columns.get(3).getText();
		storeName = rowData;
		dataUI.setRailUI(storeName, railing);
		String cooler = columns.get(2).getText();
		storeName = rowData;
		dataUI.setCoolUI(storeName, cooler);
		 String store = columns.get(0).getText();
		 int noOfStores = Integer.parseInt(store);
	      stores = noOfStores;
	}
	if (stores == storesFromCountry.getStoreCount()){
		break;
	}
	
	driver.findElement(By.xpath("/html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/section/md-content/div[2]/md-card/md-card-content/md-toolbar/div/div[2]/md-grid-list/md-grid-tile[5]/figure/button")).click();// next button
	}
	//dataUI.getTotalUI(storeName);
	dataUI.getRowsCountUI();
	dataUI.getRailUI(storeName);
	dataUI.getCoolUI(storeName);
	Thread.sleep(3000);
	//System.out.println("Reading Data from UI");
	return dataUI;
	}
}