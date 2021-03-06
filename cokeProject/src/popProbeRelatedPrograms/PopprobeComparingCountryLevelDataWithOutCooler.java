package popProbeRelatedPrograms;

import java.io.File;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PopprobeComparingCountryLevelDataWithOutCooler {

	//public static void main(String[] args) throws IOException, WriteException, BiffException, InterruptedException {
		//WebDriver driver = new FirefoxDriver();
		/*PopprobeLogin login = new PopprobeLogin();
		Thread.sleep(9000);
		login.logIn(driver);
		String date = "2016 - 12";
		String country = "BAHAMAS";
		String channel = "HOME MARKET TRADITIONAL";
		Thread.sleep(9000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[1]/div/button")).click(); // Date
		// dropdown
		Thread.sleep(3000);
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
		Thread.sleep(3000);*/
		public void comparingCountryLevelDataWithOutCooler(WebDriver driver,String readFilePath,String writeFilePath) throws InterruptedException, BiffException, IOException, RowsExceededException, WriteException{
	    Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[1]/div[6]/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("NO")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
		// button
		Thread.sleep(4000);
		String total = driver
				.findElement(By.xpath(".//*[@id='dashboard-container']/div[1]/div[4]/div[1]/div[1]/div[1]/div/div[1]"))
				.getText();
		Float totalFt = Float.parseFloat(total);
		WebElement kpiTable = driver
				.findElement(By.xpath(".//*[@id='dashboard-container']/div[1]/div[4]/div[1]/div[2]/div/table/tbody"));
		List<WebElement> rows = kpiTable.findElements(By.tagName("tr"));
		rows.size();
		List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));
		String mpaSt = columns.get(1).getText();
		Float mpaFt = Float.parseFloat(mpaSt);
		String soviSt = columns.get(2).getText();
		Float soviFt = Float.parseFloat(soviSt);
		String refSt = columns.get(3).getText();
		Float refFt = Float.parseFloat(refSt);
		String commexSt = columns.get(4).getText();
		Float commexFt = Float.parseFloat(commexSt);
		String priceSt = columns.get(5).getText();
		Float priceFt = Float.parseFloat(priceSt);
		File readFile = new File(readFilePath);
		Workbook wb = Workbook.getWorkbook(readFile);
		Sheet sh = wb.getSheet(0);
		int rowsXL = sh.getRows();
		String mpa = "Portafolio Prioritario";
		String sovi = "SOVI";
		String refregiratio = "Refrigeraci�n";
		String commuNion = "Comunicaci�n y exhibici�n";
		String priCe = "Respeto a Precio";
		String toTal = "ICE sin Nevera Tradicional";
		String withOutCooler = "3";
		String[] countryXL = new String[rowsXL];
		String[] channelXL = new String[rowsXL];
		String[] dateXL = new String[rowsXL];
		String[] kpiXL = new String[rowsXL];
		String[] iceXL = new String[rowsXL];
		
		for (int countryrow=1;countryrow<rowsXL; countryrow++){
			Cell countryClmn = sh.getCell(0, countryrow);
			countryXL[countryrow] = countryClmn.getContents();
			for (int channelRow=1; channelRow<rowsXL; channelRow++){
				Cell channelClmn = sh.getCell(1, channelRow);
				channelXL[channelRow]= channelClmn.getContents();
				for (int dateRow=1;dateRow<rowsXL;dateRow++){
					Cell dateClmn = sh.getCell(2, dateRow);
					dateXL[dateRow] = dateClmn.getContents();
						for (int iceRow =1;iceRow<rowsXL;iceRow++){
							Cell iceClmn = sh.getCell(6,iceRow);
							iceXL[iceRow] = iceClmn.getContents();
						
					}
				}
			}
		}
		Label result = null;
      File writeFile = new File(writeFilePath);
      Workbook wrkBook = Workbook.getWorkbook(writeFile);
	  WritableWorkbook wwbook = Workbook.createWorkbook(writeFile, wrkBook);
      WritableSheet writeSh =  wwbook.getSheet(0);
      for (int kpiRow=0;kpiRow<rowsXL;kpiRow++){
			Cell kpiClmn = sh.getCell(5, kpiRow);
			kpiXL[kpiRow] =kpiClmn.getContents();
      }
	for (int i = 0; i < rowsXL; i++) {
		for (int r = 0; r < rowsXL; r++) {
			if ((kpiXL[r]).equals(mpa)) {
				Label kpiAdd = new Label(3, 14, kpiXL[r]);
				writeSh.addCell(kpiAdd);
				Cell pid = sh.getCell(4, r);
				String pID = pid.getContents();
				if (pID.equals(withOutCooler)) {
					Cell iCE = sh.getCell(6, r);
					String icevalue = iCE.getContents();
					Label iceAdd = new Label(4, 14, icevalue);
					writeSh.addCell(iceAdd);
					String icereplacewithf = icevalue.replaceAll("%", "f");
					float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
					Label countryAdd = new Label(0, 14, countryXL[r]);
					writeSh.addCell(countryAdd);
					Label dateAdd = new Label(1, 14, dateXL[r]);
					writeSh.addCell(dateAdd);
					Label channelAdd = new Label(2, 14, channelXL[r]);
					writeSh.addCell(channelAdd);
					Label mpaAdd = new Label(5, 14, mpaSt);
					writeSh.addCell(mpaAdd);
					System.out.println("UI MPA" + "          " + mpaFt);
					System.out.println("XL MPA" + "          " + afterconvertingtofloat);
					float difference = Math.abs(afterconvertingtofloat - mpaFt);
					if (difference >= 0.5) {
						result = new Label(6,14,"Mismatch");
					} 
					else {
						result = new Label(6,14,"Match");
					}
				
				writeSh.addCell(result);
				}
			} else if ((kpiXL[r]).equals(sovi)) {
				Label kpiAdd = new Label(3, 15, kpiXL[r]);
				writeSh.addCell(kpiAdd);
				Cell pid = sh.getCell(4, r);
				String pID = pid.getContents();
				if (pID.equals(withOutCooler)) {
					Cell iCE = sh.getCell(6, r);
					String icevalue = iCE.getContents();
					Label iceAdd = new Label(4, 15, icevalue);
					writeSh.addCell(iceAdd);
					String icereplacewithf = icevalue.replaceAll("%", "f");
					float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
					Label countryAdd = new Label(0, 15, countryXL[r]);
					writeSh.addCell(countryAdd);
					Label dateAdd = new Label(1, 15, dateXL[r]);
					writeSh.addCell(dateAdd);
					Label channelAdd = new Label(2, 15, channelXL[r]);
					writeSh.addCell(channelAdd);
					Label soviAdd = new Label(5, 15, soviSt);
					writeSh.addCell(soviAdd);
					System.out.println("UI SOVI" + "          " + soviFt);
					System.out.println("XL SOVI" + "          " + afterconvertingtofloat);
					float difference = Math.abs(afterconvertingtofloat - soviFt);
					if (difference >= 0.5) {
						result = new Label(6,15,"Mismatch");
					} 
					else {
						result = new Label(6,15,"Match");
					}
				
				writeSh.addCell(result);
				}
			} else if ((kpiXL[r]).equals(refregiratio)) {
				Label kpiAdd = new Label(3,16, kpiXL[r]);
				writeSh.addCell(kpiAdd);
				Cell pid1 = sh.getCell(4, r);
				String pID1 = pid1.getContents();
				if (pID1.equals(withOutCooler)) {
					Cell iCE = sh.getCell(6, r);
					String icevalue = iCE.getContents();
					Label iceAdd = new Label(4,16, icevalue);
					writeSh.addCell(iceAdd);
					String icereplacewithf = icevalue.replaceAll("%", "f");
					float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
					Label countryAdd = new Label(0,16, countryXL[r]);
					writeSh.addCell(countryAdd);
					Label dateAdd = new Label(1,16, dateXL[r]);
					writeSh.addCell(dateAdd);
					Label channelAdd = new Label(2, 16, channelXL[r]);
					writeSh.addCell(channelAdd);
					Label refAdd = new Label(5,16, refSt);
					writeSh.addCell(refAdd);
					System.out.println("UI refregeratio" + "          " + refFt);
					System.out.println("XL refregeratio" + "          " + afterconvertingtofloat);
					float difference = Math.abs(afterconvertingtofloat - refFt);
					if (difference >= 0.5) {
						result = new Label(6,16,"Mismatch");
					} 
					else {
						result = new Label(6,16,"Match");
					}
				
				writeSh.addCell(result);
				}
			} else if ((kpiXL[r]).equals(commuNion)) {
				Label kpiAdd = new Label(3,17, kpiXL[r]);
				writeSh.addCell(kpiAdd);
				Cell pid1 = sh.getCell(4, r);
				String pID1 = pid1.getContents();
				if (pID1.equals(withOutCooler)) {
					Cell iCE = sh.getCell(6, r);
					String icevalue = iCE.getContents();
					Label iceAdd = new Label(4, 17, icevalue);
					writeSh.addCell(iceAdd);
					String icereplacewithf = icevalue.replaceAll("%", "f");
					float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
					Label countryAdd = new Label(0, 17, countryXL[r]);
					writeSh.addCell(countryAdd);
					Label dateAdd = new Label(1, 17, dateXL[r]);
					writeSh.addCell(dateAdd);
					Label channelAdd = new Label(2, 17, channelXL[r]);
					writeSh.addCell(channelAdd);
					Label communionAdd = new Label(5, 17, commexSt);
					writeSh.addCell(communionAdd);
					System.out.println("UI CommunionYEX" + "          " + commexFt);
					System.out.println("XL CommunionYEX" + "          " + afterconvertingtofloat);
					float difference = Math.abs(afterconvertingtofloat - commexFt);
					if (difference >= 0.5) {
						result = new Label(6,17,"Mismatch");
					} 
					else {
						result = new Label(6,17,"Match");
					}
				
				writeSh.addCell(result);
				}
			} else if ((kpiXL[r]).equals(priCe)) {
				Label kpiAdd = new Label(3, 18, kpiXL[r]);
				writeSh.addCell(kpiAdd);
				Cell pid1 = sh.getCell(4, r);
				String pID1 = pid1.getContents();
				if (pID1.equals(withOutCooler)) {
					Cell iCE = sh.getCell(6, r);
					String icevalue = iCE.getContents();
					String icereplacewithf = icevalue.replaceAll("%", "f");
					Label iceAdd = new Label(4,18, icevalue);
					writeSh.addCell(iceAdd);
					float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
					Label countryAdd = new Label(0,18, countryXL[r]);
					writeSh.addCell(countryAdd);
					Label dateAdd = new Label(1, 18, dateXL[r]);
					writeSh.addCell(dateAdd);
					Label channelAdd = new Label(2, 18, channelXL[r]);
					writeSh.addCell(channelAdd);
					Label priceAdd = new Label(5, 18, priceSt);
					writeSh.addCell(priceAdd);
					System.out.println("UI PRICE" + "          " + priceFt);
					System.out.println("XL PRICE" + "          " + afterconvertingtofloat);
					float difference = Math.abs(afterconvertingtofloat - priceFt);
					if (difference >= 0.5) {
						result = new Label(6,18,"Mismatch");
					} 
					else {
						result = new Label(6,18,"Match");
					}
				
				writeSh.addCell(result);
			}
			
			}
			else if ((kpiXL[r]).equals(toTal)) {
				Label kpiAdd = new Label(3, 19, kpiXL[r]);
				writeSh.addCell(kpiAdd);
				Cell iCE = sh.getCell(6, r);
				String icevalue = iCE.getContents();
				String icereplacewithf = icevalue.replaceAll("%", "f");
				Label iceAdd = new Label(4, 19, icevalue);
				writeSh.addCell(iceAdd);
				float afterconvertingtofloat = Float.parseFloat(icereplacewithf);
				Label countryAdd = new Label(0,19, countryXL[r]);
				writeSh.addCell(countryAdd);
				Label dateAdd = new Label(1, 19, dateXL[r]);
				writeSh.addCell(dateAdd);
				Label channelAdd = new Label(2, 19, channelXL[r]);
				writeSh.addCell(channelAdd);
				Label totalAdd = new Label(5,19, total);
				writeSh.addCell(totalAdd);
				System.out.println("UI FRESHNESS" + "          " + totalFt);
				System.out.println("XL FRESHNESS" + "          " + afterconvertingtofloat);
				float difference = Math.abs(totalFt - afterconvertingtofloat);
				if (difference >= 0.5) {
					result = new Label(6,19,"Mismatch");
				} 
				else {
					result = new Label(6,19,"Match");
				}
			
			writeSh.addCell(result);
			}
	}
	}
	wwbook.write();
	wwbook.close();
    System.out.println("Comparing country level data with out cooler");

}
		
}


