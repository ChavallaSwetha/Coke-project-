package dataTesting;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PopprobeNewLogin {

	public void logIn(WebDriver driver) throws InterruptedException {
	
	
	driver.get("http://beta.popprobe.com/#!/auth/login");
	Thread.sleep(5000);
	driver.findElement(By.name("Email")).sendKeys("coke@bifortis.com");
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys("coke");
	Thread.sleep(3000);
	driver.findElement(By.xpath("html/body/layout/div/md-content/md-content[2]/ui-view/md-content/form/button")).click(); //Login button
	Thread.sleep(3000);
	
}
	 public void selectDropDowns(WebDriver driver, String date, String country, String channel)
	  // public void selectDropDowns(WebDriver driver, String date, String country) // for Belize
			throws InterruptedException, IOException {
		 
		  Thread.sleep(3000);
		 driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/md-menu/button")).click(); // date
		 Thread.sleep(3000);
		WebElement dateDropDown = driver.findElement(By.xpath(".//*[@id='menu_container_2']/md-menu-content"));
		Thread.sleep(3000);
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
		 
	 }
	 public void coolerDropDown(WebDriver driver) throws InterruptedException {
			Thread.sleep(4000);
			driver.findElement(By.xpath("html/body/layout/div/md-content/md-content[2]/filter/div/section/section/div/div/div/div[1]/div[7]/md-menu/button")).click();
			Thread.sleep(4000);
			driver.findElement(By.linkText("YES")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/button[1]")).click(); // Apply
			// button
			Thread.sleep(4000);
		}

		public void coolerDropDownNo(WebDriver driver) throws InterruptedException {
			driver.findElement(By.xpath("html/body/layout/div/md-content/md-content[2]/filter/div/section/section/div/div/div/div[1]/div[7]/md-menu/button")).click();
			Thread.sleep(4000);
			/*driver.findElement(By.xpath("html/body/layout/div/md-content/md-content[2]/filter/div/section/section/div/div/div/div[1]/div[7]/md-menu/button")).click();
			Thread.sleep(4000);*/
			driver.findElement(By.linkText("NO")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/button[1]")).click(); // Apply
			// button
			Thread.sleep(4000);
		}
	 public void logout(WebDriver driver) throws InterruptedException {
			driver.findElement(
					By.xpath("html/body/layout/div/nav-bar/md-toolbar/div/div/div[3]/div[4]/md-menu/button"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("LOGOUT")).click();
		}
}
