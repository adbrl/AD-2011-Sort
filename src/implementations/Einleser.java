package implementations;

import interfaces.Termin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class Einleser {
	

	public static final String TRENNER = "\\|\\|";
	
	private BufferedReader reader;
	
	//accessMap to access Thema, Date and Dauer in each line no matter in what order they are
	private Map<String, Integer> accessMap = new HashMap<String, Integer>();
	
	//holds the inputFile lines
	private List<String> parsedList = new ArrayList<String>();
	

	/**
	 * Instantiates a new einleser.
	 *
	 * @param pfad the path of the inputFile
	 */
	public Einleser(String pfad){
		try {
			this.reader = new BufferedReader(new FileReader(pfad));
		} catch (IOException e) {
			e.printStackTrace();
		}
		zeilen();
	}

	/**
	 * Adds each line of the input file to a ArrayList
	 */
	private void zeilen(){
		String zeile = null;
		
		try {
			while ((zeile = reader.readLine()) != null) {
				String tmp = zeile.replaceAll("\\s\\|\\|\\s", "\\|\\|");
				parsedList.add(tmp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Termine
	 * 
	 * creates a Array of TermineObjects. Each Object is built from one line of the input file
	 *
	 * @return the termin[]-Array
	 * @throws ParseException the parse exception
	 */
	public Termin[] termine() throws ParseException{
		List<Termin> result = new ArrayList<Termin>();
		String firstLine = parsedList.get(0);
		
		System.out.println(firstLine);
		
		String[] init = firstLine.split(TRENNER);
		
		int count = 0;
		for(String elem : init){
			System.out.println(elem);
			accessMap.put(elem, count++);
		}
		parsedList.remove(0);
		
		System.out.println(accessMap);
		
		DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
		
		for(String elem : parsedList){
			String[] line = elem.split(TRENNER);

			Termin t = TerminImpl.create(Integer.parseInt(line[accessMap.get("Dauer")]),
										 dateFormat.parse(line[accessMap.get("DatumZeit")]),
										 line[accessMap.get("Thema")]);
			result.add(t);
		}
		return (Termin[]) result.toArray(new Termin[0]);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParseException the parse exception
	 */
	public static void main(String args[]) throws ParseException{
		Einleser e = new Einleser("testFiles/input.txt");
		CompareThema com1 = new CompareThema();
		CompareDate com2 = new CompareDate();
		CompareDuration com3 = new CompareDuration();
		
		System.out.println(e.parsedList);
		System.out.println(e.parsedList.size());
		
		Termin[] t = e.termine();
		for(Termin elem : t){
			System.out.println(elem.toString());
			System.out.println("\n");
		}
		
		System.out.println("Sort by Thema!----------------------------\n");
		Arrays.sort(t, com2);
		
		for(Termin elem : t){
			System.out.println(elem.toString());
			System.out.println("\n");
		}
		
		System.out.println("Sort by Date!----------------------------\n");
		Arrays.sort(t, com1);
		
		for(Termin elem : t){
			System.out.println(elem.toString());
			System.out.println("\n");
		}
	}
	
	

}
