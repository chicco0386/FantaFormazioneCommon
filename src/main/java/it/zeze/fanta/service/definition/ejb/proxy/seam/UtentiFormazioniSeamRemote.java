package it.zeze.fanta.service.definition.ejb.proxy.seam;

import java.math.BigDecimal;

import javax.ejb.Remote;

import it.zeze.fanta.service.bean.ServiceResponse;
import it.zeze.fantaformazioneweb.entity.wrapper.UtentiFormazioniWrap;

@Remote
public interface UtentiFormazioniSeamRemote {

	void delete(int idUtentiFormazioni, int idUtente);

	ServiceResponse insertUtenteFormazione(String nomeFormazione, int idUtente, BigDecimal crediti);

	ServiceResponse updateUtenteFormazione(int idUtentiFormazioni, String nomeFormazione, int idUtente, BigDecimal crediti);

	boolean esisteUtentiFormazioni(String nomeFormazione, int idUtente);

	boolean esisteUtentiFormazioni(int idUtenteFormazione, int idUtente);

	UtentiFormazioniWrap getUtentiFormazioniId(String nomeFormazione, int idUtente);

	UtentiFormazioniWrap getUtentiFormazioniByIdAndIdUtente(int idUtenteFormazione, int idUtente);
	
}
