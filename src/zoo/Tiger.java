package zoo;

/**
 * Animal 클래스를 상속받은 자식 클래스
 */
public class Tiger extends Animal {

	public Tiger() {
		this("호돌이", 3);
	}
	public Tiger(String name, int age) {
		super(name, age);
	}
	
}
