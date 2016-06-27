package it.zeze.fanta.service.definition;

import java.util.List;

import it.zeze.fantaformazioneweb.entity.ProbabiliFormazioni;

public interface ProbabiliFormazioniInterface {

	boolean isGazzettaSource(int probabilita);

	boolean isFantaGazzettaSource(int probabilita);

	void insertProbFormazione(int idGiornata, int idUtentiFormazione, int idGiocatore, int probTit, int probPanc, String note);

	void deleteProbFormazioniByUtentiFormazione(int idUtentiFormazione);

	void deleteProbFormazioniByGiornataUtentiFormazione(int idGiornata, int idUtentiFormazione);

	List<ProbabiliFormazioni> getProbFormazioniByGiornataUtentiFormazione(int idGiornata, int idUtentiFormazione);

	List<ProbabiliFormazioni> getRisultati(int idUtentiFormazione, String stagione, int numeroGiornata);
	
}