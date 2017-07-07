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

	public void compareCountryLevelCoolerData(WebDriver driver, String readFilePath, String date, String writeFilePath,
			UIAndXLCountryLevelData uiData1, UIAndXLCountryLevelData xldata)
			throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException {
		Thread.sleep(8000);
		FileOutputStream fileOutput = new FileOutputStream(writeFilePath);
		WritableWorkbook writeWorkBook = Workbook.createWorkbook(fileOutput);
		WritableSheet writeSheet = writeWorkBook.createSheet(xldata.getCOUNTRY(), 0);
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
		int wr = 1;
		Label counTry = new Label(0, wr, xldata.getCOUNTRY());
		writeSheet.addCell(counTry);
		Label daTe = new Label(1, wr, date);
		writeSheet.addCell(daTe);
		Label chaNNel = new Label(2, wr, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel);
		Label piDfromXL = new Label(4, wr, xldata.getPID());
		writeSheet.addCell(piDfromXL);
		Label iCEXL = new Label(5, wr, String.valueOf(xldata.getMPA()));
		writeSheet.addCell(iCEXL);
		Label kpI = new Label(3, wr, xldata.getKPImpa());
		writeSheet.addCell(kpI);
		Label mpaFromUI = new Label(6, wr, String.valueOf(uiData1.getMPA()));
		writeSheet.addCell(mpaFromUI);
		Label result;
		float diffBetweentotalUIICEAndIceValueXL = Math.abs(xldata.getMPA() - uiData1.getMPA());
		if (diffBetweentotalUIICEAndIceValueXL >= 0.5) {
		result = new Label(7, wr, "Mismatch");
		} else {
			result = new Label(7, wr, "Match");
		}
		writeSheet.addCell(result);
		Label counTry2 = new Label(0, 2, xldata.getCOUNTRY());
		writeSheet.addCell(counTry2);
		Label daTe2 = new Label(1, 2, date);
		writeSheet.addCell(daTe2);
		Label chaNNel2 = new Label(2, 2, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel2);
		Label piDfromXL2 = new Label(4, 2, xldata.getPID());
		writeSheet.addCell(piDfromXL2);
		Label iCEXL2 = new Label(5, 2, String.valueOf(xldata.getSOVI()));
		writeSheet.addCell(iCEXL2);
		Label kpI2 = new Label(3, 2, xldata.getKPIsovi());
		writeSheet.addCell(kpI2);
		Label mpaFromUI2 = new Label(6, 2, String.valueOf(uiData1.getSOVI()));
		writeSheet.addCell(mpaFromUI2);
		float diffBetweentotalUIICEAndIceValueXL2 = Math.abs(xldata.getSOVI() - uiData1.getSOVI());
		if (diffBetweentotalUIICEAndIceValueXL2 >= 0.5) {
			result = new Label(7, 2, "Mismatch");
		} else {
			result = new Label(7, 2, "Match");
		}
		writeSheet.addCell(result);
		Label counTry3 = new Label(0, 3, xldata.getCOUNTRY());
		writeSheet.addCell(counTry3);
		Label daTe3 = new Label(1, 3, date);
		writeSheet.addCell(daTe3);
		Label chaNNel3 = new Label(2, 3, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel3);
		Label piDfromXL3 = new Label(4, 3, xldata.getPID());
		writeSheet.addCell(piDfromXL3);
		Label iCEXL3 = new Label(5, 3, String.valueOf(xldata.getREF()));
		writeSheet.addCell(iCEXL3);
		Label kpI3 = new Label(3, 3, xldata.getKPIref());
		writeSheet.addCell(kpI3);
		Label mpaFromUI3 = new Label(6, 3, String.valueOf(uiData1.getREF()));
		writeSheet.addCell(mpaFromUI3);
		float diffBetweentotalUIICEAndIceValueXL3 = Math.abs(xldata.getREF() - uiData1.getREF());
		if (diffBetweentotalUIICEAndIceValueXL3 >= 0.5) {
			result = new Label(7, 3, "Mismatch");
		} else {
			result = new Label(7, 3, "Match");
		}
		writeSheet.addCell(result);
		Label counTry4 = new Label(0, 4, xldata.getCOUNTRY());
		writeSheet.addCell(counTry4);
		Label daTe4 = new Label(1, 4, date);
		writeSheet.addCell(daTe4);
		Label chaNNel4 = new Label(2, 4, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel4);
		Label piDfromXL4 = new Label(4, 4, xldata.getPID());
		writeSheet.addCell(piDfromXL4);
		Label iCEXL4 = new Label(5, 4, String.valueOf(xldata.getCOMM()));
		writeSheet.addCell(iCEXL4);
		Label kpI4 = new Label(3, 4, xldata.getKPIcomm());
		writeSheet.addCell(kpI4);
		Label mpaFromUI4 = new Label(6, 4, String.valueOf(uiData1.getCOMM()));
		writeSheet.addCell(mpaFromUI4);
		float diffBetweentotalUIICEAndIceValueXL4 = Math.abs(xldata.getCOMM() - uiData1.getCOMM());
		if (diffBetweentotalUIICEAndIceValueXL4 >= 0.5) {
			result = new Label(7, 4, "Mismatch");
		} else {
			result = new Label(7, 4, "Match");
		}
		writeSheet.addCell(result);
		Label counTry5 = new Label(0, 5, xldata.getCOUNTRY());
		writeSheet.addCell(counTry5);
		Label daTe5 = new Label(1, 5, date);
		writeSheet.addCell(daTe5);
		Label chaNNel5 = new Label(2, 5, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel5);
		Label piDfromXL5 = new Label(4, 5, xldata.getPID());
		writeSheet.addCell(piDfromXL5);
		Label iCEXL5 = new Label(5, 5, String.valueOf(xldata.getPRICE()));
		writeSheet.addCell(iCEXL5);
		Label kpI5 = new Label(3, 5, xldata.getKPIprice());
		writeSheet.addCell(kpI5);
		Label mpaFromUI5 = new Label(6, 5, String.valueOf(uiData1.getPRICE()));
		writeSheet.addCell(mpaFromUI5);
		float diffBetweentotalUIICEAndIceValueXL5 = Math.abs(xldata.getPRICE() - uiData1.getPRICE());
		if (diffBetweentotalUIICEAndIceValueXL5 >= 0.5) {
		result = new Label(7, 5, "Mismatch");
		} else {
			result = new Label(7, 5, "Match");
		}
		writeSheet.addCell(result);
		Label counTry6 = new Label(0, 6, xldata.getCOUNTRY());
		writeSheet.addCell(counTry6);
		Label daTe6 = new Label(1, 6, date);
		writeSheet.addCell(daTe6);
		Label chaNNel6 = new Label(2, 6, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel6);
		Label piDfromXL6 = new Label(4, 6, xldata.getPID());
		writeSheet.addCell(piDfromXL6);
		Label iCEXL6 = new Label(5, 6, String.valueOf(xldata.getFRESH()));
		writeSheet.addCell(iCEXL6);
		Label kpI6 = new Label(3, 6, xldata.getKPIfresh());
		writeSheet.addCell(kpI6);
		Label mpaFromUI6 = new Label(6, 6, String.valueOf(uiData1.getFRESH()));
		writeSheet.addCell(mpaFromUI6);
		float diffBetweentotalUIICEAndIceValueXL6 = Math.abs(xldata.getFRESH() - uiData1.getFRESH());
		if (diffBetweentotalUIICEAndIceValueXL6 >= 0.5) {
			result = new Label(7, 6, "Mismatch");
		} else {
			result = new Label(7, 6, "Match");
		}
		writeSheet.addCell(result);
		Label counTry7 = new Label(0, 7, xldata.getCOUNTRY());
		writeSheet.addCell(counTry7);
		Label daTe7 = new Label(1, 7, date);
		writeSheet.addCell(daTe7);
		Label chaNNel7 = new Label(2, 7, xldata.getCHANNEL());
		writeSheet.addCell(chaNNel7);
		Label piDfromXL7 = new Label(4, 7, xldata.getPIDT());
		writeSheet.addCell(piDfromXL7);
		Label iCEXL7 = new Label(5, 7, String.valueOf(xldata.getTOTAL()));
		writeSheet.addCell(iCEXL7);
		Label kpI7 = new Label(3, 7, xldata.getKPItotal());
		writeSheet.addCell(kpI7);
		System.out.println("7th row"+"   "+xldata.getKPItotal());
		Label mpaFromUI7 = new Label(6, 7, String.valueOf(uiData1.getTOTAL()));
		writeSheet.addCell(mpaFromUI7);
		float diffBetweentotalUIICEAndIceValueXL7 = Math.abs(xldata.getTOTAL() - uiData1.getTOTAL());
		if (diffBetweentotalUIICEAndIceValueXL7 >= 0.5) {
			result = new Label(7, 7, "Mismatch");
		} else {
			result = new Label(7, 7, "Match");
		}
		writeSheet.addCell(result);
		writeWorkBook.write();
		writeWorkBook.close();
	}
}