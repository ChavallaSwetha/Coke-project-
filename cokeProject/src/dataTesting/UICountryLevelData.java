package dataTesting;

public class UICountryLevelData {
	private  float mpaUI;
	private float soviUI;
	private float refUI;
	private float commUI;
	private float priUI;
	private float freshUI;
	private float totalUI;
	
	public void setMPA(float mpa){
		 mpaUI = mpa;
		
	}
    public float getMPA(){
    	System.out.println(mpaUI);
    	return mpaUI;
    }
    public void setSOVI(float sovi){
    	soviUI = sovi;
    }
    
    public float getSOVI(){
    	return soviUI;
    }
    
    public void setREF(float ref){
    	refUI = ref;
    }
    public float getREF(){
    	return refUI;
    }
    public void setCOMM(float comm){
    	commUI = comm;
    	
    }
    public float getCOMM(){
    	return commUI;
    }
    public void setPRICE(float price){
    	priUI = price;
    }
    public float getPRICE(){
    	return priUI;
    }
    public void setFRESH(float fresh){
    	freshUI = fresh;
    }
    public float getFRESH(){
    	return freshUI;
    	
    }
    public void setTOTAL(float total){
    	System.out.println("Total from UI"+"     "+total);
         totalUI = total;
}
    public float getTOTAL(){
    	return totalUI;
    }
}
