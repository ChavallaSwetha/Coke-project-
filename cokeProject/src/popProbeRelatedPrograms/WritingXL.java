package popProbeRelatedPrograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.CharBuffer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class WritingXL {

	/*
		ReadingXL read = new ReadingXL();
		
		read.channelXL;
		ReadingXL.countryXL;
		ReadingXL.dateXL;
		ReadingXL.subChannelXL;
		ReadingXL.iceXL;
		
		FileOutputStream fos = new FileOutputStream("C:/Users/Mona Lisa/Downloads/Data writing after reading.xls");
		WritableWorkbook wwb = Workbook.createWorkbook(fos);
		WritableSheet wsh = wwb.createSheet("Store",1);
		int a=0, b=1, c=2, d=3, e=4;
		for (int dt1=1;dt1<rowsCountXL;dt1++){
			Label contry = new Label (a,dt1,countryXL[dt1]);
			wsh.addCell(contry);
			Label date = new Label(b,dt1,dateXL[dt1]);
				wsh.addCell(date);
				Label channel = new Label(c, dt1, channelXL[dt1]);
					wsh.addCell(channel);
					Label subchal = new Label(d, dt1, subChannelXL[dt1]);
						wsh.addCell(subchal);
						Label icew = new Label(e,dt1, iceXL[dt1]);
							wsh.addCell(icew);
			}

	}*/
	 public static void main(String argsp[]) throws IOException{
	FileReader fr = new FileReader("C:/Users/Mona Lisa/Desktop/Reading_File.txt");
	BufferedReader br = new BufferedReader(fr);
	LineNumberReader line = new LineNumberReader(br);
	line.setLineNumber(2);
	int readLine = line.getLineNumber();
	String output = Integer.toString(readLine);
	
	//String result = output.r;
	System.out.println(output);
	br.close();
	
}
}

