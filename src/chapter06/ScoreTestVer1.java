package chapter06;

import java.util.Scanner;

/*
 * 학생 한명의 국어, 영어, 수학 점수를 입력받아 출력하는 로직 
 */
public class ScoreTestVer1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = null;
		int[] scoreList = new int[5];
		String[] subjectList = {"국어", "영어", "수학"};
		int tot = 0;
		
		// 1. 데이터 입력
		System.out.print("학생명 : ");
		name = scan.next();
		
		for(int i=0 ; i<scoreList.length ; i++) {
			if(i<scoreList.length-2) {
				System.out.print(subjectList[i]+" 점수 : ");
				scoreList[i] = scan.nextInt();
				tot += scoreList[i];
			} else {
				scoreList[scoreList.length-2] = tot;					// 총점
				scoreList[scoreList.length-1] = tot/subjectList.length;	// 평균
				i = scoreList.length;	// for문이 종료되는 시점을 이용(break;)
			}
		}
		
		// 2. 데이터 출력 : 학생명	국어	영어	수학	총점	평균
		System.out.println("학생명\t\t국어\t\t영어\t\t수학\t\t총점\t\t평균");
		System.out.print(name+"\t\t");
		for(int score : scoreList) {
			System.out.print(score+"\t\t");
		}
		
	}

}
