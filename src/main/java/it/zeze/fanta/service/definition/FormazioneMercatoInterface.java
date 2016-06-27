package it.zeze.fanta.service.definition;

import java.math.BigDecimal;
import java.util.List;

import it.zeze.fanta.service.bean.GiocatoriMercato;
import it.zeze.fantaformazioneweb.entity.Giocatori;

public interface FormazioneMercatoInterface {

	void initCreditiResidui(int idUtentiFormazioni, int idUtente);

	void remove(Giocatori giocatoreToRemove);

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

	void setListaGiocatori(List<Giocatori> listaGiocatori);

	List<Giocatori> getListaGiocatori();

	void add(Giocatori giocatoreToInsert);

	void addGiocatoreMercato(Giocatori giocatoreToInsert, BigDecimal prezzoAcquisto);

	void initListaGiocatori(int idUtente);

	void initListaGiocatoriMercato(int idUtente);
	
}
