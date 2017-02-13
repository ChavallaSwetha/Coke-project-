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
import jxl.write.biff.RowsExceededException;

public class PopprobeComparingCountryLevelDataWithAndWithOutCooler {

		
		
		float mpaUI = 0;
		float sOVIf = 0;
		float rEF = 0;
		float coMMEX = 0;
		float prICE = 0;
		float freshNess = 0;
		//String readFilePath = "C:/Users/Mona Lisa/Desktop/Datafor countrylevel testing.xls" ;
		//String writeFilePath = "C:/Users/Mona Lisa/Downloads/country data.xls"; 
		public void compareCountryLevelCoolerData(WebDriver driver, String readFilePath,String writeFilePath) throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException{
			Thread.sleep(8000);
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
		File readFile = new File(readFilePath);
		Workbook readWbk = Workbook.getWorkbook(readFile);
		Sheet sh = readWbk.getSheet(0);
		int rowsXL = sh.getRows();
		System.out.println("No. of rows in XL" + "         " + rowsXL);
		String mpa = "Portafolio Prioritario";
		String sovi = "SOVI";
		String refregiratio = "Refrigeración";
		String commuNion = "Comunicación y exhibición";
		String priCe = "Respeto a Precio";
		String freshNESs = "Frescura de Producto";
		String toTal = "ICE Total Tradicional";
		String cooler = "1";
		String[] countryXL = new String[rowsXL];
		String[] channelXL = new String[rowsXL];
		String[] dateXL = new String[rowsXL];
		String[] kpiXL = new String[rowsXL];
		String[] iceXL = new String[rowsXL];
		for (int xlRow = 0; xlRow < rowsXL; xlRow++) {
			for (int clmn = 0; clmn < 1; clmn++) {
				Cell countryData = sh.getCell(clmn, xlRow);
				countryXL[xlRow] = countryData.getContents();
				for (int chaclmn = 1; chaclmn < 2; chaclmn++) {
					Cell channelsData = sh.getCell(chaclmn, xlRow);
					channelXL[xlRow] = channelsData.getContents();
					for (int dateclmn = 2; dateclmn < 3; dateclmn++) {
						Cell datesData = sh.getCell(dateclmn, xlRow);
						dateXL[xlRow] = datesData.getContents();
						for (int iceclmn = 6; iceclmn < 7; iceclmn++) {
							Cell iceData = sh.getCell(iceclmn, xlRow);
							iceXL[xlRow] = iceData.getContents();
						}
					}
				}
			}
			String result = null;
			FileOutputStream writefile = new FileOutputStream(writeFilePath);
			WritableWorkbook wwbook = Workbook.createWorkbook(writefile);
			WritableSheet writeSh = wwbook.createSheet("COUNTRY", 0);
			Label countryHeading = new Label(0, 0, "COUNTRY");
			writeSh.addCell(countryHeading);
			Label dateHeading = new Label(1, 0, "DATE");
			writeSh.addCell(dateHeading);
			Label channelHeading = new Label(2, 0, "CHANNEL");
			writeSh.addCell(channelHeading);
			Label kpiHeading = new Label(3, 0, "KPIs");
			writeSh.addCell(kpiHeading);
			Label iceHeading = new Label(4, 0, "ICE_XL");
			writeSh.addCell(iceHeading);
			Label iceinUI = new Label(5, 0, "ICE_UI");
			writeSh.addCell(iceinUI);
			Label resultHeading = new Label(6, 0, "RESULT");
			writeSh.addCell(resultHeading);
			for (int r = 0; r < rowsXL; r++) {
				Cell kpiData = sh.getCell(5, r);
				kpiXL[r] = kpiData.getContents();
			}
			for (int i = 0; i < rowsXL; i++) {
				for (int r = 0; r < rowsXL; r++) {
					if ((kpiXL[r]).equals(mpa)) {
						Label kpiAdd = new Label(3, 1, kpiXL[r]);
						writeSh.addCell(kpiAdd);
						Cell pid = sh.getCell(4, r);
						String pID = pid.getContents();
						if (pID.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							Label iceAdd = new Label(4, 1, icevalue);
							writeSh.addCell(iceAdd);
							String icereplacewithf = icevalue.replaceAll("%", "f");
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 1, countryXL[r]);
							writeSh.addCell(countryAdd);
							Label dateAdd = new Label(1, 1, dateXL[r]);
							writeSh.addCell(dateAdd);
							Label channelAdd = new Label(2, 1, channelXL[r]);
							writeSh.addCell(channelAdd);
							Label mpaAdd = new Label(5, 1, mPA);
							writeSh.addCell(mpaAdd);
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
						writeSh.addCell(resultAdd);

					} else if ((kpiXL[r]).equals(sovi)) {
						Label kpiAdd = new Label(3, 2, kpiXL[r]);
						writeSh.addCell(kpiAdd);
						Cell pid = sh.getCell(4, r);
						String pID = pid.getContents();
						if (pID.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							Label iceAdd = new Label(4, 2, icevalue);
							writeSh.addCell(iceAdd);
							String icereplacewithf = icevalue.replaceAll("%", "f");
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 2, countryXL[r]);
							writeSh.addCell(countryAdd);
							Label dateAdd = new Label(1, 2, dateXL[r]);
							writeSh.addCell(dateAdd);
							Label channelAdd = new Label(2, 2, channelXL[r]);
							writeSh.addCell(channelAdd);
							Label soviAdd = new Label(5, 2, soVI);
							writeSh.addCell(soviAdd);
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
						writeSh.addCell(resultAdd);

					} else if ((kpiXL[r]).equals(refregiratio)) {
						Label kpiAdd = new Label(3, 3, kpiXL[r]);
						writeSh.addCell(kpiAdd);
						Cell pid1 = sh.getCell(4, r);
						String pID1 = pid1.getContents();
						if (pID1.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							Label iceAdd = new Label(4, 3, icevalue);
							writeSh.addCell(iceAdd);
							String icereplacewithf = icevalue.replaceAll("%", "f");
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 3, countryXL[r]);
							writeSh.addCell(countryAdd);
							Label dateAdd = new Label(1, 3, dateXL[r]);
							writeSh.addCell(dateAdd);
							Label channelAdd = new Label(2, 3, channelXL[r]);
							writeSh.addCell(channelAdd);
							Label refAdd = new Label(5, 3, refrigiration);
							writeSh.addCell(refAdd);
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
						writeSh.addCell(resultAdd);

					} else if ((kpiXL[r]).equals(commuNion)) {
						Label kpiAdd = new Label(3, 4, kpiXL[r]);
						writeSh.addCell(kpiAdd);
						Cell pid1 = sh.getCell(4, r);
						String pID1 = pid1.getContents();
						if (pID1.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							Label iceAdd = new Label(4, 4, icevalue);
							writeSh.addCell(iceAdd);
							String icereplacewithf = icevalue.replaceAll("%", "f");
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 4, countryXL[r]);
							writeSh.addCell(countryAdd);
							Label dateAdd = new Label(1, 4, dateXL[r]);
							writeSh.addCell(dateAdd);
							Label channelAdd = new Label(2, 4, channelXL[r]);
							writeSh.addCell(channelAdd);
							Label communionAdd = new Label(5, 4, communion);
							writeSh.addCell(communionAdd);
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
						writeSh.addCell(resultAdd);

					} else if ((kpiXL[r]).equals(priCe)) {
						Label kpiAdd = new Label(3, 5, kpiXL[r]);
						writeSh.addCell(kpiAdd);
						Cell pid1 = sh.getCell(4, r);
						String pID1 = pid1.getContents();
						if (pID1.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							String icereplacewithf = icevalue.replaceAll("%", "f");
							Label iceAdd = new Label(4, 5, icevalue);
							writeSh.addCell(iceAdd);
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 5, countryXL[r]);
							writeSh.addCell(countryAdd);
							Label dateAdd = new Label(1, 5, dateXL[r]);
							writeSh.addCell(dateAdd);
							Label channelAdd = new Label(2, 5, channelXL[r]);
							writeSh.addCell(channelAdd);
							Label priceAdd = new Label(5, 5, price);
							writeSh.addCell(priceAdd);
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
						writeSh.addCell(resultAdd);

					} else if ((kpiXL[r]).equals(freshNESs)) {
						Label kpiAdd = new Label(3, 6, kpiXL[r]);
						writeSh.addCell(kpiAdd);
						Cell pid1 = sh.getCell(4, r);
						String pID1 = pid1.getContents();
						if (pID1.equals(cooler)) {
							Cell iCE = sh.getCell(6, r);
							String icevalue = iCE.getContents();
							String icereplacewithf = icevalue.replaceAll("%", "f");
							Label iceAdd = new Label(4, 6, icevalue);
							writeSh.addCell(iceAdd);
							float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
							Label countryAdd = new Label(0, 6, countryXL[r]);
							writeSh.addCell(countryAdd);
							Label dateAdd = new Label(1, 6, dateXL[r]);
							writeSh.addCell(dateAdd);
							Label channelAdd = new Label(2, 6, channelXL[r]);
							writeSh.addCell(channelAdd);
							Label freshnessAdd = new Label(5, 6, freshNEss);
							writeSh.addCell(freshnessAdd);
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
						writeSh.addCell(resultAdd);
					}

					else if ((kpiXL[r]).equals(toTal)) {
						Label kpiAdd = new Label(3, 6, kpiXL[r]);
						writeSh.addCell(kpiAdd);
						Cell iCE = sh.getCell(6, r);
						String icevalue = iCE.getContents();
						String icereplacewithf = icevalue.replaceAll("%", "f");
						Label iceAdd = new Label(4, 6, icevalue);
						writeSh.addCell(iceAdd);
						float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
						Label countryAdd = new Label(0, 6, countryXL[r]);
						writeSh.addCell(countryAdd);
						Label dateAdd = new Label(1, 6, dateXL[r]);
						writeSh.addCell(dateAdd);
						Label channelAdd = new Label(2, 6, channelXL[r]);
						writeSh.addCell(channelAdd);
						Label totalAdd = new Label(5, 6, total);
						writeSh.addCell(totalAdd);
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
					writeSh.addCell(resultAdd);
				}
			}
			wwbook.write();
			wwbook.close();
	}
		}
}
