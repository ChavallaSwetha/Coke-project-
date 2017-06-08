package dataTesting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopprobeLogin {
	// WebDriver driver = new FirefoxDriver();
	public void logIn(WebDriver driver) throws InterruptedException {

		driver.get("http://popprobe.com/login");
		/*
		 * Thread.sleep(3000); driver.manage().window().maximize();
		 */
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
	//public void selectDropDowns(WebDriver driver, String date, String country, String channel)
			public void selectDropDowns(WebDriver driver, String date, String
			 country) //for Belize
			throws InterruptedException, IOException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click(); // Date
		// dropdown
		Thread.sleep(3000);
		//FileReader fr = new FileReader("C:/Users/Mona Lisa/Desktop/Reading_File.txt");
		//BufferedReader br = new BufferedReader(fr);
		//String date = br.readLine();
		driver.findElement(By.linkText(date)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
		// dropdown
		Thread.sleep(3000);

		//String country = br.lines().skip(0).findFirst().get();
		driver.findElement(By.linkText(country)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[5]/div/button")).click(); // Channel
		// dropdown
		//String channel = br.lines().skip(2).findFirst().get();
		//driver.findElement(By.cssSelector("fa fa-caret-down arrow-img")).click();
		/*System.out.println("channel from UI"+ "   " +channel);
		Thread.sleep(3000);
		driver.findElement(By.linkText(channel)).click();*/
		
		  //Thread.sleep(4000); driver.findElement(By.linkText(channel)).click();
		 // for Belize
		 
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
		//br.close();
		System.out.println("Popprobe login");
	}
}