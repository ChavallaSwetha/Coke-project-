package dataTesting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class PopprobeComparingCountryLevelDataWithAndWithOutCooler {

	public static void main(String[] args)
			throws InterruptedException, BiffException, IOException, IOException, WriteException {
		// System.setProperty("webdriver.chrome.driver",
		// "C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		float mpaUI = 0;
		float sOVIf = 0;
		float rEF = 0;
		float coMMEX = 0;
		float prICE = 0;
		float freshNess = 0;
		PopprobeLogin login = new PopprobeLogin();
		String date = "2016 - 12";
		String country = "BAHAMAS";
		String channel = "HOME MARKET TRADITIONAL";
		login.logIn(driver);
		Thread.sleep(8000);
		login.selectDropDowns(driver, date, country, channel);
		String total = driver
				.findElement(By.xpath(".//*[@id='dashboard-container']/div[1]/div[4]/div[1]/div[1]/div[1]/div/div[1]"))
				.getText();
		float iceTotal = Float.parseFloat(total);
		WebElement kpiTable = driver
				.findElement(By.xpath(".//*[@id='dashboard-container']/div[1]/div[4]/div[1]/div[2]/div/table/tbody"));
		List<WebElement> rowsInTable = kpiTable.findElements(By.tagName("tr"));
		int rowsCountUI = rowsInTable.size();
		System.out.println(rowsCountUI);
		List<WebElement> columns = rowsInTable.get(1).findElements(By.tagName("td"));
		String mPA = columns.get(1).getText();
		mpaUI = Float.parseFloat(mPA);
		String soVI = columns.get(2).getText();
		sOVIf = Float.parseFloat(soVI);
		String refrigiration = columns.get(3).getText();
		rEF = Float.parseFloat(refrigiration);
		String communion = columns.get(4).getText();
		coMMEX = Float.parseFloat(communion);
		String price = columns.get(5).getText();
		prICE = Float.parseFloat(price);
		String freshNEss = columns.get(6).getText();
		freshNess = Float.parseFloat(freshNEss);
		File readFile = new File("C:/Users/Mona Lisa/Desktop/Datafor countrylevel testing.xls");
		Workbook readWbk = Workbook.getWorkbook(readFile);
		Sheet sh = readWbk.getSheet(0);
		int rowsCountXl = sh.getRows();
		System.out.println("No. of rows in XL" + "         " + rowsCountXl);
		String mpa = "Portafolio Prioritario";
		String sovi = "SOVI";
		String refregiratio = "Refrigeración";
		String commuNion = "Comunicación y exhibición";
		String priCe = "Respeto a Precio";
		String freshNESs = "Frescura de Producto";
		String toTal = "ICE Total Tradicional";
		String cooler = "1";
		String[] kPI = new String[rowsCountXl];
		String[] countrys = new String[rowsCountXl];
		String[] dates = new String[rowsCountXl];
		String[] channels = new String[rowsCountXl];
		String[] ice = new String[rowsCountXl];
		for (int xlRow = 0; xlRow < rowsCountXl; xlRow++) {
			for (int clmn = 0; clmn < 1; clmn++) {
				Cell countryData = sh.getCell(clmn, xlRow);
				countrys[xlRow] = countryData.getContents();
				for (int chaclmn = 1; chaclmn < 2; chaclmn++) {
					Cell channelsData = sh.getCell(chaclmn, xlRow);
					channels[xlRow] = channelsData.getContents();
					for (int dateclmn = 2; dateclmn < 3; dateclmn++) {
						Cell datesData = sh.getCell(dateclmn, xlRow);
						dates[xlRow] = datesData.getContents();
						for (int iceclmn = 6; iceclmn < 7; iceclmn++) {
							Cell iceData = sh.getCell(iceclmn, xlRow);
							ice[xlRow] = iceData.getContents();
						}
					}
				}
			}
			String result = null;
			FileOutputStream writefile = new FileOutputStream("C:/Users/Mona Lisa/Downloads/country data.xls");
			WritableWorkbook wwbook = Workbook.createWorkbook(writefile);
			WritableSheet sheet = wwbook.createSheet("COUNTRY", 0);
			Label countryHeading = new Label(0, 0, "COUNTRY");
			sheet.addCell(countryHeading);
			Label dateHeading = new Label(1, 0, "DATE");
			sheet.addCell(dateHeading);
			Label channelHeading = new Label(2, 0, "CHANNEL");
			sheet.addCell(channelHeading);
			Label kpiHeading = new Label(3, 0, "KPIs");
			sheet.addCell(kpiHeading);
			Label iceHeading = new Label(4, 0, "ICE_XL");
			sheet.addCell(iceHeading);
			Label iceinUI = new Label(5, 0, "ICE_UI");
			sheet.addCell(iceinUI);
			Label resultHeading = new Label(6, 0, "RESULT");
			sheet.addCell(resultHeading);
			for (int r = 0; r < rowsCountXl; r++) {
				Cell kpiData = sh.getCell(5, r);
				kPI[r] = kpiData.getContents();
			}
			for (int i = 0; i < rowsCountXl; i++) {
				for (int r = 0; r < rowsCountXl; r++) {
					if ((kPI[r]).equals(mpa)) {
						Label kpiAdd = new Label(3, 1, kPI[r]);
						sheet.addCell(kpiAdd);
						Cell pid = sh.getCell(4, r);
						String pID = pid.getContents();
						if (pID.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							Label iceAdd = new Label(4, 1, icevalue);
							sheet.addCell(iceAdd);
							String icereplacewithf = icevalue.replaceAll("%", "f");
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 1, countrys[r]);
							sheet.addCell(countryAdd);
							Label dateAdd = new Label(1, 1, dates[r]);
							sheet.addCell(dateAdd);
							Label channelAdd = new Label(2, 1, channels[r]);
							sheet.addCell(channelAdd);
							Label mpaAdd = new Label(5, 1, mPA);
							sheet.addCell(mpaAdd);
							System.out.println("UI MPA" + "          " + mpaUI);
							System.out.println("XL MPA" + "          " + afterconvertingtofloat);
							float difference = Math.abs(afterconvertingtofloat - mpaUI);
							if (difference >= 0.5) {
								result = "Mismatch";
							} else {
								result = "Match";
							}
						}
						
						Label resultAdd = new Label(6, 1, result);
						sheet.addCell(resultAdd);

					} else if ((kPI[r]).equals(sovi)) {
						Label kpiAdd = new Label(3, 2, kPI[r]);
						sheet.addCell(kpiAdd);
						Cell pid = sh.getCell(4, r);
						String pID = pid.getContents();
						if (pID.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							Label iceAdd = new Label(4, 2, icevalue);
							sheet.addCell(iceAdd);
							String icereplacewithf = icevalue.replaceAll("%", "f");
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 2, countrys[r]);
							sheet.addCell(countryAdd);
							Label dateAdd = new Label(1, 2, dates[r]);
							sheet.addCell(dateAdd);
							Label channelAdd = new Label(2, 2, channels[r]);
							sheet.addCell(channelAdd);
							Label soviAdd = new Label(5, 2, soVI);
							sheet.addCell(soviAdd);
							System.out.println("UI SOVI" + "          " + sOVIf);
							System.out.println("XL SOVI" + "          " + afterconvertingtofloat);
							float difference = Math.abs(afterconvertingtofloat - sOVIf);
							if (difference >= 0.5) {
								result = "Mismatch";
							} else {
								result = "Match";
							}
						}
						Label resultAdd = new Label(6, 2, result);
						sheet.addCell(resultAdd);

					} else if ((kPI[r]).equals(refregiratio)) {
						Label kpiAdd = new Label(3, 3, kPI[r]);
						sheet.addCell(kpiAdd);
						Cell pid1 = sh.getCell(4, r);
						String pID1 = pid1.getContents();
						if (pID1.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							Label iceAdd = new Label(4, 3, icevalue);
							sheet.addCell(iceAdd);
							String icereplacewithf = icevalue.replaceAll("%", "f");
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 3, countrys[r]);
							sheet.addCell(countryAdd);
							Label dateAdd = new Label(1, 3, dates[r]);
							sheet.addCell(dateAdd);
							Label channelAdd = new Label(2, 3, channels[r]);
							sheet.addCell(channelAdd);
							Label refAdd = new Label(5, 3, refrigiration);
							sheet.addCell(refAdd);
							System.out.println("UI refregeratio" + "          " + rEF);
							System.out.println("XL refregeratio" + "          " + afterconvertingtofloat);
							float difference = Math.abs(afterconvertingtofloat - rEF);
							if (difference >= 0.5) {
								result = "Mismatch";
							} else {
								result = "Match";
							}
						}
						Label resultAdd = new Label(6, 3, result);
						sheet.addCell(resultAdd);

					} else if ((kPI[r]).equals(commuNion)) {
						Label kpiAdd = new Label(3, 4, kPI[r]);
						sheet.addCell(kpiAdd);
						Cell pid1 = sh.getCell(4, r);
						String pID1 = pid1.getContents();
						if (pID1.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							Label iceAdd = new Label(4, 4, icevalue);
							sheet.addCell(iceAdd);
							String icereplacewithf = icevalue.replaceAll("%", "f");
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 4, countrys[r]);
							sheet.addCell(countryAdd);
							Label dateAdd = new Label(1, 4, dates[r]);
							sheet.addCell(dateAdd);
							Label channelAdd = new Label(2, 4, channels[r]);
							sheet.addCell(channelAdd);
							Label communionAdd = new Label(5, 4, communion);
							sheet.addCell(communionAdd);
							System.out.println("UI CommunionYEX" + "          " + coMMEX);
							System.out.println("XL CommunionYEX" + "          " + afterconvertingtofloat);
							float difference = Math.abs(afterconvertingtofloat - coMMEX);
							if (difference >= 0.5) {
								result = "Mismatch";
							} else {
								result = "Match";
							}
						}
						Label resultAdd = new Label(6, 4, result);
						sheet.addCell(resultAdd);

					} else if ((kPI[r]).equals(priCe)) {
						Label kpiAdd = new Label(3, 5, kPI[r]);
						sheet.addCell(kpiAdd);
						Cell pid1 = sh.getCell(4, r);
						String pID1 = pid1.getContents();
						if (pID1.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							String icereplacewithf = icevalue.replaceAll("%", "f");
							Label iceAdd = new Label(4, 5, icevalue);
							sheet.addCell(iceAdd);
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 5, countrys[r]);
							sheet.addCell(countryAdd);
							Label dateAdd = new Label(1, 5, dates[r]);
							sheet.addCell(dateAdd);
							Label channelAdd = new Label(2, 5, channels[r]);
							sheet.addCell(channelAdd);
							Label priceAdd = new Label(5, 5, price);
							sheet.addCell(priceAdd);
							System.out.println("UI PRICE" + "          " + prICE);
							System.out.println("XL PRICE" + "          " + afterconvertingtofloat);
							float difference = Math.abs(afterconvertingtofloat - prICE);
							if (difference >= 0.5) {
								result = "Mismatch";
							} else {
								result = "Match";
							}
						}
						Label resultAdd = new Label(6, 5, result);
						sheet.addCell(resultAdd);

					} else if ((kPI[r]).equals(freshNESs)) {
						Label kpiAdd = new Label(3, 6, kPI[r]);
						sheet.addCell(kpiAdd);
						Cell pid1 = sh.getCell(4, r);
						String pID1 = pid1.getContents();
						if (pID1.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							String icereplacewithf = icevalue.replaceAll("%", "f");
							Label iceAdd = new Label(4, 6, icevalue);
							sheet.addCell(iceAdd);
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 6, countrys[r]);
							sheet.addCell(countryAdd);
							Label dateAdd = new Label(1, 6, dates[r]);
							sheet.addCell(dateAdd);
							Label channelAdd = new Label(2, 6, channels[r]);
							sheet.addCell(channelAdd);
							Label freshnessAdd = new Label(5, 6, freshNEss);
							sheet.addCell(freshnessAdd);
							System.out.println("UI FRESHNESS" + "          " + freshNess);
							System.out.println("XL FRESHNESS" + "          " + afterconvertingtofloat);
							float difference = Math.abs(afterconvertingtofloat - freshNess);
							if (difference >= 0.5) {
								result = "Mismatch";
							} else {
								result = "Match";
							}
						}
						Label resultAdd = new Label(6, 6, result);
						sheet.addCell(resultAdd);
					}

					else if ((kPI[r]).equals(toTal)) {
						Label kpiAdd = new Label(3, 6, kPI[r]);
						sheet.addCell(kpiAdd);
						Cell iCE = sh.getCell(6, r);
						String icevalue = iCE.getContents();
						String icereplacewithf = icevalue.replaceAll("%", "f");
						Label iceAdd = new Label(4, 6, icevalue);
						sheet.addCell(iceAdd);
						float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
						Label countryAdd = new Label(0, 6, countrys[r]);
						sheet.addCell(countryAdd);
						Label dateAdd = new Label(1, 6, dates[r]);
						sheet.addCell(dateAdd);
						Label channelAdd = new Label(2, 6, channels[r]);
						sheet.addCell(channelAdd);
						Label totalAdd = new Label(5, 6, total);
						sheet.addCell(totalAdd);
						System.out.println("UI FRESHNESS" + "          " + iceTotal);
						System.out.println("XL FRESHNESS" + "          " + afterconvertingtofloat);
						float difference = Math.abs(iceTotal - afterconvertingtofloat);
						if (difference >= 0.5) {
							result = "Mismatch";
						} else {
							result = "Match";
						}
					}
					Label resultAdd = new Label(6, 6, result);
					sheet.addCell(resultAdd);
				}
			}

			wwbook.write();
			wwbook.close();
		}
	}
}
