package chapter08;

public class InheritanceTest2 {

	public static void main(String[] args) {
		Circle redC = new Circle("빨강색", 12);
		Rectangle yellowR = new Rectangle("노랑색", 10, 12);
		Triangle greenT = new Triangle("주황색");
		
		redC.draw();
		yellowR.draw();
		greenT.draw();
		
		System.out.println("redC.getArea : " + redC.getArea());
		System.out.println("yellowR.getArea : " + yellowR.getArea());
		System.out.println("greenT.getArea : " + greenT.getArea());
	
	}

}
