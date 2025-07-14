package chapter08;

public class InheritanceTest {

	public static void main(String[] args) {
//		Client c1 = new Client();	//abstract 클래스이므로 객체 생성 불가
		Person lee = new Person();
		Person kim = new Person("김유신", "종로구", "010-9876-9876", 12);
		Animal dog = new Animal("흰둥이", 5, lee);
		Animal cat = new Animal("야옹이", 6, kim);
		
//		c1.name = "홍길동";
//		p1.name = "홍길동";	
//		a1.name = "예삐";		//자료(필드)의 상속
		
//		System.out.println("c1.name => " + c1.name);
//		System.out.println("p1.name => " + p1.name);
//		System.out.println("a1.name => " + a1.name);
//		System.out.println("p2.name => " + p2.name);
		
//		c1.printInfo();
		lee.printInfo();
		kim.printInfo();
		dog.printInfo();
		cat.printInfo();
		
		lee.register();
		dog.register();
		cat.register();
		
		dog.sound();
		cat.sound();
	}

}
