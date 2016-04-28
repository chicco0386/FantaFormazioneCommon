package it.zeze.fanta.service.definition;

import it.zeze.fantaformazioneweb.entity.Giocatori;

public interface GiocatoriInterface {
	public void unmarshallAndSaveFromHtmlFile(String stagione, boolean noLike);
	public void unmarshallAndSaveFromHtmlFileForUpdateStagione(boolean noLike);
	public Giocatori getGiocatoreByNomeSquadraRuolo(String nomeGiocatore, String squadra, String ruolo, String stagione, boolean noLike);
	void insertOrUpdateGiocatore(String nomeSquadra, String nomeGiocatore, String ruolo, String stagione, boolean noLike);
	Giocatori getGiocatoreByNomeSquadra(String nomeGiocatore, String squadra, String stagione, boolean noLike);
}
