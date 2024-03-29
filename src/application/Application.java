/**
 * 
 */
package application;

import implementations.CompareDate;
import implementations.CompareDuration;
import implementations.CompareThema;
import implementations.Einleser;
import interfaces.Termin;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author adbrl
 *
 */
public class Application {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
		System.out.print("Please enter path to input file (no entry = default): ");
		
		BufferedReader bure = new BufferedReader(new InputStreamReader(System.in));
		
		String input = null;
		
		try {
	         input = bure.readLine();
	      } catch (IOException ioe){
	         System.out.println("IO error trying to read your order!");
	         System.exit(1);
	      }
		
		Einleser e;
		
		if(input.equals("")){
			e = new Einleser("testFiles/test1.txt");
		}else{
			e = new Einleser(input);
		}
		
		
		List<Integer> orders = new ArrayList<Integer>();
		
		Comparator<Termin> com1 = new CompareThema();
		Comparator<Termin> com2 = new CompareDate();
		Comparator<Termin> com3 = new CompareDuration();
		
		Map<Integer, Comparator<Termin>> comMap = new HashMap<Integer, Comparator<Termin>>();
		
		comMap.put(1, com1);
		comMap.put(2, com2);
		comMap.put(3, com3);
		
		Termin[] t = e.termine();
		
		while(true){
			System.out.print("Enter the sorting order <1,2,3>, <3,1,2> etc. where 1=Subject, 2=Date, 3=Duration or exit: ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String order = null;
			
			try {
		         order = br.readLine();
		      } catch (IOException ioe){
		         System.out.println("IO error trying to read your order!");
		         System.exit(1);
		      }
		      
		    orders = getOrder(order);  //dreht Liste um
		    sortBy(orders, t, comMap);
		}
		
	}
	
	private static void sortBy(List<Integer> list, Termin[] t, Map<Integer, Comparator<Termin>> comMap){
		for(Integer elem : list){
			Arrays.sort(t, comMap.get(elem));
		}
		
		System.out.println("Sorted: ------------------------------------------------------------------");
		for(Termin elem : t){
			System.out.println(elem);
		}
		System.out.println("Sorted: ------------------------------------------------------------------\n");
		
	}
	
	private static List<Integer> getOrder(String o){
		List<Integer> result = new ArrayList<Integer>();
		
		if(o.equals("exit")){
			System.out.println("Exited");
			System.exit(0);
		}
		
		String[] splitted = o.split(",");
		int len = splitted.length - 1;
		
		while(len >= 0){
			result.add(Integer.valueOf(splitted[len]));
			len--;
		}
		return result;
	}

}
