package implementations;

import interfaces.Termin;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class NaT.
 */
public class NaT implements Termin {

	/* (non-Javadoc)
	 * @see interfaces.Termin#thema()
	 */
	@Override
	public String thema() {
		return "";
	}

	/* (non-Javadoc)
	 * @see interfaces.Termin#dauer()
	 */
	@Override
	public int dauer() {
		return -1;
	}

	/* (non-Javadoc)
	 * @see interfaces.Termin#datum()
	 */
	@Override
	public Date datum() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "NaT";
	}

}
