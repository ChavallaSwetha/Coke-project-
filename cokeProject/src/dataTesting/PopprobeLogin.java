package dataTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import jxl.Workbook;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeLogin {
	
	
	public void logIn(WebDriver driver) throws InterruptedException {

		driver.get("http://popprobe.com/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("coke@bifortis.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("coke");
		WebElement login = driver.findElement(
				By.xpath("html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div/form/div[3]/button[1]"));
		login.click();
		Thread.sleep(2000);
	}

	/*
	 * Select Year and Month from dropdown. Select Country from dropdown. Select
	 * Channel from dropdown.
	 */
	public void selectDropDowns(WebDriver driver, String date, String country, String channel)
			throws InterruptedException {
		Thread.sleep(8000);
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
	}

	/*
	 * Using function comparingAndWritingData() compare UI data with XL data and
	 * show result as Match or Mismatch or Missing
	 */
	

	

}
