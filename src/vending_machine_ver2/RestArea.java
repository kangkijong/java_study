package vending_machine_ver2;

public class RestArea {
	//Field
	String name;					//휴게소 이름
	User user;						//사용자 이름
	VendingMachine machine;			//자판기 이름
	
	//Constructor
	public RestArea() {
		this("맥심");
	}
	public RestArea(String name) {
		this.name = name;
		user = new User("정국");
		welcome();
		machine = new VendingMachine(user);
	}
	
	//Method
	public void welcome() {
		System.out.println("===========================");
		System.out.println(name + " 휴게소에 오신 것을 환영합니다.");
		System.out.println("===========================");
	}
}
