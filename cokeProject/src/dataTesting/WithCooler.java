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

	public void compareCountryLevelCoolerData(WritableSheet writeSheet, String readFilePath, String date, 
			 int i,UIAndXLCountryLevelData uiData2,UIAndXLCountryLevelData xldata)
			throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException {
		Thread.sleep(8000);
           
      	
     	     Label counTry = new Label(0, 8, xldata.getCOUNTRY());
     		writeSheet.addCell(counTry);
     		Label daTe = new Label(1, 8, date);
     		writeSheet.addCell(daTe);
     		Label chaNNel = new Label(2, 8, xldata.getCHANNEL());
     		writeSheet.addCell(chaNNel);
     		Label piDfromXL = new Label(4, 8, xldata.getPID());
     		writeSheet.addCell(piDfromXL);
     		Label iCEXL = new Label(5, 8, String.valueOf(xldata.getMPA()));
     		writeSheet.addCell(iCEXL);
     		Label kpI = new Label(3, 8, xldata.getKPImpa());
     		writeSheet.addCell(kpI);
     		Label mpaFromUI = new Label(6, 8, String.valueOf(uiData2.getMPA()));
     		writeSheet.addCell(mpaFromUI);
     		Label result;
     		float diffBetweentotalUIICEAndIceValueXL = Math.abs(xldata.getMPA() - uiData2.getMPA());
     		if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
     		result = new Label(7, 8, "Mismatch");
     		} else {
     			result = new Label(7, 8, "Match");
     		}
     		writeSheet.addCell(result);
     		Label counTry2 = new Label(0, 9, xldata.getCOUNTRY());
     		writeSheet.addCell(counTry2);
     		Label daTe2 = new Label(1, 9, date);
     		writeSheet.addCell(daTe2);
     		Label chaNNel2 = new Label(2, 9, xldata.getCHANNEL());
     		writeSheet.addCell(chaNNel2);
     		Label piDfromXL2 = new Label(4, 9, xldata.getPID());
     		writeSheet.addCell(piDfromXL2);
     		Label iCEXL2 = new Label(5, 9, String.valueOf(xldata.getSOVI()));
     		writeSheet.addCell(iCEXL2);
     		Label kpI2 = new Label(3, 9, xldata.getKPIsovi());
     		writeSheet.addCell(kpI2);
     		Label mpaFromUI2 = new Label(6, 9, String.valueOf(uiData2.getSOVI()));
     		writeSheet.addCell(mpaFromUI2);
     		float diffBetweentotalUIICEAndIceValueXL2 = Math.abs(xldata.getSOVI() - uiData2.getSOVI());
     		if (diffBetweentotalUIICEAndIceValueXL2 >= 0.5) {
     			result = new Label(7, 9, "Mismatch");
     		} else {
     			result = new Label(7, 9, "Match");
     		}
     		writeSheet.addCell(result);
     		Label counTry3 = new Label(0, 10, xldata.getCOUNTRY());
     		writeSheet.addCell(counTry3);
     		Label daTe3 = new Label(1, 10, date);
     		writeSheet.addCell(daTe3);
     		Label chaNNel3 = new Label(2, 10, xldata.getCHANNEL());
     		writeSheet.addCell(chaNNel3);
     		Label piDfromXL3 = new Label(4, 10, xldata.getPID());
     		writeSheet.addCell(piDfromXL3);
     		Label iCEXL3 = new Label(5, 10, String.valueOf(xldata.getREF()));
     		writeSheet.addCell(iCEXL3);
     		Label kpI3 = new Label(3, 10, xldata.getKPIref());
     		writeSheet.addCell(kpI3);
     		Label mpaFromUI3 = new Label(6, 10, String.valueOf(uiData2.getREF()));
     		writeSheet.addCell(mpaFromUI3);
     		float diffBetweentotalUIICEAndIceValueXL3 = Math.abs(xldata.getREF() - uiData2.getREF());
     		if (diffBetweentotalUIICEAndIceValueXL3 >= 0.5) {
     			result = new Label(7, 10, "Mismatch");
     		} else {
     			result = new Label(7, 10, "Match");
     		}
     		writeSheet.addCell(result);
     		Label counTry4 = new Label(0, 11, xldata.getCOUNTRY());
     		writeSheet.addCell(counTry4);
     		Label daTe4 = new Label(1, 11, date);
     		writeSheet.addCell(daTe4);
     		Label chaNNel4 = new Label(2, 11, xldata.getCHANNEL());
     		writeSheet.addCell(chaNNel4);
     		Label piDfromXL4 = new Label(4, 11, xldata.getPID());
     		writeSheet.addCell(piDfromXL4);
     		Label iCEXL4 = new Label(5, 11, String.valueOf(xldata.getCOMM()));
     		writeSheet.addCell(iCEXL4);
     		Label kpI4 = new Label(3, 11, xldata.getKPIcomm());
     		writeSheet.addCell(kpI4);
     		Label mpaFromUI4 = new Label(6, 11, String.valueOf(uiData2.getCOMM()));
     		writeSheet.addCell(mpaFromUI4);
     		float diffBetweentotalUIICEAndIceValueXL4 = Math.abs(xldata.getCOMM() - uiData2.getCOMM());
     		if (diffBetweentotalUIICEAndIceValueXL4 >= 0.5) {
     			result = new Label(7, 11, "Mismatch");
     		} else {
     			result = new Label(7, 11, "Match");
     		}
     		writeSheet.addCell(result);
     		Label counTry5 = new Label(0, 12, xldata.getCOUNTRY());
     		writeSheet.addCell(counTry5);
     		Label daTe5 = new Label(1, 12, date);
     		writeSheet.addCell(daTe5);
     		Label chaNNel5 = new Label(2, 12, xldata.getCHANNEL());
     		writeSheet.addCell(chaNNel5);
     		Label piDfromXL5 = new Label(4, 12, xldata.getPID());
     		writeSheet.addCell(piDfromXL5);
     		Label iCEXL5 = new Label(5, 12, String.valueOf(xldata.getPRICE()));
     		writeSheet.addCell(iCEXL5);
     		Label kpI5 = new Label(3, 12, xldata.getKPIprice());
     		writeSheet.addCell(kpI5);
     		Label mpaFromUI5 = new Label(6, 12, String.valueOf(uiData2.getPRICE()));
     		writeSheet.addCell(mpaFromUI5);
     		float diffBetweentotalUIICEAndIceValueXL5 = Math.abs(xldata.getPRICE() - uiData2.getPRICE());
     		if (diffBetweentotalUIICEAndIceValueXL5 >= 0.5) {
     		result = new Label(7, 12, "Mismatch");
     		} else {
     			result = new Label(7, 12, "Match");
     		}
     		writeSheet.addCell(result);
     		Label counTry7 = new Label(0, 13, xldata.getCOUNTRY());
     		writeSheet.addCell(counTry7);
     		Label daTe7 = new Label(1, 13, date);
     		writeSheet.addCell(daTe7);
     		Label chaNNel7 = new Label(2, 13, xldata.getCHANNEL());
     		writeSheet.addCell(chaNNel7);
     		System.out.println("PID"+"  "+xldata.getPIDTYes());
     		Label piDfromXL7 = new Label(4, 13, xldata.getPIDTYes());
     		writeSheet.addCell(piDfromXL7);
     		Label iCEXL7 = new Label(5, 13, String.valueOf(xldata.getTOTALYES()));
     		writeSheet.addCell(iCEXL7);
     		System.out.println("KPI"+"  "+xldata.getKPItotal());
     		Label kpI7 = new Label(3, 13, xldata.getKPItotal());
     		writeSheet.addCell(kpI7);
     		System.out.println("13th row"+"    "+xldata.getKPItotal());
     		Label mpaFromUI7 = new Label(6, 13, String.valueOf(uiData2.getTOTAL()));
     		writeSheet.addCell(mpaFromUI7);
     		float diffBetweentotalUIICEAndIceValueXL7 = Math.abs(xldata.getTOTALYES() - uiData2.getTOTAL());
     		if (diffBetweentotalUIICEAndIceValueXL7 >= 0.5) {
     			result = new Label(7, 13, "Mismatch");
     		} else {
     			result = new Label(7, 13, "Match");
     		}
     		writeSheet.addCell(result);
    		
}
}