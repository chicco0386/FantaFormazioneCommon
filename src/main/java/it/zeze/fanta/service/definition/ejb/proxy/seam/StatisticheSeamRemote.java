package it.zeze.fanta.service.definition.ejb.proxy.seam;

import java.util.List;

import javax.ejb.Remote;

import it.zeze.fantaformazioneweb.entity.Giocatori;
import it.zeze.fantaformazioneweb.entity.Giornate;
import it.zeze.fantaformazioneweb.entity.Statistiche;
import it.zeze.fantaformazioneweb.entity.wrapper.StatisticheWrap;

@Remote
public interface StatisticheSeamRemote {

	void unmarshallAndSaveFromHtmlFile(String stagione);

	StatisticheWrap getStatisticheIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);
	
	public List<StatisticheWrap> initResultList(Giornate giornate, Giocatori giocatori, String orderColumn, String orderDir);
	
	public List<StatisticheWrap> resetResumeStatistiche(List<Statistiche> resultList, Giornate giornate, Giocatori giocatori, String orderColumn, String orderDir);

}
