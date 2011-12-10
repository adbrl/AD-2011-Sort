package implementations;

import interfaces.Termin;

import java.util.Comparator;

public class CompareDuration implements Comparator<Termin> {

	@Override
	public int compare(Termin t1, Termin t2) {
		return Integer.valueOf(t1.dauer()).compareTo(Integer.valueOf(t2.dauer()));
	}

}
