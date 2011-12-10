package implementations;

import interfaces.Termin;

import java.util.Date;

public class TerminImpl implements Termin {
	private final String thema;
	private final Date datum;
	private final int dauer;
	
	private TerminImpl(int dauer, Date datum, String thema){
		this.thema = thema;
		this.datum = datum;
		this.dauer = dauer;
	}
	
	public static Termin create(int dauer, Date datum, String thema){
		return new TerminImpl(dauer, datum, thema);
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Termin)) return false;
		Termin t = (Termin)o;
		return t.datum().equals(datum) && t.dauer() == dauer && t.thema().equals(thema);
	}
	
	public int HashCode(){
		int hash = 1;
		hash = hash * 17 + dauer;
		hash = hash * 31 + datum.hashCode();
		hash = hash * 13 + thema.hashCode();
		return hash;
	}

	@Override
	public String thema() {
		return this.thema;
	}

	@Override
	public int dauer() {
		return this.dauer;
	}

	@Override
	public Date datum() {
		return this.datum;
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer();
		result.append("Termin:\n");
		result.append("\tThema: "+ thema +"\n");
		result.append("\tDatum: "+ String.valueOf(dauer) +"\n");
		result.append("\tDauer: "+ datum +"\n");
		
		return result.toString();
	}
	
	
	
}
