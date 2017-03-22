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

	
	

	public UIData readingDataFromUI(WebDriver driver, HashMap m) throws InterruptedException {
		String namesUI = null ;
		Float totalUIAfterConvertingTofloat;
		Float totalUI;
		String[] totalUIBeforeConvertingToString;
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
		String[] namesFromUI = new String[rowsCount];
		//totalUI = new Float[rowsCount];
		totalUIBeforeConvertingToString = new String[rowsCount];
		UIData dataUI = new UIData();
		HashMap<String,Float> map = new HashMap<String,Float>();
		for (int i = 0; i < rowsCount; i++) {
			List<WebElement> columns = tableRows.get(i).findElements(By.tagName("td"));
			String rowData = columns.get(1).getText();
			String totalInUI = columns.get(4).getText();
			totalUIAfterConvertingTofloat = Float.parseFloat(totalInUI);
			namesUI = rowData;
			namesFromUI[i] = namesUI;
			totalUI = totalUIAfterConvertingTofloat;
			dataUI.setTotalUI(namesUI, totalUI);
			dataUI.setNamesUI(namesFromUI);
			//totalUIBeforeConvertingToString[i] = totalInUI;

		}
		//dataUI.setNamesUI(namesUI);
		m.get(dataUI);
		dataUI.setRowsCountUI(rowsCount);
		dataUI.getNamesUI();
		dataUI.getTotalUI(namesUI);
		//dataUI.setTotalBeforeConvertingUI(totalUIBeforeConvertingToString);
		//dataUI.setTotalUI(totalUI);
		return dataUI;
	}
	
	}
