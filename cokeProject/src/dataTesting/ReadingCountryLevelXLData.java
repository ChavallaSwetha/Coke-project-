package dataTesting;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadingCountryLevelXLData {

	public UIAndXLCountryLevelData readingCountryLevelXLData(String readFilePath, String country, String channel,
			String cooler,String withAndWithoutCooler) throws BiffException, IOException {
		UIAndXLCountryLevelData xlData = new UIAndXLCountryLevelData();

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
		String freshNESs = "Frescura de Producto";
		String toTal = "ICE Total Tradicional";
		String totalYes = "ICE con Nevera Tradicional";
		String totalNo = "ICE sin Nevera Tradicional";
		String pidT = "1";
		String pidTY = "2";
		String pidTN = "3";

		String[] countryXL = new String[rowsXL];
		String[] channelXL = new String[rowsXL];
		String[] dateXL = new String[rowsXL];
		String[] kpiXL = new String[rowsXL];
		String[] piDXL = new String[rowsXL];
		String[] iceXL = new String[rowsXL];
		String[] idXL = new String[rowsXL];

		for (int rwXL = 0; rwXL < rowsXL; rwXL++) {
			Cell countryFromXL = sh.getCell(1, rwXL);
			countryXL[rwXL] = countryFromXL.getContents();

			Cell dateFromXL = sh.getCell(6, rwXL);
			dateXL[rwXL] = dateFromXL.getContents();

			Cell channelFromXL = sh.getCell(5, rwXL);
			channelXL[rwXL] = channelFromXL.getContents();

			Cell kpiFromXL = sh.getCell(10, rwXL);
			kpiXL[rwXL] = kpiFromXL.getContents();

			Cell iceFromXL = sh.getCell(11, rwXL);
			iceXL[rwXL] = iceFromXL.getContents();

			Cell pidFromXL = sh.getCell(9, rwXL);
			piDXL[rwXL] = pidFromXL.getContents();

			Cell idCriteriaXL = sh.getCell(8, rwXL);
			idXL[rwXL] = idCriteriaXL.getContents();

		}
		for (int r = 0; r < rowsXL; r++) {
			if (country.equals(countryXL[r])) {
				String xlCountry = countryXL[r];
				xlData.setCOUNTRY(xlCountry);
				if (channel.equals(channelXL[r])) {
					String xlChannel = channelXL[r];
					xlData.setCHANNEL(xlChannel);
					if (piDXL[r].equals(cooler)) {
						String pid = piDXL[r];
						xlData.setPID(pid);
						if (kpiXL[r].equals(mpa)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							xlData.setMPA(xlIce);
							xlData.setKPImpa(kpi);
						} else if (kpiXL[r].equals(sovi)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							xlData.setSOVI(xlIce);
							xlData.setKPIsovi(kpi);
						} else if (kpiXL[r].equals(refregiratio)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							xlData.setREF(xlIce);
							xlData.setKPIref(kpi);
						} else if (kpiXL[r].equals(commuNion)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							xlData.setCOMM(xlIce);
							xlData.setKPIcomm(kpi);
						} else if (kpiXL[r].equals(priCe)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							xlData.setPRICE(xlIce);
							xlData.setKPIprice(kpi);
						} else if (kpiXL[r].equals(freshNESs)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							xlData.setFRESH(xlIce);
							xlData.setKPIfresh(kpi);
							
						}
					}
					if ("NULL".equals(withAndWithoutCooler)){
					if (idXL[r].equals(pidT)) {
							if (kpiXL[r].equals(toTal)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							xlData.setTOTAL(xlIce);
							xlData.setKPItotal(kpi);
							xlData.setPIDT(pidT);
                            
						}
					} 
				} else if ("YES".equals(withAndWithoutCooler)){
					if (idXL[r].equals(pidTY)) {
					if (kpiXL[r].equals(totalYes)) {
							String kpi = kpiXL[r];
							String icEXL = iceXL[r];
							String iCE = icEXL.replace('%', 'f');
							float xlIce = Float.parseFloat(iCE);
							xlData.setTOTALYES(xlIce);
							xlData.setKPItotal(kpi);
							xlData.setPIDTYes(pidTY);
						}
							
						}
					}
				else if ("NO".equals(withAndWithoutCooler)){
						if (idXL[r].equals(pidTN)) {
								if (kpiXL[r].equals(totalNo)) {
								String kpi = kpiXL[r];
								String icEXL = iceXL[r];
								String iCE = icEXL.replace('%', 'f');
								float xlIce = Float.parseFloat(iCE);
								xlData.setTOTAL(xlIce);
								xlData.setKPItotal(kpi);
								xlData.setPIDTNo(pidTN);
	                            
							}
						} 
					} 
				}
			}
		}

		xlData.getCOMM();
		xlData.getFRESH();
		xlData.getMPA();
		xlData.getPRICE();
		xlData.getREF();
		xlData.getSOVI();
		xlData.getTOTAL();
		xlData.getTOTALYES();
		xlData.getKPImpa();
		xlData.getKPIsovi();
		xlData.getKPIref();
		xlData.getKPIcomm();
		xlData.getKPIfresh();
		xlData.getKPIprice();
		xlData.getKPItotal();
		xlData.getCHANNEL();
		xlData.getCOUNTRY();
		xlData.getPID();
		xlData.getPIDT();
		xlData.getPIDTYes();
		xlData.getPIDTNo();
		return xlData;

	}
}
