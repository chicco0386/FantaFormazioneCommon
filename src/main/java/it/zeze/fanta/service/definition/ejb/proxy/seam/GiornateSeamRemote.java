package it.zeze.fanta.service.definition.ejb.proxy.seam;

import java.util.List;

import javax.ejb.Remote;

import it.zeze.fanta.service.bean.SelectItem;
import it.zeze.fantaformazioneweb.entity.Giornate;

@Remote
public interface GiornateSeamRemote {

	void unmarshallAndSaveFromHtmlFile(String stagione);

	String getStagione(String stagioneInput);

	int getIdGiornata(int numeroGiornata, String stagione);

	Giornate getGiornataById(int idGiornata);

	int getIdGiornata(String dataString);

	Giornate getGiornata(String dataString);

	Giornate getLastGiornata();

	List<Giornate> getGiornateByStagione(String stagione);

	List<Giornate> getGiornateAll(String stagione);

	List<SelectItem> getStagioniAll();

}
