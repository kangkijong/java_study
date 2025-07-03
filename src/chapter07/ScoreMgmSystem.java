package chapter07;

import java.util.Scanner;
/*
 * - 학생 3명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다. 
 */
public class ScoreMgmSystem {
	// Field
	String admin;
	Student student;
	Scanner scan = new Scanner(System.in);
	Student[] slist = new Student[3];	// 배열로 학생 10명의 정보를 받는다면
	
	// Constructor
	public ScoreMgmSystem() {}
	
	// Method
	public void insert() {
		System.out.println("-- insert --");
		student = new Student();
		
		System.out.print("학생명> ");
		student.name = scan.next();
		
		System.out.print("국어> ");
		student.kor = scan.nextInt();
		
		System.out.print("영어> ");
		student.eng = scan.nextInt();
		
		System.out.print("수학> ");
		student.math = scan.nextInt();
		
		System.out.println("=> 등록 완료!!");
	}
	
	public void show() {
		System.out.println("-----------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------");
		System.out.print(student.name+"\t");
		System.out.print(student.kor+"\t");
		System.out.print(student.eng+"\t");
		System.out.print(student.math+"\t");
		System.out.print(student.getTot()+"\t");
		System.out.println(student.getAvg());
		System.out.println("----------------------------------------------");
	}
	
	public void update() {
		System.out.println("수정");
	}
	
	public void remove() {
		System.out.println("삭제");
	}
	
	public void search() {
		System.out.println("검색");
	}
	
}
