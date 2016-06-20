package it.zeze.fanta.service.definition;

import it.zeze.fantaformazioneweb.entity.ProbabiliFormazioniFg;

public interface FormazioniFGInterface {

	public void unmarshallAndSaveFromHtmlFile(String stagione);

	ProbabiliFormazioniFg selectByIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);

}
