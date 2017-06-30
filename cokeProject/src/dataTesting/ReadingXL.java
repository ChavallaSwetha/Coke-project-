package dataTesting;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadingXL {
	static String[] countryXL = null;
	static String[] dateXL = null;
	static String[] channelXL = null;
	static String[] subChannelXL = null;
	static String[] iceXL = null;

	public static void main(String[] args) throws BiffException, IOException {

		File fs = new File("C:/Users/Mona Lisa/Downloads/Data testing result store level.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0);
		int rows = sh.getRows();
		int rowsCountXL = rows - 1;
		countryXL = new String[rowsCountXL];
		dateXL = new String[rowsCountXL];
		channelXL = new String[rowsCountXL];
		subChannelXL = new String[rowsCountXL];
		iceXL = new String[rowsCountXL];
		for (int r = 0; r < rowsCountXL; r++) {
			for (int c = 0; c < 1; c++) {
				Cell country = sh.getCell(c, r);
				countryXL[r] = country.getContents();
				for (int d = 1; d < 2; d++) {
					Cell date = sh.getCell(d, r);
					dateXL[r] = date.getContents();
					for (int ch = 2; ch < 3; ch++) {
						Cell channel = sh.getCell(ch, r);
						channelXL[r] = channel.getContents();
						for (int sch = 3; sch < 4; sch++) {
							Cell subChannel = sh.getCell(sch, r);
							subChannelXL[r] = subChannel.getContents();
							for (int ic = 4; ic < 5; ic++) {
								Cell ice = sh.getCell(ic, r);
								iceXL[r] = ice.getContents();
							}

						}
					}
				}

			}
		}
	}

}
