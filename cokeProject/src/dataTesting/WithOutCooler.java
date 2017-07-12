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

	public void compareCountryLevelCoolerData(WritableSheet writeSheet, String readFilePath, String date, 
			 int i,UIAndXLCountryLevelData uiData2,UIAndXLCountryLevelData xldata)
			throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException {
		Thread.sleep(8000);
         
		/*File writeFile = new File(writeFilePath);
	      Workbook wrkBook = Workbook.getWorkbook(writeFile);
		  WritableWorkbook wwbook = Workbook.createWorkbook(writeFile, wrkBook);
		
	      WritableSheet writeSheet =   wwbook.getSheet(xldata.getCOUNTRY());*/
	     Label counTry = new Label(0, 14, xldata.getCOUNTRY());
		writeSheet.addCell(counTry);
		Label daTe = new Label(1, 14, date);
		writeSheet.addCell(daTe);
		Label chaNNel = new Label(2, 14, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel);
		System.out.println("PID"+"  "+xldata.getPID());
		Label piDfromXL = new Label(4, 14, xldata.getPID());
		writeSheet.addCell(piDfromXL);
		Label iCEXL = new Label(5, 14, String.valueOf(xldata.getMPA()));
		writeSheet.addCell(iCEXL);
		System.out.println("KPI"+"  "+xldata.getKPImpa());
		Label kpI = new Label(3, 14, xldata.getKPImpa());
		writeSheet.addCell(kpI);
		Label mpaFromUI = new Label(6, 14, String.valueOf(uiData2.getMPA()));
		writeSheet.addCell(mpaFromUI);
		Label result;
		float diffBetweentotalUIICEAndIceValueXL = Math.abs(xldata.getMPA() - uiData2.getMPA());
		if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
		result = new Label(7, 14, "Mismatch");
		} else {
			result = new Label(7, 14, "Match");
		}
		writeSheet.addCell(result);
		Label counTry2 = new Label(0, 15, xldata.getCOUNTRY());
		writeSheet.addCell(counTry2);
		Label daTe2 = new Label(1, 15, date);
		writeSheet.addCell(daTe2);
		Label chaNNel2 = new Label(2,15, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel2);
		System.out.println("PID"+"  "+xldata.getPID());
		Label piDfromXL2 = new Label(4, 15, xldata.getPID());
		writeSheet.addCell(piDfromXL2);
		Label iCEXL2 = new Label(5, 15, String.valueOf(xldata.getSOVI()));
		writeSheet.addCell(iCEXL2);
		System.out.println("KPI"+"  "+xldata.getKPIsovi());
		Label kpI2 = new Label(3, 15, xldata.getKPIsovi());
		writeSheet.addCell(kpI2);
		Label mpaFromUI2 = new Label(6, 15, String.valueOf(uiData2.getSOVI()));
		writeSheet.addCell(mpaFromUI2);
		float diffBetweentotalUIICEAndIceValueXL2 = Math.abs(xldata.getSOVI() - uiData2.getSOVI());
		if (diffBetweentotalUIICEAndIceValueXL2 >= 0.5) {
			result = new Label(7, 15, "Mismatch");
		} else {
			result = new Label(7, 15, "Match");
		}
		writeSheet.addCell(result);
		Label counTry3 = new Label(0, 16, xldata.getCOUNTRY());
		writeSheet.addCell(counTry3);
		Label daTe3 = new Label(1, 16, date);
		writeSheet.addCell(daTe3);
		Label chaNNel3 = new Label(2, 16, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel3);
		System.out.println("PID"+"  "+xldata.getPID());
		Label piDfromXL3 = new Label(4, 16, xldata.getPID());
		writeSheet.addCell(piDfromXL3);
		Label iCEXL3 = new Label(5, 16, String.valueOf(xldata.getREF()));
		writeSheet.addCell(iCEXL3);
		System.out.println("KPI"+"  "+xldata.getKPIref());
		Label kpI3 = new Label(3, 16, xldata.getKPIref());
		writeSheet.addCell(kpI3);
		Label mpaFromUI3 = new Label(6, 16, String.valueOf(uiData2.getREF()));
		writeSheet.addCell(mpaFromUI3);
		float diffBetweentotalUIICEAndIceValueXL3 = Math.abs(xldata.getREF() - uiData2.getREF());
		if (diffBetweentotalUIICEAndIceValueXL3 >= 0.5) {
			result = new Label(7, 16, "Mismatch");
		} else {
			result = new Label(7, 16, "Match");
		}
		writeSheet.addCell(result);
		Label counTry4 = new Label(0, 17, xldata.getCOUNTRY());
		writeSheet.addCell(counTry4);
		Label daTe4 = new Label(1, 17, date);
		writeSheet.addCell(daTe4);
		Label chaNNel4 = new Label(2, 17, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel4);
		System.out.println("PID"+"  "+xldata.getPID());
		Label piDfromXL4 = new Label(4, 17, xldata.getPID());
		writeSheet.addCell(piDfromXL4);
		Label iCEXL4 = new Label(5, 17, String.valueOf(xldata.getCOMM()));
		writeSheet.addCell(iCEXL4);
		System.out.println("KPI"+"  "+xldata.getKPIcomm());
		Label kpI4 = new Label(3, 17, xldata.getKPIcomm());
		writeSheet.addCell(kpI4);
		Label mpaFromUI4 = new Label(6, 17, String.valueOf(uiData2.getCOMM()));
		writeSheet.addCell(mpaFromUI4);
		float diffBetweentotalUIICEAndIceValueXL4 = Math.abs(xldata.getCOMM() - uiData2.getCOMM());
		if (diffBetweentotalUIICEAndIceValueXL4 >= 0.5) {
			result = new Label(7, 17, "Mismatch");
		} else {
			result = new Label(7, 17, "Match");
		}
		writeSheet.addCell(result);
		Label counTry5 = new Label(0, 18, xldata.getCOUNTRY());
		writeSheet.addCell(counTry5);
		Label daTe5 = new Label(1, 18, date);
		writeSheet.addCell(daTe5);
		Label chaNNel5 = new Label(2, 18, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel5);
		System.out.println("PID"+"  "+xldata.getPID());
		Label piDfromXL5 = new Label(4, 18, xldata.getPID());
		writeSheet.addCell(piDfromXL5);
		Label iCEXL5 = new Label(5, 18, String.valueOf(xldata.getPRICE()));
		writeSheet.addCell(iCEXL5);
		System.out.println("KPI"+"  "+xldata.getKPIprice());
		Label kpI5 = new Label(3, 18, xldata.getKPIprice());
		writeSheet.addCell(kpI5);
		Label mpaFromUI5 = new Label(6, 18, String.valueOf(uiData2.getPRICE()));
		writeSheet.addCell(mpaFromUI5);
		float diffBetweentotalUIICEAndIceValueXL5 = Math.abs(xldata.getPRICE() - uiData2.getPRICE());
		if (diffBetweentotalUIICEAndIceValueXL5 >= 0.5) {
		result = new Label(7, 18, "Mismatch");
		} else {
			result = new Label(7, 18, "Match");
		}
		writeSheet.addCell(result);
		Label counTry7 = new Label(0, 19, xldata.getCOUNTRY());
		writeSheet.addCell(counTry7);
		Label daTe7 = new Label(1, 19, date);
		writeSheet.addCell(daTe7);
		Label chaNNel7 = new Label(2, 19, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel7);
		System.out.println("PID"+"  "+xldata.getPIDTNo());
		Label piDfromXL7 = new Label(4, 19, xldata.getPIDTNo());
		writeSheet.addCell(piDfromXL7);
		Label iCEXL7 = new Label(5, 19, String.valueOf(xldata.getTOTALYES()));
		writeSheet.addCell(iCEXL7);
		System.out.println("KPI"+"  "+xldata.getKPItotal());
		Label kpI7 = new Label(3, 19, xldata.getKPItotal());
		writeSheet.addCell(kpI7);
		System.out.println("19th row"+"    "+xldata.getKPItotal());
		Label mpaFromUI7 = new Label(6, 19, String.valueOf(uiData2.getTOTAL()));
		writeSheet.addCell(mpaFromUI7);
		float diffBetweentotalUIICEAndIceValueXL7 = Math.abs(xldata.getTOTALYES() - uiData2.getTOTAL());
		if (diffBetweentotalUIICEAndIceValueXL7 >= 0.5) {
			result = new Label(7, 19, "Mismatch");
		} else {
			result = new Label(7, 19, "Match");
		}
		writeSheet.addCell(result);
		/*wwbook.write();
		wwbook.close();*/
}
}