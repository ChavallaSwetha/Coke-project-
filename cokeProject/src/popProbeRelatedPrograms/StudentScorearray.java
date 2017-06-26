package popProbeRelatedPrograms;

import java.util.Scanner;

public class StudentScorearray {
	static String[] stud = new String[5];
	static String[] score = {"90%","80%","75%","70%","85%"};
	
	
	public static  String[] setFillArray(String[] stud){
		for (int i=0;i<5;i++){
			System.out.println("Enter student name");
			Scanner scan = new Scanner(System.in);
			String student = scan.nextLine();
		     stud[i] = student;
		}
		return stud;
	}
	
	public static String getFilledArray(){
		System.out.println("Enter student name");
		Scanner scan = new Scanner(System.in);
		String giveStudentName = scan.nextLine();
		
		for (int i=0;i<5;i++){
			if (giveStudentName.equals(stud[i])){
				giveStudentName = stud[i];
			}
		}
		System.out.println(giveStudentName);
		return giveStudentName;
	}

	/*public static void scoreOfTheStudent(String[] name) {
		for (int i = 0; i <5; i++) {
			if (name.equals(stud[i])) {
				System.out.println("Student name:" + "   " + stud[i]);
				System.out.println("Scored:" + "   " + score[i]);
			}
		}
	}*/

	public static void main(String[] args) {
		
		setFillArray(stud);
		getFilledArray();
		//scoreOfTheStudent(name);
	}
}
