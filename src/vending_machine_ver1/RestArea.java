package vending_machine_ver1;

public class RestArea {
	//Field
	String name;
	User user;
	VendingMachine machine;
	
	//Constructor
	public RestArea() {
		this("만남의 광장");	//생성자 호출 함수, 오버로딩한 생성자가 존재해야 함
	}
	public RestArea(String name) {
		this.name = name;	//멤버변수 초기화 작업
		user = new User("정국");
		welcome();
		machine = new VendingMachine(user);
	}
	
	//Method
	public void welcome() {
		System.out.println("--------------------------------");
		System.out.println(name+" ☕🍵🥤 휴게소에 오신것을 환영합니다.");
		System.out.println("--------------------------------");
	}
	
}
