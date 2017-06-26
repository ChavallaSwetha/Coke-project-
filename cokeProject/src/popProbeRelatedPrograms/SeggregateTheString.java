package popProbeRelatedPrograms;

import java.util.ArrayList;

public class SeggregateTheString {

	public static void main(String[] args) {
		 
		String given = "!abc3@45#edfA*BM";
		char[] arr = given.toCharArray();
		ArrayList<Character> addedarr = new ArrayList<Character>();
		ArrayList<Character> capsarr = new ArrayList<Character>();
		ArrayList<Integer> addedarrints = new ArrayList<Integer>();
		ArrayList<Character> specialchars = new ArrayList<Character>();
		
		for (int i=0; i<arr.length; i++){
			int ascii = (int)arr[i];
			if (ascii >= 97 && ascii <= 122){
				addedarr.add(arr[i]);
				}
			else if(ascii >=65 && ascii<= 90){
				capsarr.add(arr[i]);
			}
			
				else if(ascii >=48 && ascii<=57 ){
					int convert = Character.getNumericValue(arr[i]);
					addedarrints.add(convert);
				}
				else{
					specialchars.add(arr[i]);
					
				}
			
			}
	System.out.println(addedarrints);	
	System.out.println(capsarr);
	System.out.println(addedarr);
	System.out.println(specialchars);
	}}


