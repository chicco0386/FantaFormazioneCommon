package it.zeze.fanta.service.definition;

import it.zeze.fantaformazioneweb.entity.Squadre;

public interface SquadreInterface {

	public void unmarshallAndSaveFromHtmlFile();

	public void initMappaSquadre();

	public Squadre getSquadraFromMapByNome(String nomeSquadraToSearch);

	public Squadre getSquadraByNome(String nomeSquadraToSearch);

	public Squadre getSquadraById(int idSquadra);
}
