package dataTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterBasedOnCriteria {
	/*
	 * Select Year and Month from dropdown. Select Country from dropdown. Select
	 * Channel from dropdown.
	 */
	public void selectDropDowns(WebDriver driver, String date, String country, String channel)
			throws InterruptedException {
		Thread.sleep(9000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click(); // Date
		// dropdown
		Thread.sleep(9000);
		driver.findElement(By.linkText(date)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText(country)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[4]/div/button")).click(); // Channel
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText(channel)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
		System.out.println("Filter based on criteria");
	}
}
