package kbank_practice;
//실제 은행에 저장된 고객 정보 보관
public class AccountVo {
	//Field
	private String name;	//은행에 저장된 고객 이름
	private String account;	//은행에 저장된 고객 계좌번호
	private int password;	//은행에 저장된 고객 비밀번호
	
	//Constructor
	public AccountVo() {}
	public AccountVo(String name, String account, int password) {
		this.name = name;
		this.account = account;
		this.password = password;
	}
		
	//Method
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getAccount() { return account; }
	public void setAccount(String account) { this.account = account; }
	public int getPassword() { return password; }
	public void setPassword(int password) { this.password = password; }
}
