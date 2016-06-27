package it.zeze.fanta.service.definition.ejb.proxy.seam;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import it.zeze.fanta.service.bean.GiocatoriMercato;
import it.zeze.fantaformazioneweb.entity.wrapper.GiocatoriWrap;

@Remote
public interface FormazioneMercatoSeamRemote {

	void initCreditiResidui(int idUtentiFormazioni, int idUtente);

	void remove(GiocatoriWrap giocatoreToRemove);

	void removeMercato(GiocatoriMercato giocatoreToRemove, BigDecimal prezzo);

	void setCreditiResidui(BigDecimal creditiResidui);

	BigDecimal getCreditiResidui();

	void setPrezzoAcquisto(BigDecimal prezzoAcquisto);

	BigDecimal getPrezzoAcquisto();

	void setListaGiocatoriMercato(List<GiocatoriMercato> listaGiocatoriMercato);

	List<GiocatoriMercato> getListaGiocatoriMercato();

	void setIdUtenteFormazioneToInit(int idUtenteFormazioneToInit);

	void setDoInitCrediti(boolean doInitCrediti);

	boolean isDoInitCrediti();

	void setDoInit(boolean doInit);

	boolean isDoInit();

	int getIdUtenteFormazioneToInit();

	void setListaGiocatori(List<GiocatoriWrap> listaGiocatori);

	List<GiocatoriWrap> getListaGiocatori();

	void add(GiocatoriWrap giocatoreToInsert);

	void addGiocatoreMercato(GiocatoriWrap giocatoreToInsert, BigDecimal prezzoAcquisto);

	void initListaGiocatori(int idUtente);

	void initListaGiocatoriMercato(int idUtente);
	
}
