package dataTesting;
/*<<<<<<< HEAD
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadingCountryLevelDataFromNewUI {

	
	public UIAndXLCountryLevelData readingDashBoardData(WebDriver driver) throws InterruptedException {

		float mpaUI = 0;
		float sOVIf = 0;
		float rEF = 0;
		float coMMEX = 0;
		float prICE = 0;
		float freshNess = 0;
		float totalUIAfterConvertingTofloat;

		UIAndXLCountryLevelData kpiData = new UIAndXLCountryLevelData();
		String MPA = null;
		WebElement fulltable1 = driver.findElement(
				By.xpath("/html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/md-content/div[4]"));
		Thread.sleep(3000);
		WebElement table1 = fulltable1.findElement(By.tagName("thead"));
		WebElement rows1 = table1.findElement(By.tagName("tr"));
		List<WebElement> columns1 = rows1.findElements(By.tagName("th"));
		int colCount = columns1.size();
		WebElement table = fulltable1.findElement(By.tagName("div"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowCount = rows.size();
		System.out.println("RowCount" + " " + rowCount);
		List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));
		String total = driver
				.findElement(By
						.xpath("/html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/md-content/div[4]/div/md-card/md-toolbar/div/div[1]/h5"))
				.getText();
		System.out.println("Traditional total" + "  " + total);
		String totalInUI = total.replaceAll("[^\\d.]", "");
		totalUIAfterConvertingTofloat = Float.parseFloat(totalInUI);
		System.out.println("totalUIAfterConvertingTofloat" + "  " + totalUIAfterConvertingTofloat);
		for (int kpi = 1; kpi < colCount; kpi++) {
			MPA = columns1.get(kpi).getText();
			if (MPA.contains("MAIN")) {
				String mPA = columns.get(kpi).getText();
				mpaUI = Float.parseFloat(mPA);
				System.out.println("MPA" + "  " + mPA);
			} else if (MPA.contains("SO")) {
				String sovi = columns.get(kpi).getText();
				sOVIf = Float.parseFloat(sovi);
				System.out.println("SOVI" + "  " + sovi);
			} else if (MPA.contains("REF")) {
				String ref = columns.get(kpi).getText();
				rEF = Float.parseFloat(ref);
				System.out.println("REFRIGIRATION" + "  " + ref);
			} else if (MPA.contains("COMM")) {
				String comm = columns.get(kpi).getText();
				coMMEX = Float.parseFloat(comm);
				System.out.println("COMMUNION" + "  " + comm);
			} else if (MPA.contains("PRI")) {
				String price = columns.get(kpi).getText();
				prICE = Float.parseFloat(price);
				System.out.println("PRICE" + "  " + price);
			} else if (MPA.contains("PRO")) {
				String fresh = columns.get(kpi).getText();
				freshNess = Float.parseFloat(fresh);
				System.out.println("FRESHNESS" + "  " + fresh);
			}

			kpiData.setMPA(mpaUI);
			kpiData.setSOVI(sOVIf);
			kpiData.setREF(rEF);
			kpiData.setCOMM(coMMEX);
			kpiData.setPRICE(prICE);
			kpiData.setFRESH(freshNess);
			kpiData.setTOTAL(totalUIAfterConvertingTofloat);
			kpiData.getMPA();
			kpiData.getSOVI();
			kpiData.getREF();
			kpiData.getCOMM();
			kpiData.getFRESH();
			kpiData.getPRICE();
			kpiData.getTOTAL();

		}
		return kpiData;
	}


}*/


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadingCountryLevelDataFromNewUI {
	public UIAndXLCountryLevelData readingDashBoardData(WebDriver driver) throws InterruptedException {

		float mpaUI = 0;
		float sOVIf = 0;
		float rEF = 0;
		float coMMEX = 0;
		float prICE = 0;
		float freshNess = 0;
		float totalUIAfterConvertingTofloat;

		UIAndXLCountryLevelData kpiData = new UIAndXLCountryLevelData();
		String MPA = null;
		WebElement fulltable1 = driver.findElement(
				By.xpath("/html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/md-content/div[4]"));
		Thread.sleep(3000);
		WebElement table1 = fulltable1.findElement(By.tagName("thead"));
		WebElement rows1 = table1.findElement(By.tagName("tr"));
		List<WebElement> columns1 = rows1.findElements(By.tagName("th"));
		int colCount = columns1.size();
		WebElement table = fulltable1.findElement(By.tagName("div"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowCount = rows.size();
		System.out.println("RowCount" + " " + rowCount);
		List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));
		String total = driver
				.findElement(By
						.xpath("/html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/md-content/div[4]/div/md-card/md-toolbar/div/div[1]/h5"))
				.getText();
		System.out.println("Traditional total" + "  " + total);
		String totalInUI = total.replaceAll("[^\\d.]", "");
		totalUIAfterConvertingTofloat = Float.parseFloat(totalInUI);
		System.out.println("totalUIAfterConvertingTofloat" + "  " + totalUIAfterConvertingTofloat);
		for (int kpi = 1; kpi < colCount; kpi++) {
			MPA = columns1.get(kpi).getText();
			if (MPA.contains("MAIN")) {
				String mPA = columns.get(kpi).getText();
				mpaUI = Float.parseFloat(mPA);
				System.out.println("MPA" + "  " + mPA);
			} else if (MPA.contains("SO")) {
				String sovi = columns.get(kpi).getText();
				sOVIf = Float.parseFloat(sovi);
				System.out.println("SOVI" + "  " + sovi);
			} else if (MPA.contains("REF")) {
				String ref = columns.get(kpi).getText();
				rEF = Float.parseFloat(ref);
				System.out.println("REFRIGIRATION" + "  " + ref);
			} else if (MPA.contains("COMM")) {
				String comm = columns.get(kpi).getText();
				coMMEX = Float.parseFloat(comm);
				System.out.println("COMMUNION" + "  " + comm);
			} else if (MPA.contains("PRI")) {
				String price = columns.get(kpi).getText();
				prICE = Float.parseFloat(price);
				System.out.println("PRICE" + "  " + price);
			} else if (MPA.contains("PRO")) {
				String fresh = columns.get(kpi).getText();
				freshNess = Float.parseFloat(fresh);
				System.out.println("FRESHNESS" + "  " + fresh);
			}

			kpiData.setMPA(mpaUI);
			kpiData.setSOVI(sOVIf);
			kpiData.setREF(rEF);
			kpiData.setCOMM(coMMEX);
			kpiData.setPRICE(prICE);
			kpiData.setFRESH(freshNess);
			kpiData.setTOTAL(totalUIAfterConvertingTofloat);
			kpiData.getMPA();
			kpiData.getSOVI();
			kpiData.getREF();
			kpiData.getCOMM();
			kpiData.getFRESH();
			kpiData.getPRICE();
			kpiData.getTOTAL();

		}
		return kpiData;
	}

}

