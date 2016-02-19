package it.zeze.fanta.service.definition;

import it.zeze.fantaformazioneweb.entity.Giornate;

public interface CalendarioInterface {
	
	public Giornate getGiornate();

	public void inizializzaCalendario();
}
