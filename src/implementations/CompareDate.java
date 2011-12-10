package implementations;

import interfaces.Termin;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class CompareDate.
 */
public class CompareDate implements Comparator<Termin>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Termin t1, Termin t2) {
		return t1.datum().compareTo(t2.datum());
	}

}
