package chapter07;
/*
 * 생성자 초기화
 */
public class Animal2 {
	// Field : 전역변수
	String name;
	int age;
	
	// Constructor : 생성자는 오버로딩이 가능함!!
	public Animal2() {	// 기본 생성자 : 생성자가 아무것도 없을때만 JVM이 자동으로 만들어준다. --> 이 부분 주석 처리 시, AnimalTest.java 오류 발생
		System.out.println("객체를 생성한다.");
	}
	
	public Animal2(String name) {	// field의 name만 초기화
		this.name = name;	// 전역변수 name에 지역변수 name을 대입 / this : 전역변수를 레퍼런스할 때 사용
		System.out.println("객체를 생성한다.");
	}
	
	public Animal2(String name, int age) {	// field의 name, age 초기화
		this.name = name;
		this.age = age;
		System.out.println("객체를 생성한다.");
	}
	
	// Method
	public void sleep() {	// public [반환타입=리턴타입] sleep()
		System.out.println(name+" -> 잠을 잔다.");
	}
	
	public static void main(String[] args) {
		Animal2 giraffe = new Animal2();
		Animal2 elephant = new Animal2();
		
		giraffe.name = "기린이";
		elephant.name = "코순이";
		
		System.out.println("giraffe.name = "+giraffe.name);
		System.out.println("elephant.name = "+elephant.name);
		
	}
}
