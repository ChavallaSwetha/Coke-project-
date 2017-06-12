package dataTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComparingStoresInMapsandDatagrid {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		PopprobeLogin login = new PopprobeLogin();
		login.logIn(driver);
		String date = "2017 - 4";
		String country = "BAHAMAS";
		String city = "NASSAU";
		String channel = "ON PREMISE"; 
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click(); // Date
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText(date)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText(country)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[3]/div/button")).click(); // City dropdown
		Thread.sleep(4000);
		driver.findElement(By.linkText(city)).click();
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[5]/div/button")).click(); // Channel
		System.out.println("channel from UI"+ "   " +channel);
		Thread.sleep(3000);
		driver.findElement(By.linkText(channel)).click();
		/*
		 * Thread.sleep(4000); driver.findElement(By.linkText(channel)).click();
		 * for Belize
		 */
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
		

	}

}
