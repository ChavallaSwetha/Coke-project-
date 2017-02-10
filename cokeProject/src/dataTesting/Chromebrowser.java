package dataTesting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.WebDriver;
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



public class Chromebrowser {

	//public static  main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException {
		
	static String dateandTime = dataAndTime();
	public static String dataAndTime() {
			DateFormat df = new SimpleDateFormat("MM/dd/YYYY  HH:MM");
			Date dt = new Date();
			String time = df.format(dt);
			return time;
		
		}
	}
	


