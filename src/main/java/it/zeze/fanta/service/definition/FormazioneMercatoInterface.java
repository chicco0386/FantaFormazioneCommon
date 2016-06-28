package it.zeze.fanta.service.definition;

import it.zeze.fanta.service.bean.FormazioneBeanCommon;

public interface FormazioneMercatoInterface {

	FormazioneBeanCommon initListaGiocatoriMercato(FormazioneBeanCommon common, int idUtente);

	FormazioneBeanCommon initCreditiResidui(FormazioneBeanCommon common, int idUtentiFormazioni, int idUtente);

	FormazioneBeanCommon initListaGiocatori(FormazioneBeanCommon common, int idUtente);
	
}
