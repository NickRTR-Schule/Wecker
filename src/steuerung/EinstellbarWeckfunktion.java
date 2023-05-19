package steuerung;

public class EinstellbarWeckfunktion extends Zustand
{
	public EinstellbarWeckfunktion(Steuerung pSteuerung)
	{
		super(pSteuerung);
		entry();
	}

	public void ausgeloestAlarm()
	{
		exit();
		dieSteuerung.setzeZustand(new Alarm(dieSteuerung));
	}

	private void entry()
	{
		dieSteuerung.zeige('A', false, false, true);
	}

	private void exit()
	{
		dieSteuerung.zeige('A', false, false, true);
	}

	public void geaendertAktuelleZeit()
	{

	}

	public void gedruecktMode()
	{
		exit();
		dieSteuerung.setzeZustand(new AngezeigtAktuelleZeit(dieSteuerung));
	}

	public void gedruecktSet()
	{
		exit();
		if (dieSteuerung.istWeckfunktionEingeschaltet())
		{
			dieSteuerung.schalteAusWeckfunktion();
			dieSteuerung
					.setzeZustand(new EinstellbarWeckfunktion(dieSteuerung));
		}
		else
		{
			dieSteuerung.schalteEinWeckfunktion();
			dieSteuerung
					.setzeZustand(new EinstellbarWeckfunktion(dieSteuerung));
		}
	}
}