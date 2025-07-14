package chapter08;

public class Shape {
	String color;
	
	protected Shape(String color) {	//protected : 자식을 통해서만 생성자에 접근 가능
		this.color = color;
	}
}
