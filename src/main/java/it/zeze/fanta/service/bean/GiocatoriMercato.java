package it.zeze.fanta.service.bean;

import java.math.BigDecimal;

import it.zeze.fantaformazioneweb.entity.Giocatori;
import it.zeze.fantaformazioneweb.entity.wrapper.GiocatoriWrap;

public class GiocatoriMercato extends GiocatoriWrap {

	private static final long serialVersionUID = 1101479238353653114L;
	
	private BigDecimal prezzoAcquisto;

	public GiocatoriMercato() {
		super();
	}
	
	public GiocatoriMercato(Giocatori giocatore) {
		super(giocatore);
	}

	public GiocatoriMercato(GiocatoriWrap giocatore) {
		super();
		this.setId(giocatore.getId());
		this.setSquadre(giocatore.getSquadre());
		this.setNome(giocatore.getNome());
		this.setRuolo(giocatore.getRuolo());
		this.setStagione(giocatore.getStagione());
		this.setQuotazIniziale(giocatore.getQuotazIniziale());
		this.setQuotazAttuale(giocatore.getQuotazAttuale());
	}

	public BigDecimal getPrezzoAcquisto() {
		return prezzoAcquisto;
	}

	public void setPrezzoAcquisto(BigDecimal prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}

	@Override
	public boolean equals(Object o) {
		boolean equals = false;
		if (o instanceof GiocatoriMercato) {
			GiocatoriMercato giocatoreToCompare = (GiocatoriMercato) o;
			if (giocatoreToCompare.getId() == getId()) {
				equals = true;
			}
		}
		return equals;
	}

}
