package popProbeRelatedPrograms;


import java.util.List;
import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		String a ;
		int  result1;
		System.out.println("Enter a number");
		Scanner scan = new Scanner(System.in);
		a = scan.nextLine();
		int given = Integer.parseInt(a);
		for (int result =2;result <= given/2;result++){
			result1 = given%result;
			if(result1 == 0){
			System.out.println("Given number is not a prime number"); 
		}
			else  {
				System.out.println("Given number is a prime number");
		}
		}
		scan.close();
		}
	}

