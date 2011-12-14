package implementations;

import interfaces.Termin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
	public Date datum(){
		//1. Januar 1970 00:00 Uhr UTC
		Date result = null;
		DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.UK);
		try {
			result = df.parse("Thu Jan 01 00:00:00 UTC 1970");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "NaT";
	}

}
