package it.zeze.fanta.service.definition;

import it.zeze.fantaformazioneweb.entity.ProbabiliFormazioniGazzetta;

public interface FormazioniGazzettaInterface {

	void unmarshallAndSaveFromHtmlFile(String stagione);

	ProbabiliFormazioniGazzetta selectByIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);

}
