package dataTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeLogin {
	
	
	public void logIn(WebDriver driver) throws InterruptedException {

		driver.get("http://popprobe.com/login");
		Thread.sleep(9000);
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
	public void selectDropDowns(WebDriver driver, String date, String country, String channel)
			throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click(); // Date
		// dropdown
		Thread.sleep(9000);
		driver.findElement(By.linkText(date)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText(country)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[4]/div/button")).click(); // Channel
		// dropdown
		Thread.sleep(3000);
		driver.findElement(By.linkText(channel)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
	}

	/*
	 * Using function comparingAndWritingData() compare UI data with XL data and
	 * show result as Match or Mismatch or Missing
	 */
	

	public void comparingAndWritingData(int rowsCountUI, String[] totalBeforeConvertingUI, int rowsXl, String[] namesUI,
			String[] storeNameXl, String[] iceXl, String[] countryXL, String[] dateXL, String[] namesUIwrite,
			String[] channelXL, String[] subChannelXL, String[] coolerXL, Float[] totalUI, Float[] iceValueXl)
			throws IOException, WriteException {
		FileOutputStream fileOutput = new FileOutputStream("C:/Users/Mona Lisa/Downloads/Writing file.xls");
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		WritableSheet writeSheet = writeWorkBook.createSheet("BAHAMAS ON PREMISE", 2);
		int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7, j = 8;
		Label country = new Label(a, 0, "COUNTRY");
		writeSheet.addCell(country);
		Label date = new Label(b, 0, "DATE");
		writeSheet.addCell(date);
		Label storeNameUI = new Label(c, 0, "STORE_NAME_UI");
		writeSheet.addCell(storeNameUI);
		Label channel = new Label(d, 0, "CHANNEL");
		writeSheet.addCell(channel);
		Label subChannel = new Label(e, 0, "SUB_CHANNEL");
		writeSheet.addCell(subChannel);
		Label cooler = new Label(f, 0, "COOLER");
		writeSheet.addCell(cooler);
		Label toTalUI = new Label(g, 0, "TOTAL_UI");
		writeSheet.addCell(toTalUI);
		Label ice = new Label(h, 0, "ICE");
		writeSheet.addCell(ice);
		Label resultColumnName = new Label(j, 0, "RESULT");
		writeSheet.addCell(resultColumnName);
		for (int i = 0; i < rowsCountUI; i++) {
			Label result = null;
			Label totalFromUI = new Label(g, i + 1, totalBeforeConvertingUI[i]);
			writeSheet.addCell(totalFromUI);
			System.out.println("total of UI");
			for (int r = 1; r < rowsXl; r++) {
				if ((namesUI[i].replaceAll("[ ,]", "")).equalsIgnoreCase(storeNameXl[r].replaceAll("[ ,]", ""))) {
					Label iceFromXL = new Label(h, i + 1, iceXl[r]);
					writeSheet.addCell(iceFromXL);
					Label countryFromXL = new Label(a, i + 1, countryXL[r]);
					writeSheet.addCell(countryFromXL);
					Label dateFromXL = new Label(b, i + 1, dateXL[r]);
					writeSheet.addCell(dateFromXL);
					Label storeNameFromUI = new Label(c, i + 1, namesUIwrite[i]);
					writeSheet.addCell(storeNameFromUI);
					Label channelFromXL = new Label(d, i + 1, channelXL[r]);
					writeSheet.addCell(channelFromXL);
					Label subChannelFromXL = new Label(e, i + 1, subChannelXL[r]);
					writeSheet.addCell(subChannelFromXL);
					Label cooleRXL = new Label(f, i + 1, coolerXL[r]);
					writeSheet.addCell(cooleRXL);
					float diffBetweentotalUIAndIceValueXL = Math.abs(totalUI[i] - iceValueXl[r]);
					if (diffBetweentotalUIAndIceValueXL >= 0.5) {
						result = new Label(j, i + 1, "Mismatch");

					} else {
						result = new Label(j, i + 1, "Match");

					}
				}
			}
			if (result == null) {
				result = new Label(j, i + 1, "Missing");

			}
			writeSheet.addCell(result);
		}
		writeWorkBook.write();
		writeWorkBook.close();
	}

}
