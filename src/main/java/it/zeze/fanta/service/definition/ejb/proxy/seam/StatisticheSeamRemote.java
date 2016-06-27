package it.zeze.fanta.service.definition.ejb.proxy.seam;

import javax.ejb.Remote;

import it.zeze.fantaformazioneweb.entity.wrapper.StatisticheWrap;

@Remote
public interface StatisticheSeamRemote {

	void unmarshallAndSaveFromHtmlFile(String stagione);

	StatisticheWrap getStatisticheIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);

}
