package popProbeRelatedPrograms;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingFromUI {
	WebDriver driver = new ChromeDriver();
	
	public DataFromUI reading(WebDriver driver) throws InterruptedException{
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
		DataFromUI uIData = new DataFromUI();
		for (int i = 0; i < rowsCount; i++) {
			List<WebElement> columns = tableRows.get(i).findElements(By.tagName("td"));
			String stores = columns.get(1).getText();
			String custsk = columns.get(2).getText();
			uIData.setDataUI(stores, custsk);
			}
	
	return (uIData);

}
}