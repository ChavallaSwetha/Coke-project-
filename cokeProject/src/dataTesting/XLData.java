package dataTesting;

public class XLData {
	
	private int rowCountXL;
	private String[] storenameXL;
	private String[] IceXL;
	private String[] coolerXL;
	private Float[] IcevaLueXL;
	private String[] countryXL;
	private String[] dateXL;
	private String[] channelXL;
	private String[] subChanneLXL;
	
		
	public int getRowXL(){
		
		return rowCountXL;
	}

	public void setRowsXL(int rowscountXL) {
		this.rowCountXL = rowscountXL;
		
	}
	public void setStoreNameXL(String storeNameXL[]){
		this.storenameXL = storeNameXL;
	}
	public String[] getStoreNameXL(){
		return storenameXL;
	}
    public void setIceXL(String iceXL[]){
    	this.IceXL = iceXL;
    }
    public String[] getIceXL(){
    	return IceXL;
    }
    public void setCoolerXL(String cooLerXL[]){
    	this.coolerXL = cooLerXL;
    }
    public String[] getCoolerXL(){
    	return coolerXL;
    }
    public void setIcevalueXL(Float iceValueXL[]){
    	this.IcevaLueXL=iceValueXL;
    }
    public Float[] getIcevalueXL(){
    	return IcevaLueXL;
    }
    public void setCountryXL(String counTryXL[]){
    	this.countryXL = counTryXL;
    }
    public String[] getCountryXL(){
    	return countryXL;
    }
    public void setDateXL(String daTeXL[]){
    	this.dateXL = daTeXL;
    }
    public String[] getDateXL(){
    	return dateXL;
    }
    public void setChannelXL(String[] chaNNelXL){
    	this.channelXL = chaNNelXL;
    }
    public String[] getChannelXL(){
    	return channelXL;
    }
    public void setSubchannelXL(String[] subChannelXL){
    	this.subChanneLXL = subChannelXL;
    }
    public String[] getSubchannelXL(){
    	return subChanneLXL;
    }
}
