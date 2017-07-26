package dataTesting;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadingDataFromUI {
	/*
	 * After selecting date, country and channel go to Datagrid. Using function
	 * readingDataFromUI() read datagrid data.
	 */
	public UIData readingDataFromUI(WebDriver driver) throws InterruptedException {
		/*String storeName = null;
		Float totalUIAfterConvertingTofloat;
		Float totalUI = null;
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/a/img")).click(); // Datagrid
		Thread.sleep(2000);
		WebElement customerData = driver.findElement(By.xpath(
				".//*[@id='shell-view']/section/section/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/table/tbody"));
		Thread.sleep(3000);
		List<WebElement> tableRows = customerData.findElements(By.tagName("tr"));
		Thread.sleep(3000);
		int rowsCount = tableRows.size();
		System.out.println("No of rows in UI" + "      " + rowsCount);
		UIData dataUI = new UIData();

		for (int i = 0; i < rowsCount; i++) {
			List<WebElement> columns = tableRows.get(i).findElements(By.tagName("td"));
			String rowData = columns.get(1).getText();
			
			String totalInUI = columns.get(7).getText();
			totalUIAfterConvertingTofloat = Float.parseFloat(totalInUI);
			storeName = rowData;
			totalUI = totalUIAfterConvertingTofloat;
			dataUI.setTotalUI(storeName, totalUI);
			dataUI.setTotalUI(storeName, totalUI);
			String custSK = columns.get(2).getText();
			storeName = rowData;
			dataUI.setCustUI(storeName, custSK);
			String railing = columns.get(4).getText();
			
			storeName = rowData;
			dataUI.setRailUI(storeName, railing);
			String cooler = columns.get(3).getText();
			storeName = rowData;
			dataUI.setCoolUI(storeName, cooler);
			
		}
		dataUI.getTotalUI(storeName);
		dataUI.getCustUI(storeName);
		dataUI.getRowsCountUI();
		dataUI.getRailUI(storeName);
		dataUI.getCoolUI(storeName);
		//System.out.println(dataUI.getRailUI(storeName));
		System.out.println("Reading Data from UI");
		return dataUI; */
		
		// For New App
		UIData dataUI = new UIData();
		driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/md-menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("STORES")).click();
		Thread.sleep(3000);
		WebElement customerData = driver.findElement(By.xpath(".//*[@id='stores-table']/tbody"));
		Thread.sleep(3000);
		List<WebElement> tableRows = customerData.findElements(By.tagName("tr"));
		Thread.sleep(3000);
		int rowsCount = tableRows.size();
		System.out.println("No of rows in UI" + "      " + rowsCount);
		 driver.findElement(By.xpath("html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/section/md-content/div[2]/md-card/md-card-content/md-toolbar/div/div[2]/md-grid-list/md-grid-tile[6]/figure/button")).click();
		Thread.sleep(3000);
		String no = driver.findElement(By.xpath("/html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/section/md-content/div[1]/md-card/md-card-content/md-toolbar/div/div[2]/md-grid-list/md-grid-tile[4]/figure/input[1]")).getText();
		Thread.sleep(3000);
		System.out.println("Pagination size"+" --> "+no);
		
		return dataUI;
	}

}
