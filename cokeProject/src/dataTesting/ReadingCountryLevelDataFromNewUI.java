package dataTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadingCountryLevelDataFromNewUI {
	public UIAndXLCountryLevelData readingDashBoardData(WebDriver driver) throws InterruptedException {
		
		UIAndXLCountryLevelData kpiData = new UIAndXLCountryLevelData();
		
		//List<WebElement> completePage = driver.findElements(By.xpath("html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/md-content"));
	 List<WebElement> fulltable = driver.findElements(By.xpath("/html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/md-content/div[4]"));
	// WebElement table = fulltable.get(0).findElement(By.xpath("/html/body/layout/div/md-content/md-content[2]/ui-view/ui-view/md-content/div[4]/div"));
	  System.out.println(fulltable.get(0).isDisplayed());
	
	 
	 
	
        	
    













		return kpiData;
}

	
	
}