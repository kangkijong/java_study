package kbank_practice;
//출금 요청 주체, 정보를 작성하고 직원과 상호작용
public class Customer {
	//Field
	String name;			//이름 (출금 요청 주체)
	String account; 		//계좌번호
	private int password; 	//비밀번호
	
	//Constructor
	public Customer() {}
	public Customer(String name, String account, int password) {
		this.name = name;
		this.account = account;
		this.password = password;
	}
		
	//Method
	public int getPassword() { return password; }
	public void setPassword(int password) { this.password = password; }
}
