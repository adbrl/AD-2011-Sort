package implementations;

import interfaces.Termin;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class CompareThema.
 */
public class CompareThema implements Comparator<Termin> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Termin t1, Termin t2) {
		return t1.thema().compareTo(t2.thema());
	}

}
