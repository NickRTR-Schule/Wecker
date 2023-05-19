package steuerung;

public class EinstellbarWeckzeitStunden extends Zustand
{

	public EinstellbarWeckzeitStunden(Steuerung pSteuerung)
	{
		super(pSteuerung);
		entry();
	}

	private void entry()
	{
		zeigeVerstellbarStunden();
	}

	private void exit()
	{
		zeigeNichtVerstellbarStunden();
	}

	@Override
	public void ausgeloestAlarm()
	{
		exit();
		dieSteuerung.setzeZustand(new Alarm(dieSteuerung));
	}

	@Override
	public void geaendertAktuelleZeit()
	{
	}

	@Override
	public void gedruecktMode()
	{
		exit();
		dieSteuerung.setzeZustand(new EinstellbarWeckzeitMinuten(dieSteuerung));
	}

	@Override
	public void gedruecktSet()
	{
		dieSteuerung.inkrementiereWeckzeitStunden();
		dieSteuerung.setzeZustand(new EinstellbarWeckzeitStunden(dieSteuerung));
	}

	private void zeigeVerstellbarStunden()
	{
		dieSteuerung.zeige('W', true, false, false);
	}

	private void zeigeNichtVerstellbarStunden()
	{
		dieSteuerung.zeige('W', true, false, false);
	}
}
