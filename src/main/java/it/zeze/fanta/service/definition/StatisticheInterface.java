package it.zeze.fanta.service.definition;

import it.zeze.fantaformazioneweb.entity.Statistiche;

public interface StatisticheInterface {
	
	public void unmarshallAndSaveFromHtmlFile(String stagione);

	Statistiche getStatisticheIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);
}
