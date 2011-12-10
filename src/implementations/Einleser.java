package implementations;

import interfaces.Termin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;



public class Einleser {
	public static final String TRENNER = "\\|\\|";
	BufferedReader reader;
	private Map<String, Integer> accessMap = new HashMap<String, Integer>();
	private List<String> parsedList = new ArrayList<String>();
	
	
	
	public Einleser(String pfad){
		try {
			this.reader = new BufferedReader(new FileReader(pfad));
		} catch (IOException e) {
			e.printStackTrace();
		}
		zeilen();
	}
	
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
		return (Termin[]) result.toArray();
		
	}
	
	public static void main(String args[]) throws ParseException{
		Einleser e = new Einleser("testFiles/input.txt");
		System.out.println(e.parsedList);
		System.out.println(e.parsedList.size());
		Termin[] t = e.termine();
		for(Termin elem : t){
			elem.toString();
			System.out.println("\n");
		}
	}
	
	

}
