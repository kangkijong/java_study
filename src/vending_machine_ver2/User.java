package vending_machine_ver2;

import java.util.Scanner;

public class User {
	//Field
	String name;
	Scanner scan;
	
	//Constructor
	public User() {
		this("아무개");
	}
	public User(String name) {
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	//Method
	public String getName() { return name; }
	public Scanner getScan() { return scan; }
	
	public int insertCoin() {
		int resultCoin = 0;
		System.out.print("["+name+"] 동전 투입> ");
		if(scan.hasNextInt()) {	//정수 입력 받았을 경우
			int coin = scan.nextInt();
			resultCoin = coin;
		} else {
			System.out.println("=> 올바르지 않은 값입니다. 다시 투입해주세요.");
			scan.next();
			insertCoin();
		}
		return resultCoin;
	}
}
