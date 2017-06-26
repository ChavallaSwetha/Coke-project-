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
import jxl.write.biff.RowsExceededException;


public class trialClass {
	
	
	public void compareCountryLevelCoolerData(WebDriver driver, String readFilePath,String country,String channel,String piD, String writeFilePath) throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException{
		Thread.sleep(8000);
		
	String total = driver.findElement(By.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[1]/div[5]/div/div[1]/span")).getText();
	                 float iceTotal = Float.parseFloat(total);
	/*WebElement kpiTable = driver
			.findElement(By.xpath(".//*[@id='dashboard-container']/div[1]/div[4]/div[1]/div[2]/div/table/tbody"));
	List<WebElement> rowsInTable = kpiTable.findElements(By.tagName("tr"));
	int rowsCountUI = rowsInTable.size();
	System.out.println(rowsCountUI);
	List<WebElement> columns = rowsInTable.get(1).findElements(By.tagName("td"));*/
	String mPA = driver.findElement(By.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
	float mpaUI = Float.parseFloat(mPA);
	System.out.println(mpaUI); 
	
	/*String soVI = columns.get(2).getText();
	float sOVIf = Float.parseFloat(soVI);
	String refrigiration = columns.get(3).getText();
	float rEF = Float.parseFloat(refrigiration);
	String communion = columns.get(4).getText();
	float coMMEX = Float.parseFloat(communion);
	String price = columns.get(5).getText();
	float prICE = Float.parseFloat(price);
	String freshNEss = columns.get(6).getText();
	float freshNess = Float.parseFloat(freshNEss);*/
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
	String cooler ="1";
	//String[] xlDaTa = new String[6];
	String[] countryXL = new String[rowsXL];
	String[] channelXL = new String[rowsXL];
	String[] dateXL = new String[rowsXL];
	String[] kpiXL = new String[rowsXL];
	String[] piDXL = new String[rowsXL];
	String[] iceXL = new String[rowsXL];
	for (int rwXL =0; rwXL<rowsXL;rwXL++){
	
	Cell countryFromXL = sh.getCell(1, rwXL);
	 countryXL[rwXL] = countryFromXL.getContents();
	 Cell dateFromXL = sh.getCell(6, rwXL);
	 dateXL[rwXL] = dateFromXL.getContents();
	 Cell channelFromXL = sh.getCell(5, rwXL);
	 channelXL[rwXL] = channelFromXL.getContents();
	 Cell kpiFromXL = sh.getCell(10, rwXL);
	 kpiXL[rwXL] = kpiFromXL.getContents();
	 Cell iceFromXL = sh.getCell(11, rwXL);
	 iceXL[rwXL] = iceFromXL.getContents();
	 Cell pidFromXL = sh.getCell(9, rwXL);
	 piDXL[rwXL] = pidFromXL.getContents();
	}
	
	FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
	WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
	WritableSheet writeSheet = writeWorkBook.createSheet(country,0);
	Label countryHeading = new Label(0, 0, "COUNTRY");
	writeSheet.addCell(countryHeading);
	Label dateHeading = new Label(1, 0, "DATE");
	writeSheet.addCell(dateHeading);
	Label channelHeading = new Label(2, 0, "CHANNEL");
	writeSheet.addCell(channelHeading);
	Label kpiHeading = new Label(3, 0, "KPIs");
	writeSheet.addCell(kpiHeading);
	Label iceHeading = new Label(4, 0, "ICE_XL");
	writeSheet.addCell(iceHeading);
	Label iceinUI = new Label(5, 0, "ICE_UI");
	writeSheet.addCell(iceinUI);
	Label resultHeading = new Label(6, 0, "RESULT");
	writeSheet.addCell(resultHeading);
	for (int r=0; r<rowsXL; r++){
		for (int wr=1; wr<rowsXL; wr++){
		if (country.equals(countryXL[r])){
			if (channel.equals(channelXL[r])){
				if( piDXL[r].equals(cooler)){
					if (kpiXL[r].equals(mpa)){
					String kpi = kpiXL[r]; 
					String icEXL =  iceXL[r];
					Label counTry = new Label(0,wr,country);
					writeSheet.addCell(counTry);
					Label daTe = new Label(1,wr,dateXL[r]);
					writeSheet.addCell(daTe);
					Label chaNNel = new Label(2,wr,channel);
					writeSheet.addCell(chaNNel);					
					Label iCEXL = new Label(4,wr,icEXL);
					writeSheet.addCell(iCEXL);
					Label kpI = new Label(3,wr,kpi);
					writeSheet.addCell(kpI);
					}
				}
				}
			}
		}
	}
	writeWorkBook.write();
	writeWorkBook.close();
	}
}
