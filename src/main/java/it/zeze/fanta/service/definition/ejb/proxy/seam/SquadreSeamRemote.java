package it.zeze.fanta.service.definition.ejb.proxy.seam;

import javax.ejb.Remote;

import it.zeze.fantaformazioneweb.entity.Squadre;

@Remote
public interface SquadreSeamRemote {

	void unmarshallAndSaveFromHtmlFile();

	void initMappaSquadre();

	Squadre getSquadraFromMapByNome(String nomeSquadraToSearch);

	Squadre getSquadraByNome(String nomeSquadraToSearch);

	Squadre getSquadraById(int idSquadra);

}
