package dataTesting;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class PopprobeLogin {
	
	
	public void logIn(WebDriver driver) throws InterruptedException {

		driver.get("http://popprobe.com/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("coke@bifortis.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("coke");
		WebElement login = driver.findElement(
				By.xpath("html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div/form/div[3]/button[1]"));
		login.click();
		Thread.sleep(5000);
	}

	

	
	

	

}
