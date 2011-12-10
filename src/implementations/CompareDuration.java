package implementations;

import interfaces.Termin;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class CompareDuration.
 */
public class CompareDuration implements Comparator<Termin> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Termin t1, Termin t2) {
		return Integer.valueOf(t1.dauer()).compareTo(Integer.valueOf(t2.dauer()));
	}

}
