package it.zeze.fanta.service.definition.ejb.proxy.seam;

import javax.ejb.Remote;

import org.htmlcleaner.TagNode;

import it.zeze.fantaformazioneweb.entity.Calendario;
import it.zeze.fantaformazioneweb.entity.wrapper.GiornateWrap;

@Remote
public interface CalendarioSeamRemote {

	void inizializzaCalendario(String stagione);

	String getNomeSquadraAvversaria(int idGiornata, int idSquadra);

	boolean isSquadraFuoriCasa(int idGiornata, int idSquadra);

	Calendario getCalendarioByIdGiornataIdSquadra(int idGiornata, int idSquadra);

	void unmarshallAndSaveFromNodeCalendario(int idGiornata, TagNode calendarNode);

	GiornateWrap getGiornate();

}
