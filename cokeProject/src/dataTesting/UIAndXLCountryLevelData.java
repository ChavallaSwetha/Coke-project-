package dataTesting;

public class UIAndXLCountryLevelData {
	private float mpaUI;
	private float soviUI;
	private float refUI;
	private float commUI;
	private float priUI;
	private float freshUI;
	private float totalUI;
	private String kpiXLmpa;
	private String kpiXLsovi;
	private String kpiXLref;
	private String kpiXLcomm;
	private String kpiXLprice;
	private String kpiXLfresh;
	private String kpiXLtotal;
	private String country;
	private String pid;
	private String pidt;
	private String channel;
	private String pidTYes;
	private String pidTNo;

	public void setMPA(float mpa) {
		mpaUI = mpa;

	}

	public float getMPA() {
		return mpaUI;
	}

	public void setSOVI(float sovi) {
		soviUI = sovi;
	}

	public float getSOVI() {
		return soviUI;
	}

	public void setREF(float ref) {
		refUI = ref;
	}

	public float getREF() {
		return refUI;
	}

	public void setCOMM(float comm) {
		commUI = comm;
	}

	public float getCOMM() {
		return commUI;
	}

	public void setPRICE(float price) {
		priUI = price;
	}

	public float getPRICE() {
		return priUI;
	}

	public void setFRESH(float fresh) {
		freshUI = fresh;
	}

	public float getFRESH() {
		return freshUI;

	}

	public void setTOTAL(float total) {
		totalUI = total;
	}

	public float getTOTAL() {
		return totalUI;
	}
	public void setTOTALYES(float total) {
		totalUI = total;
	}

	public float getTOTALYES() {
		return totalUI;
	}

	public void setKPImpa(String kpi) {
		kpiXLmpa = kpi;
	}

	public String getKPImpa() {
		return kpiXLmpa;
	}
	public void setKPIsovi(String kpi) {
		kpiXLsovi = kpi;
	}

	public String getKPIsovi() {
		return kpiXLsovi;
	}
	public void setKPIref(String kpi) {
		kpiXLref = kpi;
	}

	public String getKPIref() {
		return kpiXLref;
	}
	public void setKPIcomm(String kpi) {
		kpiXLcomm = kpi;
	}

	public String getKPIcomm() {
		return kpiXLcomm;
	}
	public void setKPIprice(String kpi) {
		kpiXLprice = kpi;
	}

	public String getKPIprice() {
		return kpiXLprice;
	}
	public void setKPIfresh(String kpi) {
		kpiXLfresh = kpi;
	}

	public String getKPIfresh() {
		return kpiXLfresh;
	}
	public void setKPItotal(String kpi) {
		kpiXLtotal = kpi;
	}

	public String getKPItotal() {
		return kpiXLtotal;
	}
    
	public void setCOUNTRY(String xlCountry){
		country = xlCountry;
	}
	public String getCOUNTRY(){
		return country;
	}
	public void setCHANNEL(String xlChannel){
		channel = xlChannel;
	}
	public String getCHANNEL(){
		return channel;
	}
	public void setPID(String xlPid){
		pid = xlPid;
	}
	public String getPID(){
		return pid;
		
	}
	public void setPIDT(String xlPidt){
		pidt = xlPidt;
	}
	public String getPIDT(){
		return pidt;
		
	}
	public void setPIDTYes(String xlPidt){
		pidTYes = xlPidt;
	}
	public String getPIDTYes(){
		return pidTYes;
		
	}
	public void setPIDTNo(String xlPidt){
		pidTNo = xlPidt;
	}
	public String getPIDTNo(){
		return pidTNo;
		
	}
	public void setKPItotalYES(String kpi){
		kpiXLtotal = kpi;
	}
	public String getKPItotalYES(){
		return kpiXLtotal;
		
	}
}
