package model;

public class Employee {

	private String username;
	private String password;
	private String empName;
	private int Id;
	private int BasicPay;
	private int allowance;
	private int sss;
	private int overTime;
	private int pHealth;
	private int HDMF;
	private int tax;
	
	public String getEmpName(){
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setBasicPay(int basicPay) {
		BasicPay = basicPay;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public void setSss(int sss) {
		this.sss = sss;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public void setpHealth(int pHealth) {
		this.pHealth = pHealth;
	}

	public void setHDMF(int hDMF) {
		HDMF = hDMF;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getId() {
		return Id;
	}
	public int getBasicPay(){
		return BasicPay;
	}
	public int getAllowance() {
		return allowance;
	}
	public int getSSS() {
		return sss;
	}
	public int getOverTime() {
		return overTime;
	}
	public int getPhealth() {
		return pHealth;
	}
	public String getUsername() {
		return username;
	}
	public int getHDMF() {
		return HDMF;
	}
	public int getTax() {
		return tax;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
