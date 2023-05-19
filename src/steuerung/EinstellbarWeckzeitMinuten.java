package steuerung;

public class EinstellbarWeckzeitMinuten extends Zustand
{

	public EinstellbarWeckzeitMinuten(Steuerung pSteuerung)
	{
		super(pSteuerung);
		entry();
	}

	private void entry()
	{
		zeigeVerstellbarMinuten();
	}

	private void exit()
	{
		zeigeNichtVerstellbarMinuten();
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
		dieSteuerung.setzeZustand(new EinstellbarWeckfunktion(dieSteuerung));
	}

	@Override
	public void gedruecktSet()
	{
		dieSteuerung.inkrementiereWeckzeitMinuten();
		dieSteuerung.setzeZustand(new EinstellbarWeckzeitMinuten(dieSteuerung));
	}

	private void zeigeVerstellbarMinuten()
	{
		dieSteuerung.zeige('W', false, true, false);
	}

	private void zeigeNichtVerstellbarMinuten()
	{
		dieSteuerung.zeige('W', false, true, false);
	}

}
