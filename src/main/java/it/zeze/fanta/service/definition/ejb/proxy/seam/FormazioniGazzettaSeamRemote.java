package it.zeze.fanta.service.definition.ejb.proxy.seam;

import javax.ejb.Remote;

import it.zeze.fantaformazioneweb.entity.ProbabiliFormazioniGazzetta;

@Remote
public interface FormazioniGazzettaSeamRemote {

	void unmarshallAndSaveFromHtmlFile(String stagione);

	ProbabiliFormazioniGazzetta selectByIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);

}
