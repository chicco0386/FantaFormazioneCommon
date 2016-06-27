package it.zeze.fanta.service.definition;

import java.math.BigDecimal;

import it.zeze.fanta.service.bean.ServiceResponse;
import it.zeze.fantaformazioneweb.entity.UtentiFormazioni;

public interface UtentiFormazioniInterface {

	void delete(int idUtentiFormazioni, int idUtente);

	ServiceResponse insertUtenteFormazione(String nomeFormazione, int idUtente, BigDecimal crediti);

	ServiceResponse updateUtenteFormazione(int idUtentiFormazioni, String nomeFormazione, int idUtente, BigDecimal crediti);

	boolean esisteUtentiFormazioni(String nomeFormazione, int idUtente);

	boolean esisteUtentiFormazioni(int idUtenteFormazione, int idUtente);

	UtentiFormazioni getUtentiFormazioniId(String nomeFormazione, int idUtente);

	UtentiFormazioni getUtentiFormazioniByIdAndIdUtente(int idUtenteFormazione, int idUtente);

	UtentiFormazioni getUtentiFormazioni();
	
}
