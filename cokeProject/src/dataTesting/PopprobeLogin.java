package dataTesting;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopprobeLogin {
	// WebDriver driver = new FirefoxDriver();
	public void logIn(WebDriver driver) throws InterruptedException {

		/*driver.get("http://popprobe.com/login");
	    driver.manage().window().maximize();
		Thread.sleep(7000);
		driver.findElement(By.name("email")).sendKeys("coke@bifortis.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("coke");
		WebElement login = driver.findElement(
		By.xpath("html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div/form/div[3]/button[1]"));
		login.click();
		Thread.sleep(9000);*/
		
        // For New App
		driver.get("http://beta.popprobe.com/#!/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("Email")).sendKeys("coke@bifortis.com");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("coke");
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/layout/div/md-content/md-content[2]/ui-view/md-content/form/button")).click();
		Thread.sleep(3000);
		// For New App.
	}
	
	  /*Select Year and Month from dropdown. Select Country from dropdown. Select
	  Channel from dropdown.*/
	 
		 public void selectDropDowns(WebDriver driver, String date, String country, String channel)
	 //public void selectDropDowns(WebDriver driver, String date, String country) // for Belize
			throws InterruptedException, IOException {
		/*Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div[1]/div[1]/div[1]/div/button")).click();
		// Date dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText(date)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
		// dropdown
        Thread.sleep(3000);
		driver.findElement(By.linkText(country)).click();
		Thread.sleep(3000);
		 driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div[1]/div[1]/div[5]/div/button")).click(); // Channel dropdown 
		 Thread.sleep(3000);
		  driver.findElement(By.linkText(channel)).click();
		 Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
		System.out.println("Popprobe login");*/
			
	// For New App
			  Thread.sleep(3000);
			 driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/md-menu/button")).click(); // date
			 Thread.sleep(3000);
			WebElement dateDropDown = driver.findElement(By.xpath(".//*[@id='menu_container_2']/md-menu-content"));
			dateDropDown.findElement(By.linkText(date)).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/md-menu/button")).click();//country
			 Thread.sleep(3000);
			 driver.findElement(By.linkText(country)).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[5]/md-menu/button")).click();// channel
			 Thread.sleep(3000);
			  driver.findElement(By.linkText(channel)).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/button[1]")).click();// Apply
			  Thread.sleep(3000); 
			 // For New App.
			}

	public void coolerDropDown(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div[1]/div[1]/div[7]/div/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("YES")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
	}

	public void coolerDropDownNo(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div[1]/div[1]/div[7]/div/button")).click();
		Thread.sleep(4000);
		/*driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div[1]/div[1]/div[7]/div/button")).click();
		Thread.sleep(4000);*/
		driver.findElement(By.linkText("NO")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
	}

	public void logout(WebDriver driver) {
		driver.findElement(
				By.xpath("html/body/div[1]/div[2]/div/div/header/top-nav/nav/ul[2]/li[4]/div/div/a/div/img[2]"))
				.click();
		driver.findElement(By.linkText("LOGOUT")).click();
	}

	public void newTab(WebDriver driver) throws AWTException {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		Robot keys = new Robot();
		keys.keyPress(KeyEvent.VK_CONTROL);
		keys.keyPress(KeyEvent.VK_T);
		keys.keyRelease(KeyEvent.VK_CONTROL);
		keys.keyRelease(KeyEvent.VK_T);
	}
}