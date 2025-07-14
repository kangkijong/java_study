package chapter08;

public class Rectangle extends Shape implements ShapeInterface {
//	String color;
	int height;
	int width;
	
	public Rectangle(String color, int height, int width) {
		super(color);
//		this.color = color;
		this.height = height;
		this.width = width;
	}
	
	@Override
	public void draw() {
		System.out.println(color + " 사각형을 그린다");
	}

	@Override
	public double getArea() {
		return width * height;
	}
	
}
