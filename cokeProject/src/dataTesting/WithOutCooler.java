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

public class WithOutCooler {

	public void compareCountryLevelCoolerData(WebDriver driver, String readFilePath, String country, String channel,
			String piD, String writeFilePath,UICountryLevelData kpiData)
			throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException {
		Thread.sleep(8000);
             ReadingCountryLevelDataFromUI uiData = new  ReadingCountryLevelDataFromUI();
             
             driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div[1]/div[1]/div[7]/div/button")).click();
      		Thread.sleep(4000);
      		 driver.findElement(By.xpath(".//*[@id='filter-view']/section/div/div/div[1]/div[1]/div[7]/div/button")).click();
      		Thread.sleep(4000);
      		 driver.findElement(By.linkText("NO")).click();
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
     		String WithOutCooler = "3";
     		

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
     					if (piDXL[r].equals(WithOutCooler)) {
     						String pID = piDXL[r];
     						System.out.println("MPA from UI"+"   "+kpiData.getMPA());
     						if (kpiXL[r].equals(mpa)) {
     							System.out.println("swetha");
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 13, country);
     							writeSheet.addCell(counTry);
     							String dateFromXL = dateXL[r];
     							Label daTe = new Label(1, 13, dateFromXL);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 13, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 13, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 13, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 13, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 13, String.valueOf(kpiData.getMPA()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getMPA());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 13, "Mismatch");

     							} else {
     								result = new Label(7, 13, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(sovi)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 14, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 14, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 14, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 14, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 14, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 14, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 14, String.valueOf(kpiData.getSOVI()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getSOVI());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 14, "Mismatch");

     							} else {
     								result = new Label(7, 14, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(refregiratio)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 15, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 15, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 15, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 15, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 15, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 15, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 15, String.valueOf(kpiData.getREF()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getREF());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 15, "Mismatch");

     							} else {
     								result = new Label(7, 15, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(commuNion)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 16, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 16, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 16, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 16, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 16, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 16, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 16, String.valueOf(kpiData.getCOMM()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getCOMM());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 16, "Mismatch");

     							} else {
     								result = new Label(7, 16, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(priCe)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 17, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 17, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 17, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 17, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 17, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 17, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 17, String.valueOf(kpiData.getPRICE()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getPRICE());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 17, "Mismatch");

     							} else {
     								result = new Label(7, 17, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(freshNESs)) {
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 18, country);
     							writeSheet.addCell(counTry);
     							Label daTe = new Label(1, 18, dateXL[r]);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 18, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 18, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 18, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 18, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 18, String.valueOf(kpiData.getFRESH()));
     							writeSheet.addCell(mpaFromUI);
     							Label result;
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData.getFRESH());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 18, "Mismatch");

     							} else {
     								result = new Label(7, 18, "Match");

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