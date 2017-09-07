/*package dataTesting;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadingDataFromUI {
	
	 * After selecting date, country and channel go to Datagrid. Using function
	 * readingDataFromUI() read datagrid data.
	 
	public UIData readingDataFromUI(WebDriver driver) throws InterruptedException {
		String storeName = null;
		Float totalUIAfterConvertingTofloat;
		Float totalUI = null;
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/a/img")).click(); // Datagrid
		Thread.sleep(4000);
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
		System.out.println("Reading Data from UI");
		return dataUI; 
	}	

}*/

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
		String storeName = null;
		Float totalUIAfterConvertingTofloat;
		Float totalUI = null;
		Float mpaUI;
		Float soviUI;
		Float refUI;
		Float commUI;
		Float pricUI;
		Float freshUI;
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/a/img")).click(); // Datagrid
		Thread.sleep(4000);
		WebElement customerData = driver.findElement(By.xpath(
				".//*[@id='shell-view']/section/section/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/table/tbody"));
		Thread.sleep(3000);
		List<WebElement> tableRows = customerData.findElements(By.tagName("tr"));
		Thread.sleep(3000);
		int rowsCount = tableRows.size();
		System.out.println("No of rows in UI" + "      " + rowsCount);
		UIData dataUI = new UIData();

		for (int i = 0; i < rowsCount; i++) {
			StringBuffer str = new StringBuffer();
			List<WebElement> columns = tableRows.get(i).findElements(By.tagName("td"));
			str.append("[");
			for (int j = 0; j < columns.size(); j++) {
				if(j != 0){
					str.append(",");
				}
				str.append(columns.get(j).getText());
				
			}
			str.append("]");
			System.out.println(str);
			
			String rowData = columns.get(1).getText();
		
			String totalInUI = columns.get(7).getText();
			totalUIAfterConvertingTofloat = Float.parseFloat(totalInUI);
			storeName = rowData;
			totalUI = totalUIAfterConvertingTofloat;
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
			
			String mpa = columns.get(8).getText();
			System.out.println("UI MPA Value"+" "+mpa);
			if (mpa.contains("NA")){
				totalUIAfterConvertingTofloat = 0.0f;
				mpaUI = totalUIAfterConvertingTofloat;
			}
			else {
				totalUIAfterConvertingTofloat = Float.parseFloat(mpa);
				storeName = rowData;
				mpaUI = totalUIAfterConvertingTofloat;
			}
			
			dataUI.setMPAUI(rowData, mpaUI);
			
			String sovi = columns.get(9).getText();
			System.out.println("UI SOVI Value"+" "+sovi);
			if (sovi.contains("NA")){
				totalUIAfterConvertingTofloat = 0.0f;
				soviUI = totalUIAfterConvertingTofloat;
			}
			else {
				totalUIAfterConvertingTofloat = Float.parseFloat(sovi);
				storeName = rowData;
				soviUI = totalUIAfterConvertingTofloat;
			}
			dataUI.setSOVIUI(rowData, soviUI);
			
			String ref = columns.get(10).getText();
			System.out.println("UI REF Value"+" "+ref);
			if (ref.contains("NA")){
				totalUIAfterConvertingTofloat = 0.0f;
				refUI = totalUIAfterConvertingTofloat;
			}
			else {
				totalUIAfterConvertingTofloat = Float.parseFloat(ref);
				storeName = rowData;
				refUI = totalUIAfterConvertingTofloat;
			}
			
			dataUI.setREFUI(rowData, refUI);
			
			//String comm = columns.get(11).getText(); //Traditional
			 String comm = columns.get(14).getText();
			System.out.println("UI COMM Value"+" "+comm);
			 if (comm.contains("NA")){
				 totalUIAfterConvertingTofloat = 0.0f;
				 commUI = totalUIAfterConvertingTofloat;
			 }
			 else {
				 totalUIAfterConvertingTofloat = Float.parseFloat(comm);
					storeName = rowData;
					commUI = totalUIAfterConvertingTofloat; 
			 }
			dataUI.setCOMMUI(rowData, commUI);;
			
		   // String price = columns.get(12).getText();// Traditional
		    String price = columns.get(15).getText();
			System.out.println("UI PRICE Value"+" "+price);
			if ( price.contains("NA")){
				totalUIAfterConvertingTofloat = 0.0f;
				pricUI = totalUIAfterConvertingTofloat;
			} else {
				totalUIAfterConvertingTofloat = Float.parseFloat(price);
				storeName = rowData;
				pricUI = totalUIAfterConvertingTofloat;
			}
			
			dataUI.setPRICEUI(rowData, pricUI);
			
			//String fresh = columns.get(13).getText();// Traditional
			 String fresh = columns.get(16).getText();
			System.out.println("UI FRESH Value"+" "+fresh);
			if (fresh.contains("NA")){
				totalUIAfterConvertingTofloat = 0.0f;
				freshUI = totalUIAfterConvertingTofloat;
			} else {
				totalUIAfterConvertingTofloat = Float.parseFloat(fresh);
				storeName = rowData;
				freshUI = totalUIAfterConvertingTofloat;
			}
			
			dataUI.setFRESHUI(rowData, freshUI);;
			
			
			
		}
		//dataUI.getTotalUI(storeName);
		dataUI.getCustUI(storeName);
		dataUI.getRowsCountUI();
		dataUI.getRailUI(storeName);
		dataUI.getCoolUI(storeName);
		//dataUI.getMPAUI(storeName);
		//dataUI.getSOVIUI(storeName);
		//dataUI.getREFUI(storeName);
		//dataUI.getCOMMUI(storeName);
		//dataUI.getPRICEUI(storeName);
		//dataUI.getFRESHUI(storeName);
		System.out.println("Reading Data from UI");
		return dataUI; 
	}	

}
