package it.zeze.util;

import java.util.Comparator;

import it.zeze.fanta.service.bean.GiocatoriMercato;
import it.zeze.fantaformazioneweb.entity.Giocatori;
import it.zeze.fantaformazioneweb.entity.wrapper.GiocatoriWrap;

public class GiocatoriComparator<T> implements Comparator<T> {
	
	public int compare(Giocatori o1, Giocatori o2) {
		String nomeG1 = o1.getNome();
		String nomeG2 = o2.getNome();
		String ruoloG1 = o1.getRuolo();
		String ruoloG2 = o2.getRuolo();
		return ruoloG1.compareToIgnoreCase(ruoloG2);
	}

	public int compare(GiocatoriMercato o1, GiocatoriMercato o2) {
		String nomeG1 = o1.getNome();
		String nomeG2 = o2.getNome();
		String ruoloG1 = o1.getRuolo();
		String ruoloG2 = o2.getRuolo();
		return ruoloG1.compareToIgnoreCase(ruoloG2);
	}

	public int compare(T g1, T g2) {
		String ruoloG1 = "";
		String ruoloG2 = "";
		GiocatoriWrap o1 = convertToGiocatoriWrap(g1);
		GiocatoriWrap o2 = convertToGiocatoriWrap(g2);
		if (o1 != null && o2 != null){
			ruoloG1 = o1.getRuolo();
			ruoloG2 = o2.getRuolo();
		}
		else {
			Giocatori o3 = convertToGiocatori(g1);
			Giocatori o4 = convertToGiocatori(g2);
			if (o3 != null && o4 != null){
				ruoloG1 = o3.getRuolo();
				ruoloG2 = o4.getRuolo();
			}
		}
		return ruoloG1.compareToIgnoreCase(ruoloG2);
	}
	
	private GiocatoriWrap convertToGiocatoriWrap(T o){
		if (o instanceof GiocatoriWrap){
			return (GiocatoriWrap) o;
		} else if (o instanceof GiocatoriMercato){
			return ((GiocatoriWrap) o);
		}
		return null;
	}
	
	private Giocatori convertToGiocatori(T o){
		if (o instanceof Giocatori){
			return (Giocatori) o;
		}
		return null;
	}
}
