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

public class WithAndWithOutCooler {

	public void compareCountryLevelCoolerData(WebDriver driver, String readFilePath, String country, String channel,
			String piD, String writeFilePath,UICountryLevelData kpiData1)
			throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException {
		Thread.sleep(8000);
             
            
		/*
		 * WebElement kpiTable = driver .findElement(By.xpath(
		 * ".//*[@id='dashboard-container']/div[1]/div[4]/div[1]/div[2]/div/table/tbody"
		 * )); List<WebElement> rowsInTable =
		 * kpiTable.findElements(By.tagName("tr")); int rowsCountUI =
		 * rowsInTable.size(); System.out.println(rowsCountUI); List<WebElement>
		 * columns = rowsInTable.get(1).findElements(By.tagName("td"));
		 */
		
	
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
		String cooler1 = "0";
		

		String[] countryXL = new String[rowsXL];
		String[] channelXL = new String[rowsXL];
		String[] dateXL = new String[rowsXL];
		String[] kpiXL = new String[rowsXL];
		String[] piDXL = new String[rowsXL];
		String[] iceXL = new String[rowsXL];
		
		for (int rwXL = 0; rwXL < rowsXL; rwXL++) {
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
		WritableSheet writeSheet = writeWorkBook.createSheet(country, 0);
		Label countryHeading = new Label(0, 0, "COUNTRY");
		writeSheet.addCell(countryHeading);
		Label dateHeading = new Label(1, 0, "DATE");
		writeSheet.addCell(dateHeading);
		Label channelHeading = new Label(2, 0, "CHANNEL");
		writeSheet.addCell(channelHeading);
		Label kpiHeading = new Label(3, 0, "KPIs");
		writeSheet.addCell(kpiHeading);
		Label pidHeading = new Label(4, 0, "PID_CRITERIA");
		writeSheet.addCell(pidHeading);
		Label iceHeading = new Label(5, 0, "ICE_XL");
		writeSheet.addCell(iceHeading);
		Label iceinUI = new Label(6, 0, "ICE_UI");
		writeSheet.addCell(iceinUI);
		Label resultHeading = new Label(7, 0, "RESULT");
		writeSheet.addCell(resultHeading);
		for (int r = 0; r < rowsXL; r++) {
			int wr = 1;
			if (country.equals(countryXL[r])) {
				if (channel.equals(channelXL[r])) {
					if (piDXL[r].equals(cooler)) {
						String pID = piDXL[r];
						System.out.println("MPA from UI"+"   "+kpiData1.getMPA());
						if (kpiXL[r].equals(mpa)) {
							System.out.println("swetha");
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, wr, country);
							writeSheet.addCell(counTry);
							String dateFromXL = dateXL[r];
							Label daTe = new Label(1, wr, dateFromXL);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, wr, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, wr, pID);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, wr, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, wr, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, wr, String.valueOf(kpiData1.getMPA()));
							writeSheet.addCell(mpaFromUI);
							Label result;
							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData1.getMPA());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, wr, "Mismatch");

							} else {
								result = new Label(7, wr, "Match");

							}
							writeSheet.addCell(result);
						}  if (kpiXL[r].equals(sovi)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, 2, country);
							writeSheet.addCell(counTry);
							Label daTe = new Label(1, 2, dateXL[r]);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, 2, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, 2, pID);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, 2, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, 2, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, 2, String.valueOf(kpiData1.getSOVI()));
							writeSheet.addCell(mpaFromUI);
							Label result;
							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData1.getSOVI());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 2, "Mismatch");

							} else {
								result = new Label(7, 2, "Match");

							}
							writeSheet.addCell(result);
						}  if (kpiXL[r].equals(refregiratio)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, 3, country);
							writeSheet.addCell(counTry);
							Label daTe = new Label(1, 3, dateXL[r]);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, 3, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, 3, pID);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, 3, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, 3, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, 3, String.valueOf(kpiData1.getREF()));
							writeSheet.addCell(mpaFromUI);
							Label result;
							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData1.getREF());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 3, "Mismatch");

							} else {
								result = new Label(7, 3, "Match");

							}
							writeSheet.addCell(result);
						}  if (kpiXL[r].equals(commuNion)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, 4, country);
							writeSheet.addCell(counTry);
							Label daTe = new Label(1, 4, dateXL[r]);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, 4, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, 4, pID);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, 4, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, 4, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, 4, String.valueOf(kpiData1.getCOMM()));
							writeSheet.addCell(mpaFromUI);
							Label result;
							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData1.getCOMM());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 4, "Mismatch");

							} else {
								result = new Label(7, 4, "Match");

							}
							writeSheet.addCell(result);
						}  if (kpiXL[r].equals(priCe)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, 5, country);
							writeSheet.addCell(counTry);
							Label daTe = new Label(1, 5, dateXL[r]);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, 5, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, 5, pID);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, 5, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, 5, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, 5, String.valueOf(kpiData1.getPRICE()));
							writeSheet.addCell(mpaFromUI);
							Label result;
							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData1.getPRICE());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 5, "Mismatch");

							} else {
								result = new Label(7, 5, "Match");

							}
							writeSheet.addCell(result);
						}  if (kpiXL[r].equals(freshNESs)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, 6, country);
							writeSheet.addCell(counTry);
							Label daTe = new Label(1, 6, dateXL[r]);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, 6, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, 6, pID);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, 6, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, 6, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, 6, String.valueOf(kpiData1.getFRESH()));
							writeSheet.addCell(mpaFromUI);
							Label result;
							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData1.getFRESH());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 6, "Mismatch");

							} else {
								result = new Label(7, 6, "Match");

							}
							writeSheet.addCell(result);
						}
					}
						if (piDXL[r].equals(cooler1)) {
							String pID1 = piDXL[r];
						 if(kpiXL[r].equals(toTal)) {
							System.out.println("swetha total");
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, 7, country);
							writeSheet.addCell(counTry);
							String dateFromXL = dateXL[r];
							Label daTe = new Label(1, 7, dateFromXL);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, 7, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, 7, pID1);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, 7, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, 7, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, 7, String.valueOf(kpiData1.getTOTAL()));
							writeSheet.addCell(mpaFromUI);
							Label result;
							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData1.getTOTAL());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 7, "Mismatch");

							} else {
								result = new Label(7, 7, "Match");

							}
							writeSheet.addCell(result);
						}
					}
					
				}
			}
		}

		writeWorkBook.write();
		writeWorkBook.close();	
		
	}
}