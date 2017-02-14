package dataTesting;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadingdatafromUI {
	/*
	 * After selecting date, country and channel go to Datagrid. Using function
	 * readingDataFromUI() read datagrid data.
	 */

	// public static void main(String[] args) {
	private String[] namesUI;
	private int rowsCountUI;
	private String[] totalBeforeConvertingUI;
	private Float[] totalUI;

	public ReadingdatafromUI readingDataFromUI(WebDriver driver) throws InterruptedException {
		String[] namesUI;
		Float totalUIAfterConvertingTofloat;
		Float[] totalUI;
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
		namesUI = new String[rowsCount];
		totalUI = new Float[rowsCount];
		totalUIBeforeConvertingToString = new String[rowsCount];
		ReadingdatafromUI dataUI = new ReadingdatafromUI();
		for (int i = 0; i < rowsCount; i++) {
			List<WebElement> columns = tableRows.get(i).findElements(By.tagName("td"));
			String rowData = columns.get(0).getText();
			String totalInUI = columns.get(3).getText();
			totalUIAfterConvertingTofloat = Float.parseFloat(totalInUI);
			namesUI[i] = rowData;
			totalUI[i] = totalUIAfterConvertingTofloat;
			totalUIBeforeConvertingToString[i] = totalInUI;

		}
		dataUI.namesUI = namesUI;
		dataUI.rowsCountUI = rowsCount;
		dataUI.totalBeforeConvertingUI = totalUIBeforeConvertingToString;
		dataUI.totalUI = totalUI;
		return dataUI;
	}
	
	public String[] getnamesUI(){
   		return namesUI;
   	}
   	public void setnamesUI(String[] namesfromUI){
   		this.namesUI = namesfromUI;
   	}
   	public void setrowsCountUI(int rowsCount){
   		this.rowsCountUI = rowsCount;
   	}
   	public int getrowsCount(){
   		return rowsCountUI;
   	}
   	public void setTotalstringUI(String[] totalBeforeConvertinginUI){
   		this.totalBeforeConvertingUI = totalBeforeConvertinginUI;
   	}
       public String[] getTotalstringUI(){
       	return totalBeforeConvertingUI;
       }
       public void setTotalUI(Float[] totalUI){
       	this.totalUI = totalUI;
       	
       }
       public Float[] getTotalUI(){
       	return totalUI;
       }
    	   
	
}
