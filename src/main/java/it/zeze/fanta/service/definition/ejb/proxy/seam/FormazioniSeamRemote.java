package it.zeze.fanta.service.definition.ejb.proxy.seam;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import it.zeze.fanta.service.bean.GiocatoriMercato;
import it.zeze.fanta.service.bean.ServiceResponse;
import it.zeze.fantaformazioneweb.entity.Giocatori;
import it.zeze.fantaformazioneweb.entity.wrapper.FormazioniWrap;
import it.zeze.fantaformazioneweb.entity.wrapper.GiocatoriWrap;

@Remote
public interface FormazioniSeamRemote {
	
	ServiceResponse insertFormazione(String nomeFormazione, List<GiocatoriWrap> listaGiocatori, int idUtente, int idUtenteFormazioneToUpdate);

	ServiceResponse insertFormazioneMercato(String nomeFormazione, List<GiocatoriMercato> listaGiocatori, int idUtente, int idUtenteFormazioneToUpdate, BigDecimal crediti);

	ServiceResponse calcolaFormazione(int idUtentiFormazioni, String stagioneDaCalcolare, int numeroGiornataDaCalcolare);

	List<FormazioniWrap> selectFormazioniByIdUtenteFormazioni(int idUtentiFormazioni);

	void deleteGiocatoreByIdFormazione(int idUtentiFormazioni);
}
