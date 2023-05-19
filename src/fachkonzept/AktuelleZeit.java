package fachkonzept;

import java.util.Calendar;

public class AktuelleZeit extends Uhrzeit
{
	public int liesMinuten()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MINUTE);
	}
	
	public int liesSekunden()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.SECOND);
	}

	public int liesStunden()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
}
