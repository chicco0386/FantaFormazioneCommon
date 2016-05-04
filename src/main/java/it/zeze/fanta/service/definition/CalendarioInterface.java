package it.zeze.fanta.service.definition;

import org.htmlcleaner.TagNode;

import it.zeze.fantaformazioneweb.entity.Calendario;
import it.zeze.fantaformazioneweb.entity.Giornate;

public interface CalendarioInterface {
	
	public Giornate getGiornate();

	public void inizializzaCalendario(String stagione);
	
	public void unmarshallAndSaveFromNodeCalendario(int idGiornata, TagNode calendarNode);
	
	public Calendario getCalendarioByIdGiornataIdSquadra(int idGiornata, int idSquadra);
	
	public String getNomeSquadraAvversaria(int idGiornata, int idSquadra);
	
	public boolean isSquadraFuoriCasa(int idGiornata, int idSquadra);
}
