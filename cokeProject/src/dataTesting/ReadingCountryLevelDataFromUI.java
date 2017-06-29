package dataTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReadingCountryLevelDataFromUI {

	
	public UICountryLevelData readingDashBoardData(WebDriver driver){
	/*String total = driver
			.findElement(
					By.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[1]/div[5]/div/div[1]/span"))
			.getText();
	float iceTotal = Float.parseFloat(total);*/
	String mPA = driver
			.findElement(By
					.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[4]/td[2]"))
			.getText();
	float mpaUI = Float.parseFloat(mPA);
	System.out.println(mpaUI);
	String soVI = driver
			.findElement(By
					.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[4]/td[3]"))
			.getText();
	float sOVIf = Float.parseFloat(soVI);
	String refrigiration = driver
			.findElement(By
					.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[4]/td[4]"))
			.getText();
	float rEF = Float.parseFloat(refrigiration);
	String communion = driver
			.findElement(By
					.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[4]/td[5]"))
			.getText();
	float coMMEX = Float.parseFloat(communion);
	String price = driver
			.findElement(By
					.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[4]/td[6]"))
			.getText();
	float prICE = Float.parseFloat(price);
	String freshNEss = driver
			.findElement(By
					.xpath(".//*[@id='dashboard-container']/div[2]/div[4]/div[1]/div[2]/div/table/tbody/tr[4]/td[7]"))
			.getText();
	float freshNess = Float.parseFloat(freshNEss);
	UICountryLevelData kpiData = new UICountryLevelData();
	
	kpiData.setMPA(mpaUI);
	kpiData.setSOVI(sOVIf);
	kpiData.setREF(rEF);
	kpiData.setCOMM(coMMEX);
	kpiData.setPRICE(prICE);
	kpiData.setFRESH(freshNess);
	kpiData.getMPA();
	kpiData.getSOVI();
	kpiData.getREF();
	kpiData.getCOMM();
	kpiData.getFRESH();
	kpiData.getPRICE();
	return kpiData;
}
}