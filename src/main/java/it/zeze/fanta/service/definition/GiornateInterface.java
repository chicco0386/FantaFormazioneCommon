package it.zeze.fanta.service.definition;

import java.util.List;

import it.zeze.fanta.service.bean.SelectItem;
import it.zeze.fantaformazioneweb.entity.Giornate;

public interface GiornateInterface {
	
	public void unmarshallAndSaveFromHtmlFile(String stagione);
	
	public String getStagione(String stagioneInput);
	
	public int getIdGiornata(int numeroGiornata, String stagione);
	
	public Giornate getGiornataById(int idGiornata);
	
	public int getIdGiornata(String dataString);
	
	public Giornate getGiornata(String dataString);
	
	public Giornate getLastGiornata();
	
	public List<Giornate> getGiornateByStagione(String stagione);
	
	public List<Giornate> getGiornateAll(String stagione);
	
	public List<SelectItem> getStagioniAll();
}
