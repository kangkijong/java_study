package chapter08;

public class ObjectTypeCastingTest {

	public static void main(String[] args) {
		Circle yellowC = new Circle("노랑", 1);
		Rectangle blueR = new Rectangle("파랑", 1, 2);
		Shape s = new Circle("초록색", 2);	//자동(묵시적) 형변환
		Circle cs = (Circle)s;		//강제(명시적) 형변환 O
//		Rectangle r = (Rectangle)s;	//강제(명시적) 형변환 X : 생성된 같은 모습의 자식만 가능!!
		
		Shape s2 = new Shape("빨강");
//		Circle cs2 = (Circle)s2;	//강제(명시적) 형변환 X : s2 객체는 Circle 포함하고 있지 않음
		
		//인터페이스를 통해 자식의 모습으로 객체를 구현하는 것을 권장함!!!
		ShapeInterface si = new Circle("코랄", 1);
		si.draw();	//자식인 Circle의 draw() 호출됨
		System.out.println(si.getArea());
		System.out.println();
		Circle cs3 = (Circle)si;
		cs3.draw();	//자식인 Circle의 draw() 호출됨
		System.out.println(cs3.getArea());
		
		//상속받은 인터페이스 통한 객체 생성 : 인터페이스 기반 설계!!!!!
		//사각형, 삼각형
		ShapeInterface si2 = new Rectangle("보라", 1, 2);
		ShapeInterface si3 = new Triangle("남색");
//		(추상메소드) -- 다형성 구현 -- (상속받아 오버라이딩)
		si2.draw();
		si3.draw();
		System.out.println();
		
		cs.draw();
//		cs2.draw();
		
		yellowC.draw();
		blueR.draw();
//		s.draw();	//Shape 클래스는 draw() 메소드를 정의하지 않음
		System.out.println(s.color);
	}

}
