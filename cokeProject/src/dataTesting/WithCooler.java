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
			String piD, String writeFilePath,UICountryLevelData kpiData2)
			throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException {
		Thread.sleep(8000);
           
             
             

             
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
     		String toTal = "ICE con Nevera Tradicional";
     		String withCooler = "2";
     		String cooler1 = "0";
     		

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
     			Label result;
     			if (country.equals(countryXL[r])) {
     				if (channel.equals(channelXL[r])) {
     					if (piDXL[r].equals(withCooler)) {
     						String pID = piDXL[r];
     						System.out.println("MPA from UI"+"   "+kpiData2.getMPA());
     						
     						if (kpiXL[r].equals(mpa)) {
     							System.out.println("swetha");
     							String kpi = kpiXL[r];
     							String icEXL = iceXL[r];
     							String iCE = icEXL.replace('%', 'f');
     							float xlIce = Float.parseFloat(iCE);
     							Label counTry = new Label(0, 8, country);
     							writeSheet.addCell(counTry);
     							String dateFromXL = dateXL[r];
     							Label daTe = new Label(1, 8, dateFromXL);
     							writeSheet.addCell(daTe);
     							Label chaNNel = new Label(2, 8, channel);
     							writeSheet.addCell(chaNNel);
     							Label piDfromXL = new Label(4, 8, pID);
     							writeSheet.addCell(piDfromXL);
     							Label iCEXL = new Label(5, 8, icEXL);
     							writeSheet.addCell(iCEXL);
     							Label kpI = new Label(3, 8, kpi);
     							writeSheet.addCell(kpI);
     							Label mpaFromUI = new Label(6, 8, String.valueOf(kpiData2.getMPA()));
     							writeSheet.addCell(mpaFromUI);
     							
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData2.getMPA());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 8, "Mismatch");

     							} else {
     								result = new Label(7, 8, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(sovi)) {
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
     							Label mpaFromUI = new Label(6, 9, String.valueOf(kpiData2.getSOVI()));
     							writeSheet.addCell(mpaFromUI);
     							
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData2.getSOVI());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 9, "Mismatch");

     							} else {
     								result = new Label(7, 9, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(refregiratio)) {
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
     							Label mpaFromUI = new Label(6, 10, String.valueOf(kpiData2.getREF()));
     							writeSheet.addCell(mpaFromUI);
     							
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData2.getREF());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 10, "Mismatch");

     							} else {
     								result = new Label(7, 10, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(commuNion)) {
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
     							Label mpaFromUI = new Label(6, 11, String.valueOf(kpiData2.getCOMM()));
     							writeSheet.addCell(mpaFromUI);
     							
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData2.getCOMM());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 11, "Mismatch");

     							} else {
     								result = new Label(7, 11, "Match");

     							}
     							writeSheet.addCell(result);
     						} else if (kpiXL[r].equals(priCe)) {
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
     							Label mpaFromUI = new Label(6, 12, String.valueOf(kpiData2.getPRICE()));
     							writeSheet.addCell(mpaFromUI);
     							
     							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData2.getPRICE());
     							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     								result = new Label(7, 12, "Mismatch");

     							} else {
     								result = new Label(7, 12, "Match");

     							}
     							writeSheet.addCell(result);
     						} 
     					}
     					if (piDXL[r].equals(cooler1)) {
							String pID1 = piDXL[r];
     						 if (kpiXL[r].equals(toTal)) {
    							
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
    							Label piDfromXL = new Label(4, 13, pID1);
    							writeSheet.addCell(piDfromXL);
    							Label iCEXL = new Label(5, 13, icEXL);
    							writeSheet.addCell(iCEXL);
    							Label kpI = new Label(3, 13, kpi);
    							writeSheet.addCell(kpI);
    							Label mpaFromUI = new Label(6, 13, String.valueOf(kpiData2.getTOTAL()));
    							writeSheet.addCell(mpaFromUI);
    							
    							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData2.getTOTAL());
    							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
    								result = new Label(7, 13, "Mismatch");

    							} else {
    								result = new Label(7, 13, "Match");

    							}
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
