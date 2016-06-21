package it.zeze.fanta.service.definition.ejb.proxy.seam;

import javax.ejb.Remote;

import it.zeze.fantaformazioneweb.entity.Statistiche;

@Remote
public interface StatisticheSeamRemote {

	void unmarshallAndSaveFromHtmlFile(String stagione);

	Statistiche getStatisticheIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);

}
