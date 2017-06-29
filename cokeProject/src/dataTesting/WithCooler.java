package dataTesting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WithCooler {
       
	public void compareCountryLevelCoolerData(WebDriver driver, String readFilePath, String country, String channel,
			String piD, String writeFilePath,UICountryLevelData kpiData)
			throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException {
		Thread.sleep(8000);
             ReadingCountryLevelDataFromUI uiData = new  ReadingCountryLevelDataFromUI();
             
             driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div[1]/div[1]/div[7]/div/button")).click();
     		Thread.sleep(4000);
     		driver.findElement(By.linkText("YES")).click();
     		Thread.sleep(4000);
     		driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div/div[2]/div/button")).click(); // Apply
     		// button
     		Thread.sleep(4000);

             
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
     		String withCooler = "2";
     		

     		String[] countryXL = new String[rowsXL];
     		String[] channelXL = new String[rowsXL];
     		String[] dateXL = new String[rowsXL];
     		String[] kpiXL = new String[rowsXL];
     		String[] piDXL = new String[rowsXL];
     		String[] iceXL = new String[rowsXL];
     		float[] xlICE = new float[rowsXL];
     		for (int rwXL = 0; rwXL < rowsXL; rwXL++) {
     			Cell countryFromXL = sh.getCell(1, rwXL);
     			countryXL[rwXL] = countryFromXL.getContents();
     			System.out.println(countryXL + " --> " + countryXL[rwXL]);
     			Cell dateFromXL = sh.getCell(6, rwXL);
     			dateXL[rwXL] = dateFromXL.getContents();
     			System.out.println(dateXL + " --> " + dateXL[rwXL]);
     			Cell channelFromXL = sh.getCell(5, rwXL);
     			channelXL[rwXL] = channelFromXL.getContents();
     			System.out.println(channelXL + " --> " + channelXL[rwXL]);
     			Cell kpiFromXL = sh.getCell(10, rwXL);
     			kpiXL[rwXL] = kpiFromXL.getContents();
     			System.out.println(kpiXL + " --> " + kpiXL[rwXL]);
     			Cell iceFromXL = sh.getCell(11, rwXL);
     			iceXL[rwXL] = iceFromXL.getContents();
     			System.out.println(iceXL + "  --> " + xlICE[rwXL]);
     			Cell pidFromXL = sh.getCell(9, rwXL);
     			piDXL[rwXL] = pidFromXL.getContents();
     			System.out.println(piDXL + " --> " + piDXL[rwXL]);
     		}
           
     		
     		
     		 File writeFile = new File(writeFilePath);
     	      Workbook wrkBook = Workbook.getWorkbook(writeFile);
     		  WritableWorkbook wwbook = Workbook.createWorkbook(writeFile, wrkBook);
     	      WritableSheet writeSheet =  wwbook.getSheet(0);
     		
     		for (int r = 0; r < rowsXL; r++) {
     			
     			if (country.equals(countryXL[r])) {
     				if (channel.equals(channelXL[r])) {
     					if (piDXL[r].equals(withCooler)) {
     						String pID = piDXL[r];
     						System.out.println("MPA from UI"+"   "+kpiData.getMPA());
     						if (kpiXL[r].equals(mpa)) {
     							System.out.println("swetha");
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
     							Label piDfromXL = new Label(4, 7, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 7, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 7, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 7, String.valueOf(kpiData.getMPA()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getMPA());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 7, "Mismatch");

     							} else {
     								result = new Label(7, 7, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(sovi)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 8, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 8, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 8, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 8, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 8, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 8, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 8, String.valueOf(kpiData.getSOVI()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getSOVI());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 8, "Mismatch");

     							} else {
     								result = new Label(7, 8, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(refregiratio)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 9, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 9, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 9, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 9, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 9, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 9, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 9, String.valueOf(kpiData.getREF()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getREF());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 9, "Mismatch");

     							} else {
     								result = new Label(7, 9, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(commuNion)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 10, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 10, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 10, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 10, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 10, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 10, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 10, String.valueOf(kpiData.getCOMM()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getCOMM());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 10, "Mismatch");

     							} else {
     								result = new Label(7, 10, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(priCe)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 11, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 11, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 11, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 11, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 11, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 11, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 11, String.valueOf(kpiData.getPRICE()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getPRICE());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 11, "Mismatch");

     							} else {
     								result = new Label(7, 11, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(freshNESs)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 12, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 12, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 12, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 12, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 12, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 12, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 12, String.valueOf(kpiData.getFRESH()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getFRESH());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 12, "Mismatch");

     							} else {
     								result = new Label(7, 12, "Match");

     							}
     							writeSheet.addCell(result);
     						}
     						else {
     							Label result = new Label(7, 12, "No Data");
     							writeSheet.addCell(result);
     						}
     					}
     				}
     			}
     		}

     		wwbook.write();
     		wwbook.close();
}
}