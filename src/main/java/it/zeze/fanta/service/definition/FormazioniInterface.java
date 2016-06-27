package it.zeze.fanta.service.definition;

import java.math.BigDecimal;
import java.util.List;

import it.zeze.fanta.service.bean.GiocatoriMercato;
import it.zeze.fanta.service.bean.ServiceResponse;
import it.zeze.fantaformazioneweb.entity.Formazioni;
import it.zeze.fantaformazioneweb.entity.Giocatori;

public interface FormazioniInterface {
	
	ServiceResponse insertFormazione(String nomeFormazione, List<Giocatori> listaGiocatori, int idUtente, int idUtenteFormazioneToUpdate);

	ServiceResponse insertFormazioneMercato(String nomeFormazione, List<GiocatoriMercato> listaGiocatori, int idUtente, int idUtenteFormazioneToUpdate, BigDecimal crediti);

	ServiceResponse calcolaFormazione(int idUtentiFormazioni, String stagioneDaCalcolare, int numeroGiornataDaCalcolare);

	List<Formazioni> selectFormazioniByIdUtenteFormazioni(int idUtentiFormazioni);

	void deleteGiocatoreByIdFormazione(int idUtentiFormazioni);
}
