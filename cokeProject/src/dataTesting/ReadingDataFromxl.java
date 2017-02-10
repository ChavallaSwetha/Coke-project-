package dataTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class ReadingDataFromxl {

	/*
	 * Using function readingDataFromXL() read data from XL (Storenames,country,date,ICE,channel,subchannel and cooler values)
	 */
	private String[] storeNameXL;
	private String[] iceXL;
	private int rowsXL;
	private String[] cooLerXL;
	private Float[] icevaLueXL;
	private String[] counTryXL;
	private String[] daTeXL;
	private String[] chaNnelXL;
	private String[] subChanneLXL;

	public ReadingDataFromxl readingDataFromXL() throws BiffException, IOException {
		String[] storeNameXL;
		Float[] iceValueXL;
		String[] channelXLbeforeconverting;
		String[] coolerXL;
		String[] countryXL;
		String[] dateXL;
		String[] channelXL;
		String[] subChannelXL;
		ReadingDataFromxl xlData = new ReadingDataFromxl();
		File fs = new File("C:/Users/Mona Lisa/Downloads/Reading file.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet("Bahamas Onpremise data");
		int row = sh.getRows();
		int rowsCountXL = row;
		System.out.println("No of rows in XL" + "     " + rowsCountXL);
		countryXL = new String[rowsCountXL];
		channelXLbeforeconverting = new String[rowsCountXL];
		coolerXL = new String[rowsCountXL];
		dateXL = new String[rowsCountXL];
		channelXL = new String[rowsCountXL];
		subChannelXL = new String[rowsCountXL];
		storeNameXL = new String[rowsCountXL];
		iceValueXL = new Float[rowsCountXL];
		String[] ice = new String[rowsCountXL];
		String[] iceValueReplacingWithf = new String[rowsCountXL];
		for (int rwXL = 1; rwXL < rowsCountXL; rwXL++) {
			for (int str = 0; str < 1; str++) {
				Cell strNameXL = sh.getCell(str, rwXL);
				storeNameXL[rwXL] = strNameXL.getContents();
				for (int clr = 1; clr < 2; clr++) {
					String S = "sin";
					String C = "con";
					Cell collr = sh.getCell(clr, rwXL);
					channelXLbeforeconverting[rwXL] = collr.getContents();
					String[] chanNelXL = channelXLbeforeconverting[rwXL].split("\\s");
					if (chanNelXL[1].contains(S)) {
						coolerXL[rwXL] = chanNelXL[1].replaceAll(S, "Yes");
					} else {
						coolerXL[rwXL] = chanNelXL[1].replaceAll(C, "No");
					}
					for (int iceclmn = 2; iceclmn < 3; iceclmn++) {
						Cell icXL = sh.getCell(iceclmn, rwXL);
						ice[rwXL] = icXL.getContents();
						iceValueReplacingWithf[rwXL] = ice[rwXL].replace('%', 'f');
						iceValueXL[rwXL] = Float.parseFloat(iceValueReplacingWithf[rwXL]);
						for (int co = 3; co < 4; co++) {
							Cell conTryXL = sh.getCell(co, rwXL);
							countryXL[rwXL] = conTryXL.getContents();
							for (int dt = 4; dt < 5; dt++) {
								Cell dtXL = sh.getCell(dt, rwXL);
								dateXL[rwXL] = dtXL.getContents();
								for (int ch = 5; ch < 6; ch++) {
									Cell chanlXL = sh.getCell(ch, rwXL);
									channelXL[rwXL] = chanlXL.getContents();
									for (int subch = 6; subch < 7; subch++) {
										Cell subChXL = sh.getCell(subch, rwXL);
										subChannelXL[rwXL] = subChXL.getContents();
									}
								}
							}
						}
					}
				}
			}

		}
		xlData.setRowsXL(rowsCountXL);
		xlData.setStoreNameXL(storeNameXL);
		xlData.setIceXL(ice);
		xlData.setCooLerXL(coolerXL);
		xlData.setIcevaLueXL(iceValueXL);
		xlData.setCounTryXL(countryXL);
		xlData.setDaTeXL(dateXL);
		xlData.setChaNnelXL(channelXL);
		xlData.setSubChanneLXL(subChannelXL);
		return xlData;
	}

	public String[] getCounTryXL() {
		return counTryXL;
	}

	public void setCounTryXL(String[] countryXL) {
		this.counTryXL = countryXL;
	}

	public int getRowsXL() {
		return rowsXL;
	}

	public void setRowsXL(int rowsCountXL) {
		this.rowsXL = rowsCountXL;
	}

	public String[] getDaTeXL() {
		return daTeXL;
	}

	public void setDaTeXL(String[] daTeXL) {
		this.daTeXL = daTeXL;
	}

	public String[] getChaNnelXL() {
		return chaNnelXL;
	}

	public void setChaNnelXL(String[] channelXL) {
		this.chaNnelXL = channelXL;
	}

	public String[] getSubChanneLXL() {
		return subChanneLXL;
	}

	public void setSubChanneLXL(String[] subChannelXL) {
		this.subChanneLXL = subChannelXL;
	}

	public String[] getCooLerXL() {
		return cooLerXL;
	}

	public void setCooLerXL(String[] coolerXL) {
		this.cooLerXL = coolerXL;
	}

	public String[] getStoreNameXL() {
		return storeNameXL;
	}

	public void setStoreNameXL(String[] storeNameXL) {
		this.storeNameXL = storeNameXL;
	}

	public String[] getIceXL() {
		return iceXL;
	}

	public void setIceXL(String[] ice) {
		this.iceXL = ice;
	}

	public Float[] getIcevaLueXL() {
		return icevaLueXL;
	}

	public void setIcevaLueXL(Float[] iceValueXL) {
		this.icevaLueXL = iceValueXL;
	}
	
}