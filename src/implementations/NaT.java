package implementations;

import interfaces.Termin;

import java.util.Date;

public class NaT implements Termin {

	@Override
	public String thema() {
		return "";
	}

	@Override
	public int dauer() {
		return -1;
	}

	@Override
	public Date datum() {
		return null;
	}
	
	public String toString(){
		return "NaT";
	}

}
