package implementations;

import interfaces.Termin;

import java.util.Comparator;

public class CompareDate implements Comparator<Termin>{

	@Override
	public int compare(Termin t1, Termin t2) {
		return t1.datum().compareTo(t2.datum());
	}

}
