package chapter07;

import java.util.Calendar;
import commons.Animal;

public class AnimalAccessModifierTest {

	public static void main(String[] args) {
		//Calendar 객체 생성(?)
//		Calendar c = new Calendar();	//상속관계가 없으므로 객체 생성 불가!!
		Calendar c = Calendar.getInstance();	//생성된 객체의 인스턴스주소를 가져옴, Singleton(싱글톤)
		System.out.println(c.getTime());
		
		
		//static 변수, static 메소드 호출
		AnimalAccessModifier.sname = "스태틱";
		AnimalAccessModifier.sage = 10;
		AnimalAccessModifier.getInfo3();	//static 호출방법1
		
		AnimalAccessModifier aam = new AnimalAccessModifier("호순이", 5);
		aam.sname = "스태틱2";
		aam.sage = 20;
		aam.getInfo3();	//static 호출방법2
		
		//final 변수 테스트
//		aam.fname = "홍길순";	//final 키워드 변수는 외부에서 값을 변경할 수 없음
//		aam.fage = 2;
		
		//상수 호출
		int start = AnimalAccessModifier.START;
		int con = AnimalAccessModifier.CONTINUE;
		int end = AnimalAccessModifier.END;
		
		Animal comDog = new Animal();
		comDog.setName("예삐");
		comDog.setAge(10);
		
//		comDog.name = "예삐";		//패키지가 다르므로 접근 불가 : default(package)
//		comDog.age = 3;			//패키지가 다르므로 접근 불가
		
		aam.name = "심바";
		aam.age = 5;
		
//		aam.pname = "호순이";		//클래스가 다르므로 접근 불가 : private
//		aam.page = 5;			//클래스가 다르므로 접근 불가
		
		System.out.println("name = " + aam.name);
		System.out.println("age = " + aam.age);
		System.out.println("name = " + aam.getPname());		//getter, setter 메소드를 활용해서 출력 가능
		System.out.println("age = " + aam.getPage());
		System.out.println("name = " + comDog.getName());
		System.out.println("age = " + comDog.getAge());
		
	}

}
