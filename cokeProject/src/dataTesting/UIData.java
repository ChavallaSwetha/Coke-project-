
package dataTesting;

import java.util.HashMap;
import java.util.Set;

import dataTesting.ComparingStoreLevelDataAndWritingXL.TraditionalKPIs;
import dataTesting.ComparingStoreLevelPremiseDataAndWritingXL.PremiseKPIs;

public class UIData {

	private int rowsCountUI;
	private int storeCount;

	public int getRowsCountUI() {
		return rowsCountUI;
	}

	public void setRowsCountUI(int rowscountUI) {
		this.rowsCountUI = rowscountUI;
	}

	public String[] getNamesUI() {
		Set<String> keys = mapUIdata.keySet();
		return keys.toArray(new String[0]);
	}

	private HashMap<String, Float> mapUIdata = new HashMap<String, Float>();

	private HashMap<String, String> mapCustDataUI = new HashMap<String, String>();

	public void setCustUI(String namesUI, String custUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapCustDataUI.put(namesUI.toLowerCase(), custUI);

	}

	public String getCustUI(String namesUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		String uICust = mapCustDataUI.get(namesUI.toLowerCase());
		return uICust;
	}

	private HashMap<String, String> mapRailDataUI = new HashMap<String, String>();

	public void setRailUI(String namesUI, String railUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapRailDataUI.put(namesUI.toLowerCase(), railUI.toUpperCase());

	}

	public String getRailUI(String namesUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		String uIRail = mapRailDataUI.get(namesUI.toLowerCase());
		return uIRail;
	}

	private HashMap<String, String> mapCoolFromUI = new HashMap<String, String>();

	public void setCoolUI(String namesUI, String coolUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		mapCoolFromUI.put(namesUI.toLowerCase(), coolUI.toLowerCase());

	}

	public String getCoolUI(String namesUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "");
		String uICool = mapCoolFromUI.get(namesUI.toLowerCase());
		return uICool;
	}

	public void setStoreCount(int strCount) {
		this.storeCount = strCount;
	}

	public int getStoreCount() {
		return storeCount;
	}

	private HashMap<String, Float> mapUIMPA = new HashMap<String, Float>();
	private HashMap<String, Float> mapUISOVI = new HashMap<String, Float>();
	private HashMap<String, Float> mapUIREF = new HashMap<String, Float>();
	private HashMap<String, Float> mapUICOMM = new HashMap<String, Float>();
	private HashMap<String, Float> mapUIPRICE = new HashMap<String, Float>();
	private HashMap<String, Float> mapUIFRESH = new HashMap<String, Float>();

	public void setKPIUI(String namesUI, PremiseKPIs preKPI, Float mpaUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "").toLowerCase();

		switch (preKPI) {
		case TOTAL:
			mapUIdata.put(namesUI, mpaUI);
		case MPA:
			mapUIMPA.put(namesUI, mpaUI);
		case SOVI:
			mapUISOVI.put(namesUI, mpaUI);
		case REF:
			mapUIREF.put(namesUI, mpaUI);
		case COMM:
			mapUICOMM.put(namesUI, mpaUI);
		case COLDA:
			mapUIPRICE.put(namesUI, mpaUI);
		case COMBO:
			mapUIFRESH.put(namesUI, mpaUI);
		default:
			break;
		}
	}

	public Float getPremiseKPI(PremiseKPIs kpi, String namesUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "").toLowerCase();
		switch (kpi) {
		case TOTAL:
			Float uITotal = mapUIdata.get(namesUI);
			return uITotal;
		case MPA:
			Float uIMpa = mapUIMPA.get(namesUI);
			System.out.println("MPA value" + " " + uIMpa);
			return uIMpa;
		case SOVI:
			Float uISovi = mapUISOVI.get(namesUI);
			System.out.println("SOVI value" + " " + uISovi);
			return uISovi;
		case REF:
			Float uIRef = mapUIREF.get(namesUI);
			return uIRef;
		case COMM:
			Float uIComm = mapUICOMM.get(namesUI);
			return uIComm;
		case COLDA:
			Float uIPrice = mapUIPRICE.get(namesUI);
			return uIPrice;
		case COMBO:
			Float uIFresh = mapUIFRESH.get(namesUI);
			return uIFresh;
		default:
			break;
		}
		return null;
	}
	
	public void setKPIUI(String namesUI, TraditionalKPIs preKPI, Float mpaUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "").toLowerCase();

		switch (preKPI) {
		case TOTAL:
			mapUIdata.put(namesUI, mpaUI);
		case MPA:
			mapUIMPA.put(namesUI, mpaUI);
		case SOVI:
			mapUISOVI.put(namesUI, mpaUI);
		case REF:
			mapUIREF.put(namesUI, mpaUI);
		case COMM:
			mapUICOMM.put(namesUI, mpaUI);
		case PRICE:
			mapUIPRICE.put(namesUI, mpaUI);
		case FRESH:
			mapUIFRESH.put(namesUI, mpaUI);
		default:
			break;
		}
	}

	public Float getTraditionalKPI(TraditionalKPIs kpi, String namesUI) {
		namesUI = namesUI.replaceAll("[ ,.&()/'-]", "").toLowerCase();
		switch (kpi) {
		case TOTAL:
			Float uITotal = mapUIdata.get(namesUI);
			return uITotal;
		case MPA:
			Float uIMpa = mapUIMPA.get(namesUI);
			return uIMpa;
		case SOVI:
			Float uISovi = mapUISOVI.get(namesUI);
			return uISovi;
		case REF:
			Float uIRef = mapUIREF.get(namesUI);
			return uIRef;
		case COMM:
			Float uIComm = mapUICOMM.get(namesUI);
			return uIComm;
		case PRICE:
			Float uIPrice = mapUIPRICE.get(namesUI);
			return uIPrice;
		case FRESH:
			Float uIFresh = mapUIFRESH.get(namesUI);
			return uIFresh;
		default:
			break;
		}
		return null;
	}

}
