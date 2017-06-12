package otherPrograms;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureScreenShots {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://popprobe.com/login");
		
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("coke@bifortis.com");
		Thread.sleep(5000);
		//TakesScreenshot ts =(TakesScreenshot)driver;
		try {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/AfterLogin.png"));
		}
		catch (IOException e){
			System.out.println(e);
		}
		
	}

}
