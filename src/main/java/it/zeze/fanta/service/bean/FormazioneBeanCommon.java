package it.zeze.fanta.service.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import it.zeze.fantaformazioneweb.entity.Giocatori;
import it.zeze.fantaformazioneweb.entity.wrapper.GiocatoriWrap;

public class FormazioneBeanCommon implements Serializable {

	private static final long serialVersionUID = -3311063074274064944L;

	private List<GiocatoriWrap> listaGiocatori = new ArrayList<GiocatoriWrap>();
	private List<GiocatoriMercato> listaGiocatoriMercato = new ArrayList<GiocatoriMercato>();

	private boolean doInit = true;
	private boolean doInitCrediti = true;
	private int idUtenteFormazioneToInit = -1;
	private BigDecimal prezzoAcquisto = BigDecimal.ZERO;
	private BigDecimal creditiResidui = BigDecimal.ZERO;
	
	public void add(GiocatoriWrap giocatoreToInsert) {
		if (!listaGiocatori.contains(giocatoreToInsert)) {
			listaGiocatori.add(giocatoreToInsert);
		}
	}
	
	public void addGiocatoreMercato(GiocatoriWrap giocatoreToInsert, BigDecimal prezzoAcquisto) {
		if (!listaGiocatoriMercato.contains(giocatoreToInsert)) {
			GiocatoriMercato mercato = new GiocatoriMercato(giocatoreToInsert);
			mercato.setPrezzoAcquisto(prezzoAcquisto);
			listaGiocatoriMercato.add(mercato);
			creditiResidui = creditiResidui.subtract(mercato.getPrezzoAcquisto());
			this.prezzoAcquisto = BigDecimal.ZERO;
		}
	}
	
	public void removeMercato(GiocatoriMercato giocatoreToRemove, BigDecimal prezzo) {
		listaGiocatoriMercato.remove(giocatoreToRemove);
		creditiResidui = creditiResidui.add(prezzo);
	}

	public void remove(GiocatoriWrap giocatoreToRemove) {
		listaGiocatori.remove(giocatoreToRemove);
	}

	public List<GiocatoriWrap> getListaGiocatori() {
		return listaGiocatori;
	}

	public void setListaGiocatori(List<GiocatoriWrap> listaGiocatori) {
		this.listaGiocatori = listaGiocatori;
	}

	public List<GiocatoriMercato> getListaGiocatoriMercato() {
		return listaGiocatoriMercato;
	}

	public void setListaGiocatoriMercato(List<GiocatoriMercato> listaGiocatoriMercato) {
		this.listaGiocatoriMercato = listaGiocatoriMercato;
	}

	public boolean isDoInit() {
		return doInit;
	}

	public void setDoInit(boolean doInit) {
		this.doInit = doInit;
	}

	public boolean isDoInitCrediti() {
		return doInitCrediti;
	}

	public void setDoInitCrediti(boolean doInitCrediti) {
		this.doInitCrediti = doInitCrediti;
	}

	public int getIdUtenteFormazioneToInit() {
		return idUtenteFormazioneToInit;
	}

	public void setIdUtenteFormazioneToInit(int idUtenteFormazioneToInit) {
		this.idUtenteFormazioneToInit = idUtenteFormazioneToInit;
	}

	public BigDecimal getPrezzoAcquisto() {
		return prezzoAcquisto;
	}

	public void setPrezzoAcquisto(BigDecimal prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}

	public BigDecimal getCreditiResidui() {
		return creditiResidui;
	}

	public void setCreditiResidui(BigDecimal creditiResidui) {
		this.creditiResidui = creditiResidui;
	}
	
	public List<Giocatori> convertListaGiocatori() {
		List<Giocatori> listaGiocatoriToReturn = new ArrayList<Giocatori>();
		for (GiocatoriWrap current : listaGiocatori){
			listaGiocatoriToReturn.add(current.unwrap());
		}
		return listaGiocatoriToReturn;
	}

}
