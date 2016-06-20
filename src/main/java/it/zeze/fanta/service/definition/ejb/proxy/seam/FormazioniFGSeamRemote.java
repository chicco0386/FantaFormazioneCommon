package it.zeze.fanta.service.definition.ejb.proxy.seam;

import javax.ejb.Remote;

import it.zeze.fantaformazioneweb.entity.ProbabiliFormazioniFg;

@Remote
public interface FormazioniFGSeamRemote {

	void unmarshallAndSaveFromHtmlFile(String stagione);

	ProbabiliFormazioniFg selectByIdGiocatoreIdGiornata(int idGiocatore, int idGiornata);

}
