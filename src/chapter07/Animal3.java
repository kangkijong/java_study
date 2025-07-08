package chapter07;

/*
 * 생성자 오버로딩, this() 메소드 
 */
public class Animal3 {
	// Field
	int age;
	String name;
	String addr;
	
	// Constructor
	public Animal3() {
		this("홍길동", 5, "강남구");
//		this.name = "홍길동";	// 실행안됨, this("홍길동", 5, "강남구"); 위에 위치 시 오류 발생 
	}
	public Animal3(String name) {
//		this.name = name; 
//		this.age = 5;
//		this.addr = "강남구";
		this(name, 5, "강남구");
	}
	public Animal3(int age) {
//		this.age = age;
		this("홍길동", age, "강남구");
	}
	public Animal3(String name, int age) {
//		this.name = name;
//		this.age = age;
		this(name, age, "강남구");
	}
	public Animal3(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	// Method
	public void info() {
		System.out.println("name = "+name);
		System.out.println("age = "+age);
		System.out.println("addr = "+addr);
	}
}
