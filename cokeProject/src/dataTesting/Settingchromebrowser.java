package dataTesting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Settingchromebrowser {

	
		
	static WebDriver driver = new ChromeDriver();
		/* Login into popprobe.com */
		
		public static void logIn(WebDriver driver) throws InterruptedException {
			driver.get("http://popprobe.com/login");
			Thread.sleep(4000);
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
		public static void selectDropDowns(WebDriver driver,String date, String country, String channel) throws InterruptedException {
			Thread.sleep(8000);
			driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click(); // Date
			// dropdown
			Thread.sleep(9000);
			driver.findElement(By.linkText(date)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
			// button
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[2]/div/button")).click(); // Country
			// dropdown
			Thread.sleep(3000);
			driver.findElement(By.linkText(country)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
			// button
			Thread.sleep(5000);
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
		 * After selecting date, country and channel go to Datagrid. Using function
		 * readingDataFromUI() read datagrid data.
		 */
		public static ReadingdatafromUI readingDataFromUI(WebDriver driver) throws InterruptedException {
			String[] namesUI = null;
			Float totalUIAfterConvertingTofloat;
			Float[] totalUI = null;
			String[] totalUIBeforeConvertingToString;
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='sidebar-panel']/ul/li[3]/a/img")).click(); // Datagrid
			Thread.sleep(9000);
			WebElement customerData = driver.findElement(By.xpath(
					".//*[@id='shell-view']/section/section/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/table/tbody"));
			Thread.sleep(3000);
			List<WebElement> tableRows = customerData.findElements(By.tagName("tr"));
			Thread.sleep(3000);
			int rowsCount = tableRows.size();
			System.out.println("No of rows in UI"+"      "+rowsCount);
			namesUI = new String[rowsCount];
			totalUI = new Float[rowsCount];
			totalUIBeforeConvertingToString = new String[rowsCount];
			ReadingdatafromUI dataUI = new ReadingdatafromUI();
			for (int i = 0; i < rowsCount; i++) {
				List<WebElement> columns = tableRows.get(i).findElements(By.tagName("td"));
				String rowData = columns.get(0).getText();
				String totalInUI = columns.get(3).getText();
				totalUIAfterConvertingTofloat = Float.parseFloat(totalInUI);
				namesUI[i] = rowData;
				totalUI[i] = totalUIAfterConvertingTofloat;
				totalUIBeforeConvertingToString[i] = totalInUI;

			}
			/*dataUI.namesUI = namesUI;
			dataUI.rowsCountUI = rowsCount;
			dataUI.totalBeforeConvertingUI = totalUIBeforeConvertingToString;
			dataUI.totalUI = totalUI;*/
			return dataUI;
		}

		/*
		 * Using function readingDataFromXL() read data from XL (Storenames and ICE
		 * values)
		 */
		public static ReadingDataFromxl readingDataFromXL() throws BiffException, IOException {
			String[] storeNameXL = null;
			Float[] iceValueXL = null;
			String[] channelXLbeforeconverting = null;
			String[] coolerXL = null;
			String[] countryXL = null;
			String[] dateXL = null;
			String[] channelXL = null;
			String[] subChannelXL = null;
			ReadingDataFromxl xlData = new ReadingDataFromxl();
			File fs = new File("C:/Users/Mona Lisa/Downloads/Reading file.xls");
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Bahamas Onpremise data");
			int row = sh.getRows();
			int rowsCountXL = row;
			System.out.println("No of rows in XL" +"     "+rowsCountXL);
			countryXL = new String[rowsCountXL];
			channelXLbeforeconverting = new String[rowsCountXL];
			coolerXL = new String[rowsCountXL];
			dateXL = new String[rowsCountXL];
			channelXL = new String[rowsCountXL];
			subChannelXL = new String[rowsCountXL];
			storeNameXL = new String[rowsCountXL];
			iceValueXL = new Float[rowsCountXL];
			String[] ice = new String[rowsCountXL];
			String[] iceValueReplacingWithf = new String[rowsCountXL];
			for (int rwXL = 1; rwXL < rowsCountXL; rwXL++) {
				for (int str = 0; str < 1; str++) {
					Cell strNameXL = sh.getCell(str, rwXL);
					storeNameXL[rwXL] = strNameXL.getContents();
				 for (int clr= 1; clr<2;clr++){
					 String S ="sin";
					 String C ="con";
					 Cell collr = sh.getCell(clr, rwXL);
					 channelXLbeforeconverting[rwXL] = collr.getContents();
					 String[] chanNelXL = channelXLbeforeconverting[rwXL].split("\\s");
						 if (chanNelXL[1].contains(S)){
							 coolerXL[rwXL]= chanNelXL[1].replaceAll(S, "Yes");
						 }
						 else{
							 coolerXL[rwXL]= chanNelXL[1].replaceAll(C, "No"); 
						 }
					for (int iceclmn = 2; iceclmn < 3; iceclmn++) {
						Cell icXL = sh.getCell(iceclmn, rwXL);
						ice[rwXL] = icXL.getContents();
						iceValueReplacingWithf[rwXL] = ice[rwXL].replace('%', 'f');
						iceValueXL[rwXL] = Float.parseFloat(iceValueReplacingWithf[rwXL]);
						for (int co = 3; co < 4; co++) {
							Cell conTryXL = sh.getCell(co, rwXL);
							countryXL[rwXL] = conTryXL.getContents();
							for (int dt = 4; dt < 5; dt++) {
								Cell dtXL = sh.getCell(dt, rwXL);
								dateXL[rwXL] = dtXL.getContents();
								for (int ch = 5; ch < 6; ch++) {
									Cell chanlXL = sh.getCell(ch, rwXL);
									channelXL[rwXL] = chanlXL.getContents();
									for (int subch = 6; subch < 7; subch++) {
										Cell subChXL = sh.getCell(subch, rwXL);
										subChannelXL[rwXL] = subChXL.getContents();
									}
								  }
								}
							}
						}
					}
				}

			}
			xlData.setRowsXL(rowsCountXL);
			xlData.setStoreNameXL(storeNameXL);
			xlData.setIceXL(ice);
			xlData.setCooLerXL(coolerXL);
			xlData.setIcevaLueXL(iceValueXL);
			xlData.setCounTryXL(countryXL);
			xlData.setDaTeXL(dateXL);
			xlData.setChaNnelXL(channelXL);
			xlData.setSubChanneLXL(subChannelXL);
			return xlData;
		}

		/*
		 * Using function comparingAndWritingData() compare UI data with XL data and
		 * show result as Match or Mismatch or Missing
		 */
		public static void comparingAndWritingData(int rowsXl, String countryXL[], String dateXL[],String namesUi[],String channelXL[],
				String subChannelXL[],String coolerXL[],String totalBeforeConvertingToStringUi[],String storeNameXl[],  String iceXl[], int rowsCountUi, 
				Float totalUi[], Float iceValueXl[] )
				throws IOException, WriteException {
			FileOutputStream fileOutput = new FileOutputStream("C:/Users/Mona Lisa/Downloads/Writing file.xls");
			//Workbook workbook = Workbook.getWorkbook(fileOutput);
			WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
			WritableSheet writeSheet = writeWorkBook.createSheet("BAHAMAS ON PREMISE",2);
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
			 Label cooler = new Label(f,0,"COOLER");
			 writeSheet.addCell(cooler);
			Label totalUI = new Label(g, 0, "TOTAL_UI");
			writeSheet.addCell(totalUI);
			Label ice = new Label(h, 0, "ICE");
			writeSheet.addCell(ice);
			Label resultColumnName = new Label(j, 0, "RESULT");
			writeSheet.addCell(resultColumnName);
			for (int i = 0; i < rowsCountUi; i++) {
				Label result = null;
				Label totalFromUI = new Label(g, i+1, totalBeforeConvertingToStringUi[i]);
				writeSheet.addCell(totalFromUI);
				for (int r = 1; r < rowsXl; r++) {
					if ((namesUi[i].replaceAll("[ ,]","")).equalsIgnoreCase(storeNameXl[r].replaceAll("[ ,]", ""))) {
						Label iceFromXL = new Label(h, i + 1, iceXl[r]);
						writeSheet.addCell(iceFromXL);
						Label countryFromXL = new Label(a, i+1, countryXL[r]);
						writeSheet.addCell(countryFromXL);
						Label dateFromXL = new Label(b, i+1, dateXL[r]);
						writeSheet.addCell(dateFromXL);
						Label storeNameFromUI = new Label(c, i+1, namesUi[i]);
						writeSheet.addCell(storeNameFromUI);
						Label channelFromXL = new Label(d, i+1, channelXL[r]);
						writeSheet.addCell(channelFromXL);
						Label subChannelFromXL = new Label(e, i+1, subChannelXL[r]);
						writeSheet.addCell(subChannelFromXL);
						Label cooleRXL = new Label(f, i+1, coolerXL[r]);
						writeSheet.addCell(cooleRXL);
						float diffBetweentotalUIAndIceValueXL = Math.abs(totalUi[i] - iceValueXl[r]);
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

		public static void main(String[] args) throws InterruptedException, BiffException, IOException, WriteException {
			System.setProperty("webdriver.chrome.driver", "C:/Users/Mona Lisa/Downloads/chromedriver_win32/chromedriver.exe");
			 WebDriver driver = new ChromeDriver();
			String date = "2016 - 12";
			String country = "BAHAMAS";
			String channel = "ON PREMISE";
			ReadingDataFromxl storeAndIce;
			ReadingdatafromUI namesAndTotal;
			logIn(driver);
			selectDropDowns(driver,date, country, channel);
			namesAndTotal = readingDataFromUI(driver);
			storeAndIce = readingDataFromXL();
			/*comparingAndWritingData(storeAndIce.getRowsXL(),storeAndIce.getCounTryXL(), storeAndIce.getDaTeXL(),namesAndTotal.namesUI,storeAndIce.getChaNnelXL(),
				storeAndIce.getSubChanneLXL(),storeAndIce.getCooLerXL(),namesAndTotal.totalBeforeConvertingUI,storeAndIce.getStoreNameXL(), storeAndIce.getIceXL(), namesAndTotal.rowsCountUI, 
				namesAndTotal.totalUI, storeAndIce.getIcevaLueXL());
*/
		}





	

}
