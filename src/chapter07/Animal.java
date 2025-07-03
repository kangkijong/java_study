package chapter07;

public class Animal {
	// Field : 전역변수
	String name;
	int age;
	
	// Constructor
	public Animal() {	// 기본 생성자
		// 생성자 호출 시 실행되는 내용 => new Animal() 코드 실행 시 실행됨!!
		System.out.println("객체를 생성한다.");
	}
	
	// Method
	public void sleep() {	// public [반환타입=리턴타입] sleep()
		System.out.println(name+" -> 잠을 잔다.");
	}
	
	public static void main(String[] args) {
		Animal giraffe = new Animal();
		Animal elephant = new Animal();
		
		giraffe.name = "기린이";
		elephant.name = "코순이";
		
		System.out.println("giraffe.name = "+giraffe.name);
		System.out.println("elephant.name = "+elephant.name);
		
	}
}
