package otherPrograms;

import java.text.DateFormatSymbols;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCalander {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.redbus.in/");
		driver.findElement(By.id("src")).sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.id("dest")).sendKeys("Hyderabad");
		Thread.sleep(5000);
		WebElement calender =driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/div/label"));
		calender.click();
		calender.click();
		String givendate = "12";
		WebElement dates = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']"));
		List<WebElement> rows =  dates.findElements(By.tagName("tr"));
		int rowsize = rows.size();
		System.out.println("No of rows  "+ rowsize);
		for (int r=0; r<rowsize;r++){
		List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
		for (int c=0;c<columns.size();c++){
			String date = columns.get(c).getText();
			//System.out.println(date);
			if (date.equals(givendate)){
				System.out.println(date);
				columns.get(c).click();
			}
		}
		}
		
	}

}
