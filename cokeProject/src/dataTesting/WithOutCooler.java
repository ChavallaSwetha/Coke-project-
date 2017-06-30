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
			String piD, String writeFilePath, UICountryLevelData kpiData3)
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
		String toTal = "ICE sin Nevera Tradicional";
		String WithOutCooler = "3";
		String cooler1= "0";

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
		WritableSheet writeSheet = wwbook.getSheet(0);

		for (int r = 0; r < rowsXL; r++) {
			Label result;
			if (country.equals(countryXL[r])) {
				if (channel.equals(channelXL[r])) {
					if (piDXL[r].equals(WithOutCooler)) {
						String pID = piDXL[r];
						System.out.println("MPA from UI" + "   " + kpiData3.getMPA());
						
						if (kpiXL[r].equals(mpa)) {
							System.out.println("swetha");
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, 14, country);
							writeSheet.addCell(counTry);
							String dateFromXL = dateXL[r];
							Label daTe = new Label(1, 14, dateFromXL);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, 14, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, 14, pID);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, 14, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, 14, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, 14, String.valueOf(kpiData3.getMPA()));
							writeSheet.addCell(mpaFromUI);

							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData3.getMPA());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 14, "Mismatch");

							} else {
								result = new Label(7, 14, "Match");

							}
							writeSheet.addCell(result);
						} else if (kpiXL[r].equals(sovi)) {
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
							Label mpaFromUI = new Label(6, 15, String.valueOf(kpiData3.getSOVI()));
							writeSheet.addCell(mpaFromUI);

							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData3.getSOVI());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 15, "Mismatch");

							} else {
								result = new Label(7, 15, "Match");

							}
							writeSheet.addCell(result);
						} else if (kpiXL[r].equals(refregiratio)) {
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
							Label mpaFromUI = new Label(6, 16, String.valueOf(kpiData3.getREF()));
							writeSheet.addCell(mpaFromUI);

							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData3.getREF());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 16, "Mismatch");

							} else {
								result = new Label(7, 16, "Match");

							}
							writeSheet.addCell(result);
						} else if (kpiXL[r].equals(commuNion)) {
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
							Label mpaFromUI = new Label(6, 17, String.valueOf(kpiData3.getCOMM()));
							writeSheet.addCell(mpaFromUI);

							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData3.getCOMM());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 17, "Mismatch");

							} else {
								result = new Label(7, 17, "Match");

							}
							writeSheet.addCell(result);
						} else if (kpiXL[r].equals(priCe)) {
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
							Label mpaFromUI = new Label(6, 18, String.valueOf(kpiData3.getPRICE()));
							writeSheet.addCell(mpaFromUI);

							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData3.getPRICE());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 18, "Mismatch");

							} else {
								result = new Label(7, 18, "Match");

							}
							writeSheet.addCell(result);
						}
					}
					if (piDXL[r].equals(cooler1)) {
						String pID1 = piDXL[r];
						 if(kpiXL[r].equals(toTal)) {

							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							Label counTry = new Label(0, 19, country);
							writeSheet.addCell(counTry);
							String dateFromXL = dateXL[r];
							Label daTe = new Label(1, 19, dateFromXL);
							writeSheet.addCell(daTe);
							Label chaNNel = new Label(2, 19, channel);
							writeSheet.addCell(chaNNel);
							Label piDfromXL = new Label(4, 19, pID1);
							writeSheet.addCell(piDfromXL);
							Label iCEXL = new Label(5, 19, icEXL);
							writeSheet.addCell(iCEXL);
							Label kpI = new Label(3, 19, kpi);
							writeSheet.addCell(kpI);
							Label mpaFromUI = new Label(6, 19, String.valueOf(kpiData3.getTOTAL()));
							writeSheet.addCell(mpaFromUI);

							float diffBetweentotalUIICEAndIceValueXL = Math.abs(xlIce - kpiData3.getTOTAL());
							if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
								result = new Label(7, 19, "Mismatch");

							} else {
								result = new Label(7, 19, "Match");

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