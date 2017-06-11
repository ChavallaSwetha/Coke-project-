package dataTesting;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadingDataFromUI {
	/*
	 * After selecting date, country and channel go to Datagrid. Using function
	 * readingDataFromUI() read datagrid data.
	 */
	public UIData readingDataFromUI(WebDriver driver) throws InterruptedException {
		String storeName = null;
		Float totalUIAfterConvertingTofloat;
		Float totalUI = null;
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/a/img")).click(); // Datagrid
		Thread.sleep(9000);
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
<<<<<<< HEAD
			String totalInUI = columns.get(7).getText();
=======
			String totalInUI = columns.get(6).getText();
>>>>>>> branch 'master' of https://github.com/ChavallaSwetha/Coke-project-.git
			totalUIAfterConvertingTofloat = Float.parseFloat(totalInUI);
			storeName = rowData;
			totalUI = totalUIAfterConvertingTofloat;
			dataUI.setTotalUI(storeName, totalUI);
			dataUI.setTotalUI(storeName, totalUI);
			String custSK = columns.get(2).getText();
			storeName = rowData;
			dataUI.setCustID(storeName, custSK);
		}
		dataUI.getTotalUI(storeName);
		dataUI.getCustID(storeName);
		dataUI.getRowsCountUI();
		System.out.println(dataUI);
		System.out.println("Reading Data from UI");
		return dataUI;
		
	}

}
