package implementations;

import interfaces.Termin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Einleser {
	public static final String TRENNER = "||";
	BufferedReader reader;
	int THEMA = 0;
	int DATUM = 1;
	int DAUER = 2;
	
	public Einleser(String pfad){
		try {
			this.reader = new BufferedReader(new FileReader(pfad));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<String> zeilen(){
		List<String> result = new ArrayList<String>();
		String zeile = null;
		
		try {
			while ((zeile = reader.readLine()) != null) {
				result.add(zeile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Termin[] termine(){
		List<Termin> result = new ArrayList<Termin>();
		String firstLine = this.zeilen().get(0);
		String[] init = firstLine.split(TRENNER);
		
		
		for(String elem : this.zeilen()){
			elem.split(TRENNER);
			
		}
	}
	
	public static void main(String args[]){
		Einleser e = new Einleser("C:\\Users\\Sebastian\\Desktop\\test.txt");
		System.out.println(e.zeilen());
	}
	
	

}
