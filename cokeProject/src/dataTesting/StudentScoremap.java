package dataTesting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentScoremap {

	public static void studentScore(String studentName) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Aditya", 90);
		map.put("Aneesh", 80);
		map.put("Dhatri", 70);
		map.put("Ram", 85);
		map.put("Veda", 95);
		Integer score = map.get(studentName);
		System.out.println(studentName + " ---> " + score);

	}

	public static void main(String[] args) {

		System.out.println("Enter student name");
		Scanner scan = new Scanner(System.in);
		String giveName = scan.nextLine();
		studentScore(giveName);

	}
}
