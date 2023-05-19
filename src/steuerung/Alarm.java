package steuerung;

public class Alarm extends Zustand
{

	public Alarm(Steuerung pSteuerung)
	{
		super(pSteuerung);
		entry();
	}

	private void entry()
	{
		schalteEinAlarm();
	}

	private void exit()
	{
		schalteAusAlarm();
	}

	@Override
	public void ausgeloestAlarm()
	{
	}

	@Override
	public void geaendertAktuelleZeit()
	{
	}

	@Override
	public void gedruecktMode()
	{
		exit();
		dieSteuerung.setzeZustand(new AngezeigtAktuelleZeit(dieSteuerung));
	}

	@Override
	public void gedruecktSet()
	{
		exit();
		dieSteuerung.setzeZustand(new AngezeigtAktuelleZeit(dieSteuerung));
	}

	private void schalteEinAlarm()
	{
		dieSteuerung.schalteEinAlarm();
	}

	private void schalteAusAlarm()
	{
		dieSteuerung.schalteAusAlarm();
	}

}
