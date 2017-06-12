package otherPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opentwotabs {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.get("http://popprobe.com/login");
         WebDriver driver1 = new ChromeDriver();
         driver1.get("https://www.facebook.com/");
	}

}
