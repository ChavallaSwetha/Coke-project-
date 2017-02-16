package dataTesting;


public class UIData {
	
	
     ReadingDataFromUI data = new ReadingDataFromUI();
  
   
   
private int rowsCountUI =data.getrowsCount();
private  String[] namesUI = data.getnamesUI();
private Float[] totalUI = data.getTotalUI();
private String[] totalBeforeConvertingUI = data.getTotalstringUI();

public int getRowsCountUI() {
	return rowsCountUI;
}

public void setRowsCountUI(int rowsCountUI) {
	this.rowsCountUI = rowsCountUI;
}

public String[] getTotalBeforeConvertingUI() {
	return totalBeforeConvertingUI;
}

public void setTotalBeforeConvertingUI(String[] totalBeforeConvertingUI) {
	this.totalBeforeConvertingUI = totalBeforeConvertingUI;
}

public void setNamesUI(String[] namesFromUI) {
	this.namesUI = namesFromUI;
	
}
public String[] getNamesUI(){
	return namesUI;
}

public Float[] getTotalUI() {
	return totalUI;
}

public void setTotalUI(Float[] totalUI) {
	this.totalUI = totalUI;
}



	
}

