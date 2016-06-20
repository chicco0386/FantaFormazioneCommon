package it.zeze.fanta.ejb.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.zeze.fanta.service.definition.ejb.GiocatoriRemote;
import it.zeze.fanta.service.definition.ejb.proxy.seam.CalendarioSeamRemote;
import it.zeze.fanta.service.definition.ejb.proxy.seam.FormazioniFGSeamRemote;
import it.zeze.fanta.service.definition.ejb.proxy.seam.FormazioniGazzettaSeamRemote;
import it.zeze.fanta.service.definition.ejb.proxy.seam.GiocatoriSeamRemote;
import it.zeze.fanta.service.definition.ejb.proxy.seam.GiornateSeamRemote;
import it.zeze.fanta.service.definition.ejb.proxy.seam.SquadreSeamRemote;
import it.zeze.fanta.service.definition.ejb.proxy.seam.StatisticheSeamRemote;

public class JNDIUtils {

	private static InitialContext ic = null;

	static {
		try {
			// Get the Initial Context for the JNDI lookup for a local EJB
			ic = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static <T> T lookupEjb(String ejbName, Class<T> ejbInterface) throws NamingException {
		// Retrieve the Home interface using JNDI lookup
		return (T) ic.lookup("java:global/FantaFormazioneEAR/FantaWebService-0.0.1-SNAPSHOT/" + ejbName + "!" + ejbInterface.getName());
	}

	public static <T> T getCalendarioEJB() throws NamingException {
		return (T) lookupEjb("CalendarioSeamEJB", CalendarioSeamRemote.class);
	}
	
	public static <T> T getGiornateEJB() throws NamingException {
		return (T) lookupEjb("GiornateSeamEJB", GiornateSeamRemote.class);
	}
	
	public static <T> T getGiocatoriEJB() throws NamingException {
		return (T) lookupEjb("GiocatoriSeamEJB", GiocatoriRemote.class);
	}
	
	public static <T> T getGiocatoriSeamEJB() throws NamingException {
		return (T) lookupEjb("GiocatoriSeamEJB", GiocatoriSeamRemote.class);
	}
	
	public static <T> T getFormazioniFGEJB() throws NamingException {
		return (T) lookupEjb("FormazioniFGSeamEJB", FormazioniFGSeamRemote.class);
	}
	
	public static <T> T getFormazioniGazzettaEJB() throws NamingException {
		return (T) lookupEjb("FormazioniGazzettaSeamEJB", FormazioniGazzettaSeamRemote.class);
	}
	
	public static <T> T getSquadreEJB() throws NamingException {
		return (T) lookupEjb("SquadreSeamEJB", SquadreSeamRemote.class);
	}
	
	public static <T> T getStatisticheEJB() throws NamingException {
		return (T) lookupEjb("StatisticheSeamEJB", StatisticheSeamRemote.class);
	}

}
