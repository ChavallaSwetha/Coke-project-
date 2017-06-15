package dataTesting;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopprobeLogin {
	// WebDriver driver = new FirefoxDriver();
	public void logIn(WebDriver driver) throws InterruptedException {

		driver.get("http://popprobe.com/login");
		/*
		 * Thread.sleep(3000); driver.manage().window().maximize();
		 */
		Thread.sleep(7000);
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

	// public void selectDropDowns(WebDriver driver, String date, String country, String channel)
	public void selectDropDowns(WebDriver driver, String date, String country) // for
																				// Belize
			throws InterruptedException, IOException {
		Thread.sleep(8000);
		 driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click();
		//  Date
		// dropdown
		Thread.sleep(3000);

		driver.findElement(By.linkText(date)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText(country)).click();
		Thread.sleep(3000);
		// driver.findElement(By.linkText(channel)).click();
		/*
		 * Thread.sleep(4000); driver.findElement(By.linkText(channel)).click();
		 * for Belize
		 */
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
		System.out.println("Popprobe login");
	}
	public void logout(WebDriver driver){
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/header/top-nav/nav/ul[2]/li[4]/div/div/a/div/img[2]")).click();
		driver.findElement(By.linkText("LOGOUT")).click();
	}
	public void newTab(WebDriver driver) throws AWTException{
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		Robot keys = new Robot();
		keys.keyPress(KeyEvent.VK_CONTROL);
		keys.keyPress(KeyEvent.VK_T);
		keys.keyRelease(KeyEvent.VK_CONTROL);
		keys.keyRelease(KeyEvent.VK_T);
	}
}