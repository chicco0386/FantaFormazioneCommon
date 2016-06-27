package it.zeze.util;

import java.util.Comparator;

import it.zeze.fanta.service.bean.GiocatoriMercato;
import it.zeze.fantaformazioneweb.entity.Giocatori;
import it.zeze.fantaformazioneweb.entity.wrapper.GiocatoriWrap;

public class GiocatoriComparator<T> implements Comparator<T> {

	public int compare(GiocatoriMercato o1, GiocatoriMercato o2) {
		String nomeG1 = o1.getNome();
		String nomeG2 = o2.getNome();
		String ruoloG1 = o1.getRuolo();
		String ruoloG2 = o2.getRuolo();
		return ruoloG1.compareToIgnoreCase(ruoloG2);
	}

	public int compare(T g1, T g2) {
		Giocatori o1 = convertToGiocatori(g1);
		Giocatori o2 = convertToGiocatori(g2);
		String nomeG1 = o1.getNome();
		String nomeG2 = o2.getNome();
		String ruoloG1 = o1.getRuolo();
		String ruoloG2 = o2.getRuolo();
		return ruoloG1.compareToIgnoreCase(ruoloG2);
	}

	private Giocatori convertToGiocatori(T o){
		if (o instanceof Giocatori){
			return (Giocatori) o;
		} else if (o instanceof GiocatoriMercato){
			return ((GiocatoriWrap) o).unwrap();
		}
		return null;
	}
}
