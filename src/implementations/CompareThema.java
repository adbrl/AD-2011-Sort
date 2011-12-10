package implementations;

import interfaces.Termin;

import java.util.Comparator;

public class CompareThema implements Comparator<Termin> {

	@Override
	public int compare(Termin t1, Termin t2) {
		return t1.thema().compareTo(t2.thema());
	}

}
