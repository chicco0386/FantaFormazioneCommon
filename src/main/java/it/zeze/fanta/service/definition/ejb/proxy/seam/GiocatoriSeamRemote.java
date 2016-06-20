package it.zeze.fanta.service.definition.ejb.proxy.seam;

import javax.ejb.Remote;

import it.zeze.fantaformazioneweb.entity.wrapper.GiocatoriWrap;

@Remote
public interface GiocatoriSeamRemote {

	public void unmarshallAndSaveFromHtmlFile(String stagione, boolean noLike);

	public void unmarshallAndSaveFromHtmlFileForUpdateStagione(boolean noLike);

	public GiocatoriWrap getGiocatoreByNomeSquadraRuolo(String nomeGiocatore, String squadra, String ruolo, String stagione, boolean noLike);

	public void insertOrUpdateGiocatore(String nomeSquadra, String nomeGiocatore, String ruolo, String stagione, boolean noLike);

	public GiocatoriWrap getGiocatoreByNomeSquadra(String nomeGiocatore, String squadra, String stagione, boolean noLike);

	public GiocatoriWrap getGiocatoreById(int idGiocatore);

}
