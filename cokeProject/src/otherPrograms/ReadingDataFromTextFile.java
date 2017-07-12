package otherPrograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromTextFile {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
			 WebDriver driver = new ChromeDriver();
			
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
			
			
				Thread.sleep(8000);
				driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click(); // Date
				// dropdown
				Thread.sleep(3000);
			FileReader fr = new FileReader("C:/Users/Mona Lisa/Desktop/Reading_File.txt");
				BufferedReader br = new BufferedReader(fr);
				
				String[] inputs = new String[5];
				String input;
				
				for (int i=0; i<5;i++){
					input = br.readLine();
					inputs[i]=input;
				}
				driver.findElement(By.linkText(inputs[0])).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
				// dropdown
				Thread.sleep(3000);

				
				driver.findElement(By.linkText(inputs[1])).click();
				Thread.sleep(4000);
				driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[5]/div/button")).click(); // Channel
				// dropdown
				
				System.out.println("channel from UI"+ "   " +inputs[2]);
				Thread.sleep(3000);
				driver.findElement(By.linkText(inputs[2])).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
				// button
				Thread.sleep(4000);
				br.close();
				System.out.println("Popprobe login");
			}
		}




