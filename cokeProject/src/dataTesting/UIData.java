package dataTesting;

public class UIData {

	

	private int rowsCountUI;
	private String[] namesUI;
	private Float[] totalUI ;
	private String[] totalBeforeConvertingUI;

	public int getRowsCountUI() {
		return rowsCountUI;
	}

	public void setRowsCountUI(int rowscountUI) {
		this.rowsCountUI = rowscountUI;
	}

	public String[] getTotalBeforeConvertingUI() {
		return totalBeforeConvertingUI;
	}

	public void setTotalBeforeConvertingUI(String[] totalBeforeconvertingUI) {
		this.totalBeforeConvertingUI = totalBeforeconvertingUI;
	}

	public void setNamesUI(String[] namesFromUI) {
		this.namesUI = namesFromUI;

	}

	public String[] getNamesUI() {
		return namesUI;
	}

	public Float[] getTotalUI() {
		return totalUI;
	}

	public void setTotalUI(Float[] toTalUI) {
		this.totalUI = toTalUI;
	}

}
