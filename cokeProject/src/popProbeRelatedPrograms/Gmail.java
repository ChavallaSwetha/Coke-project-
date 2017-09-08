package popProbeRelatedPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com");
		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("schavalla@hrgdev.com");
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("saiadan2531");
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("WaidBe")).click();
		Thread.sleep(2000);
		String result = "Hope Research Group";
		WebElement table = driver.findElement(By.xpath(".//*[@id=':2a']"));
		List<WebElement> columns =  table.findElements(By.tagName("td"));
		for (int c = 0; c < columns.size(); c++) {
		String subject = columns.get(c).getText();
		WebElement email = columns.get(c);
	  	if (subject.equals(result) == true)
				{
	  				System.out.println(subject);
	  				email.click();
					break;
					}
				}
		}

	}



