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

	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException {
		
	//static String dateandTime = dataAndTime();
		//public static String dataAndTime() {
			//DateFormat df = new SimpleDateFormat("MM/dd/YYYY  HH:MM");
			//Date dt = new Date();
			//String time = df.format(dt);
			//return time;
		

		/*String channel = "ICE sin Nevera Tradicional";
		String[] output = channel.split("\\s");
		System.out.println(output[1]);
		String cooler = output[1].replaceAll(output[1], "Yes");
		System.out.println(cooler);*/
		
		File fs= new File("C:/Users/Mona Lisa/Downloads/Data testing result store level.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0);
		int rows = sh.getRows();
		int rowsCountXL = rows-1; 
		String[] countryXL = null;
		String[] dateXL = null;
		String[] channelXL = null;
		String[] subChannelXL = null;
		String[] iceXL = null;
		countryXL =new String[rowsCountXL]; 
		dateXL = new String[rowsCountXL];
		channelXL = new String[rowsCountXL];
		subChannelXL = new String[rowsCountXL];
		iceXL = new String[rowsCountXL];
		for (int r=0;r<rowsCountXL;r++){
			for (int c=0;c<1;c++){
				Cell country = sh.getCell(c,r);
				countryXL[r] = country.getContents();
				for (int d=1; d<2;d++){
					Cell date = sh.getCell(d,r);
					dateXL[r] = date.getContents();
					for (int ch=2;ch<3;ch++){
						Cell channel = sh.getCell(ch,r);
						channelXL[r] = channel.getContents();
						for (int sch = 3; sch<4;sch++){
							Cell subChannel = sh.getCell(sch,r);
							subChannelXL[r] = subChannel.getContents();
							for (int ic=4; ic<5; ic++){
								Cell ice = sh.getCell(ic,r);
								iceXL[r] = ice.getContents();
							}
							
						}
					}
				}
				
			}
		}
		
		
		
		
		}
	}


