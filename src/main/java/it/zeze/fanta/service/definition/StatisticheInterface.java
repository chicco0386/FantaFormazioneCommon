package it.zeze.fanta.service.definition;

import java.util.List;

import it.zeze.fantaformazioneweb.entity.Giocatori;
import it.zeze.fantaformazioneweb.entity.Giornate;
import it.zeze.fantaformazioneweb.entity.Statistiche;

public interface StatisticheInterface {
	
	public void unmarshallAndSaveFromHtmlFile(String stagione);

	Statistiche getStatisticheIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);
	
	List<Statistiche> initResultList(Giornate giornate, Giocatori giocatori, String orderColumn, String orderDir);
	
	List<Statistiche> resetResumeStatistiche(List<Statistiche> resultList, Giornate giornate, Giocatori giocatori, String orderColumn, String orderDir);
}
