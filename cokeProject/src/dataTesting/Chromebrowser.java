package dataTesting;


import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;





public class Chromebrowser {
	
	public static void passByReference(String[] a){
		 a[0] =  "changed";
	}

	
	public static void main(String[] args)  {
	String[] b = new String[1];	
	b[0] ="before changing";
	System.out.println(b[0]);
	Chromebrowser.passByReference(b);
	System.out.println(b[0]);
	
		
	/*static String dateandTime = dataAndTime();
	public static String dataAndTime() {
			DateFormat df = new SimpleDateFormat("MM/dd/YYYY  HH:MM");
			Date dt = new Date();
			String time = df.format(dt);
			return time;
		
		}*/
		
		
		
		
	}
	}


