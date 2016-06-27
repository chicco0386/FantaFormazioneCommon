package it.zeze.fanta.service.definition.ejb.proxy.seam;

import java.util.List;

import javax.ejb.Remote;

import it.zeze.fantaformazioneweb.entity.wrapper.ProbabiliFormazioniWrap;

@Remote
public interface ProbabiliFormazioniSeamRemote {

	boolean isGazzettaSource(int probabilita);

	boolean isFantaGazzettaSource(int probabilita);

	void setResultList(List<ProbabiliFormazioniWrap> resultList);

	void insertProbFormazione(int idGiornata, int idUtentiFormazione, int idGiocatore, int probTit, int probPanc, String note);

	void deleteProbFormazioniByUtentiFormazione(int idUtentiFormazione);

	void deleteProbFormazioniByGiornataUtentiFormazione(int idGiornata, int idUtentiFormazione);

	List<ProbabiliFormazioniWrap> getProbFormazioniByGiornataUtentiFormazione(int idGiornata, int idUtentiFormazione);

	List<ProbabiliFormazioniWrap> getRisultati(int idUtentiFormazione, String stagione, int numeroGiornata);

	List<ProbabiliFormazioniWrap> getResultList();
	
}