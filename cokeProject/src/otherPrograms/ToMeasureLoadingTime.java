package otherPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToMeasureLoadingTime {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://popprobe.com/login");
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("coke@bifortis.com");
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("coke");
		Thread.sleep(5000);	
		WebElement login = driver.findElement(
				By.xpath("html/body/div[1]/div[2]/div/section/div[2]/div[2]/div/div/form/div[3]/button[1]"));
		login.click();
        long start = System.currentTimeMillis();
        System.out.println(start);
       
	}

}
